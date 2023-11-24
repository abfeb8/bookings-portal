import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/class/user-class/user';
import { UserService } from 'src/app/user-auth/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  private username: string | null = null
  user: User | undefined

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.username = localStorage.getItem("LOGGED_IN_USER")
    if (this.username) {
      this.userService.getUser(this.username).subscribe(
        {
          next: val => {
            console.log("Server response", val);
            this.user = val;
          },
          error: err => console.log("Error", err),
          complete: () => console.log("Get user call complete")
        }
      )
    }
  }

}
