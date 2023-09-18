import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtServiceService {

  private jwtTokenKey: string = "JWT_TOKEN";

  constructor() { }

  saveJwtToken(jwtTokenString: string): void {
    localStorage.setItem(this.jwtTokenKey, jwtTokenString)
  }

  getJwtToken(): string | null {
    return localStorage.getItem(this.jwtTokenKey);
  }
}
