import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/class/user-class/user';
import { Observable } from 'rxjs';
import { UserAuthenticationResponse } from 'src/app/interfaces/user-authentication-response';
import { UserLoginRequest } from 'src/app/interfaces/user-login-request';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userUri: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  creatUser(user: User): Observable<UserAuthenticationResponse> {
    return this.http.post<UserAuthenticationResponse>(`${this.userUri}/user/create`, user);
  }

  login(loginRequest: UserLoginRequest) {
    return this.http.post<UserAuthenticationResponse>(`${this.userUri}/auth/login`, loginRequest);
  }
}
