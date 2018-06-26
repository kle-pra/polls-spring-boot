import { UsersService } from './../../../services/adminstration/users.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private userService: UsersService) { }

  users = [];

  ngOnInit() {
    this.userService.getUsers().subscribe((users: any) => {
      console.log(users);
      this.users = users;
    }, error => {
      console.log(error);
    });
  }

  deleteUser(id) {
    this.userService.deleteUser(id).subscribe(success => {
      this.users = this.users.filter(user => user.id != id);
    }, error => {
      console.log(error);
    });
  }
}