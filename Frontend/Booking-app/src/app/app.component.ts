import { Component } from '@angular/core';
import { AuthService } from './user-auth/services/auth.service';
import { JwtServiceService } from './user-auth/services/jwt-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Booking-app';

  constructor(private authService: AuthService, private jwtService: JwtServiceService, private router: Router) { }

  isUserLoggedIn(): boolean {
    return this.authService.isUserLoggedIn();
  }

  logout() {
    this.jwtService.clearSession();
    this.router.navigate(['/home']);
  }
}
