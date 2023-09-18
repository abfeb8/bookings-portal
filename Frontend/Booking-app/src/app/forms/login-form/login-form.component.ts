import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserLoginRequest } from 'src/app/interfaces/user-login-request';
import { UserService } from 'src/app/user-auth/services/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

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

    this.userService.login(loginRequest).subscribe(
      {
        next: val => console.log('Server Response: ', val),
        error: err => console.log('Error: ', err),
        complete: () => console.log("user creation request complete")
      }
    )
  }

}
