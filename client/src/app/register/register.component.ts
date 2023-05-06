import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  // userArray: any[] = [];
  // isResultLoaded = false;
  // isUpdateFormActive = false;

  userName: string = '';
  email: string = '';
  password: string = '';

  constructor(private http: HttpClient) {}

  save() {
    let bodyData = {
      userName: this.userName,
      email: this.email,
      password: this.password,
    };
    this.http
      .post('http://localhost:9095/api/v1/user/save', bodyData, {
        responseType: 'text',
      })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('User was registered Successfully.');
      });
  }
}
