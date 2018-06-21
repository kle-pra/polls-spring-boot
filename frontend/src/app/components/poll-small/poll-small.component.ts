import { FlashMessagesService } from 'angular2-flash-messages';
import { Component, OnInit, Input } from '@angular/core';
import { PollService } from '../../services/poll.service';
import { Poll } from '../../models/poll.model';

@Component({
  selector: 'app-poll-small',
  templateUrl: './poll-small.component.html',
  styleUrls: ['./poll-small.component.css']
})
export class PollSmallComponent implements OnInit {

  @Input() poll: Poll;
  selected: number;
  votingEnded = false;

  constructor(private pollService: PollService, private flashMessagesService: FlashMessagesService) { }

  ngOnInit() {
    const now = new Date();

    if (new Date(this.poll.endDate).getTime() < now.getTime()) {
      this.votingEnded = true;
    }
  }

  vote() {
    this.pollService.vote(this.poll.id, this.selected).subscribe(success => {
      this.poll.voted = true;
      this.flashMessagesService.show('Vote submitted!', { cssClass: 'card-panel green lighten-4', timeout: 3000 });
    }, error => {
      console.log(error);
      this.flashMessagesService.show('You can\'t vote twice', { cssClass: 'card-panel red lighten-3', timeout: 3000 });
    });
  }

}
