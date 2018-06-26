import { UsersService } from './../../../services/adminstration/users.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  constructor(private userService: UsersService) { }


  ngOnInit() {
    this.userService.getUsers().subscribe((users: any) => {
      console.log(users);
      // this.rows = users;
    }, error => {
      console.log(error);
    });
  }

}
