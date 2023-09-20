import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const jwtToken = localStorage.getItem("JWT_TOKEN");

    if (jwtToken) {
      const updatedReq = request.clone({
        headers: request.headers.set("Authorization", "Bearer " + jwtToken)
      });
      console.log("AuthInterceptor updated request: ", updatedReq);
      return next.handle(updatedReq);
    }
    else {
      return next.handle(request);
    }
  }
}
