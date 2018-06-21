import { Component, OnInit } from '@angular/core';
import { PollService } from '../../services/poll.service';
import { Poll } from '../../models/poll.model';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';


@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit {
  constructor(private pollService: PollService, private route: ActivatedRoute, private router: Router) { }

  poll: Poll;
  options = [];
  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel;
  showYAxisLabel = true;
  yAxisLabel = 'Votes';
  responsive: true;
  maintainAspectRatio: false;

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };
  ngOnInit() {
    this.route.params.pipe(
      switchMap(params => this.pollService.getPoll(params['id'])))
      .subscribe(poll => {
        this.poll = poll;
        this.options = [];
        this.poll.options.forEach(option => {
          this.options.push({
            'name': option.option,
            'value': option.score
          });
          this.xAxisLabel = this.poll.title;
        });
      }, error => {
        console.log(error);
      });
  }

  onSelect(event) {
    console.log(event);
  }
}
