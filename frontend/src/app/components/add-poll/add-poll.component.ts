import { FlashMessagesService } from 'angular2-flash-messages';
import { PollService } from './../../services/poll.service';
import { Component, OnInit } from '@angular/core';
import { Poll } from '../../models/poll.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-poll',
  templateUrl: './add-poll.component.html',
  styleUrls: ['./add-poll.component.css']
})

export class AddPollComponent implements OnInit {

  options: string[] = [];
  poll: Poll = {
    id: null,
    title: null,
    endDate: new Date(),
    options: null,
    user: null
  };

  constructor(private pollService: PollService, private router: Router, private flashMessagesService: FlashMessagesService) { }

  ngOnInit() {
  }

  addOption(option: string) {
    if (option !== undefined && option != null && option !== '') {
      this.options.push(option);
    }
  }

  removeOption(optionDel: string) {
    this.options = this.options.filter(option => option !== optionDel);
  }


  onSubmitPollForm(f) {

    this.options.forEach(option => {
      if (this.poll.options == null) {
        this.poll.options = [{
          option: option,
          score: 0
        }];
      } else {

        this.poll.options.push({
          option: option,
          score: 0
        });

      }

    });
    this.poll.endDate = new Date(f.value.endDate);
    this.pollService.savePoll(this.poll).subscribe(success => {
      this.router.navigate(['']);
      this.flashMessagesService.show('Successfully added!', { cssClass: 'card-panel green lighten-4', timeout: 3000 });
    }, error => {
      console.log(error);
      this.flashMessagesService.show(JSON.stringify(error), { cssClass: 'card-panel red lighten-3', timeout: 3000 });
    });
  }

}
