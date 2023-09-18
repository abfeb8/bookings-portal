import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/class/user-class/user';
import { UserService } from 'src/app/user-auth/services/user.service';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  registrationForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(
      {
        firstName: ["", Validators.required],
        lastName: ["", Validators.required],
        email: ["", Validators.required],
        username: ["", Validators.required],
        password: ["", Validators.required]
      }
    )
  }

  submit() {
    console.log(this.registrationForm);
    const user: User = this.registrationForm.value;
    console.log(user);
    this.userService.creatUser(user).subscribe(
      {
        next: val => console.log('Server Response: ', val),
        error: err => console.log('Error: ', err),
        complete: () => console.log("user creation request complete")
      }
    )
  }
}
