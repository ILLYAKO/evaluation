import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BoundElementProperty } from '@angular/compiler';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private router: Router, private http: HttpClient) {}

  login() {
    console.log(this.email);
    console.log(this.password);

    let bodyData = {
      email: this.email,
      password: this.password,
    };

    this.http
      .post('http://localhost:9095/api/v1/user/login', bodyData)
      .subscribe((resultData: any) => {
        console.log(resultData);
        if (resultData.message == 'Email not exist') {
          alert('Email not exist');
        } else if (resultData.message == 'Login Success') {
          this.router.navigateByUrl('/home');
        } else {
          alert('Incorrect Email and Password not match');
        }
      });
  }
}
