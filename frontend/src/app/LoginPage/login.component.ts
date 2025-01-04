import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  private baseUrl:any = 'http://localhost:8182/user'; 

  constructor(private http: HttpClient,private router: Router) { 

  }

  loginForm=new FormGroup({
    username:new FormControl("",[Validators.required,Validators.pattern(/^\S*$/)]),
    password:new FormControl("",[Validators.required ]),
    
  });
  
  

  get username():any{
    return this.loginForm.get('username');
  }

  get password():any{
    return this.loginForm.get('password')
  }

  myForm:any;
 
  onLogin(){
    this.myForm=this.loginForm;

    if (this.myForm.valid) {
      const loginData = new FormData();
      loginData.append('username', this.username.value);
      loginData.append('password', this.password.value);
  
      this.http.post(this.baseUrl + "/login", loginData)
        .subscribe(
          response => {
            if(response!=null)
            {
              // alert("Login Successfully")
              // console.log('Login successful', response);

              const loggedUser=response;

              //console.log("Logged User "+loggedUser);
              sessionStorage.setItem("LoggedUser", JSON.stringify(loggedUser));
              localStorage.setItem("LoggedUser", JSON.stringify(loggedUser));

              const security:boolean=true;
              sessionStorage.setItem("token",JSON.stringify(security));
              //sessionStorage.setItem("loggedUser",loggedUser);

              Swal.fire({
                icon: 'success',
                title: 'Login Successful!',
                text: 'Welcome back!',
              });
              
              this.router.navigateByUrl("/home");
            }
            else{
              // alert("Wrong Credentials")
              // console.log('Wrong User', response);

              Swal.fire({
                icon: 'error',
                title: 'Wrong Credentials',
                text: 'Please check your username and password.',
              });
            }       
          },
          error => {

            // console.error('Login failed', error);

            Swal.fire({
              icon: 'error',
              title: 'Login Failed',
              text: 'Invalid username or password. Please try again.',
            });

          }
        );
    
        }
  }
}
