import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { UserLoginRequest } from 'src/app/interfaces/user-login-request';
import { JwtServiceService } from '../../services/jwt-service.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService: AuthService, private jwtService: JwtServiceService) { }

  login(loginRequest: UserLoginRequest): void {
    this.authService.login(loginRequest).subscribe(
      {
        next: val => {
          console.log('Server Response: ', val);
          this.jwtService.saveJwtToken(val.authToken);
        },
        error: err => console.log('Error: ', err),
        complete: () => console.log("User login request complete")
      }
    )
  }

}
