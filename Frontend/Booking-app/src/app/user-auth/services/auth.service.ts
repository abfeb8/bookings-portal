import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthenticationResponse } from 'src/app/interfaces/user-authentication-response';
import { UserLoginRequest } from 'src/app/interfaces/user-login-request';
import { JwtServiceService } from './jwt-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userUri: string = 'http://localhost:8080/auth';

  constructor(private http: HttpClient, private jwtService: JwtServiceService) { }

  login(loginRequest: UserLoginRequest) {
    this.jwtService.clearSession();
    return this.http.post<UserAuthenticationResponse>(`${this.userUri}/login`, loginRequest);
  }

  isUserLoggedIn() {
    return this.jwtService.getJwtToken() !== null;
  }
}
