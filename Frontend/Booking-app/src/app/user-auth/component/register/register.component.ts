import { Component } from '@angular/core';
import { User } from 'src/app/class/user-class/user';
import { UserService } from '../../services/user.service';
import { JwtServiceService } from '../../services/jwt-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  private user: User | undefined;

  constructor(private userService: UserService, private jwtService: JwtServiceService) { }

  registerUser(newUser: User): void {
    this.jwtService.clearSession();
    this.userService.creatUser(newUser).subscribe(
      {
        next: val => {
          console.log('Server Response: ', val);
          this.jwtService.saveJwtToken(val);
        },
        error: err => console.log('Error: ', err),
        complete: () => console.log("User creation request complete")
      }
    )
  }
}
