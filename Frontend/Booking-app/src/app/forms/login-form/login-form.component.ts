import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserLoginRequest } from 'src/app/interfaces/user-login-request';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Output() onLogin = new EventEmitter<UserLoginRequest>();

  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group(
      {
        username: ["", Validators.required],
        password: ["", Validators.required]
      }
    )
  }

  submit() {
    console.log(this.loginForm);

    const loginRequest: UserLoginRequest = this.loginForm.value;
    console.log(loginRequest);

    this.onLogin.emit(loginRequest);
  }

}
