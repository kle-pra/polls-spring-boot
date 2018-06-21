export class Poll {

  id: string;
  title: string;
  options: [{
    option: String,
    score: Number,
  }];
  user: string;
  endDate: Date;
  voted?: Boolean;

  constructor() {
    this.voted = false;
  }
}
