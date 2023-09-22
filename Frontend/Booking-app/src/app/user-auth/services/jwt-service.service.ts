import { Injectable } from '@angular/core';
import { UserAuthenticationResponse } from 'src/app/interfaces/user-authentication-response';

@Injectable({
  providedIn: 'root'
})
export class JwtServiceService {

  private jwtTokenKey: string = "JWT_TOKEN";
  private loggedInUserKey: string = "LOGGED_IN_USER";

  constructor() { }

  saveJwtToken(aurhResponse: UserAuthenticationResponse): void {
    localStorage.setItem(this.jwtTokenKey, aurhResponse.authToken)
    localStorage.setItem(this.loggedInUserKey, aurhResponse.username)
  }

  getJwtToken(): string | null {
    return localStorage.getItem(this.jwtTokenKey);
  }

  clearSession() {
    localStorage.removeItem(this.jwtTokenKey);
    localStorage.removeItem(this.loggedInUserKey);
  }
}
