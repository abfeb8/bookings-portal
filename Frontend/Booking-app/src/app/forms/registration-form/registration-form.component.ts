import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/class/user-class/user';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  registrationForm!: FormGroup;
  user!: User;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(
      {
        fname: ["", Validators.required],
        lname: ["", Validators.required],
        email: ["", Validators.required],
        userName: ["", Validators.required],
        password: ["", Validators.required]
      }
    )
  }

  submit() {
    console.log(this.registrationForm);
    this.user = this.registrationForm.value;
    console.log(this.user);
  }
}
