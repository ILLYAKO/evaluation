https://youtu.be/kgTaJzI7sfM
Login Registration Form Restful Api Using Spring boot Angular
Tutus Funny (https://www.tutussfunny.com/login-registration-form-using-spring-boot-angular/)

51:12 // Create Angular front end
// check installed Angular
ng version
// if not installed run
npm install -g @angular/cli

53:13 // Create new project
ng new client
54:10 // Run frontend 'client'
ng serve
56:33 // Clean app.component.html
57:33 // Generate new component register
ng g c register
// add bootstrap form
58:14 // Generate new component login
ng g c login
// create routing
ng generate module app-routing --flat --module=app
// Replace it with the following:
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { HeroesComponent } from './heroes/heroes.component';

// const routes: Routes = [{ path: 'heroes', component: HeroesComponent }];

@NgModule({
  // imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

1:01:25 // import module to app.module.ts
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
...
imports: [
...
FormsModule,
HttpClientModule
...

1:03:51 // Registration form
1:03:53 //  add variables to register.component.ts and method save()
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  userArray: any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

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
      .post('http://localhost:8085/api/v1/user', bodyData, {
        responseType: 'text',
      })
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('User was registered Successfully.');
      });
  }
}

1:06:17 //  Add selector <app-register> to app.component.html
1:07:06 // Set up bootstrap add link to index.html
 // following instruction https://getbootstrap.com/













