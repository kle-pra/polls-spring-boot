import { Poll } from './../models/poll.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class PollService {

  constructor(private http: HttpClient) { }

  getPolls(): Observable<any> {
    return this.http.get('api/polls');
  }

  getPollsForUser(): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('jwt') !== null ? localStorage.getItem('jwt') : ''
      })
    };
    return this.http.get('api/polls/user', httpOptions);
  }

  getPoll(id): Observable<any> {
    return this.http.get('api/polls/' + id);
  }

  savePoll(poll: Poll): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('jwt') !== null ? localStorage.getItem('jwt') : ''
      })
    };
    return this.http.post('api/polls', poll, httpOptions);
  }

  deletePoll(pollId: any): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('jwt') !== null ? localStorage.getItem('jwt') : ''
      })
    };
    return this.http.delete('api/polls/' + pollId, httpOptions);
  }

  vote(pollId: string, selectedOption: number): Observable<any> {
    return this.http.post('api/polls/' + pollId + '/vote/' + selectedOption, {});
  }
}
