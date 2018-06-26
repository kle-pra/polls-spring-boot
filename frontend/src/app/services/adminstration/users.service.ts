import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get('api/user');
  }

  deleteUser(id: number): any {
    return this.http.delete('api/user/' + id);
  }
}
