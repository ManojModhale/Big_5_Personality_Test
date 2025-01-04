import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent {
  private baseUrl:any = 'http://localhost:8182/user'; 

  isSubmited:boolean=false;

  constructor(private http: HttpClient,private router: Router) { 

  }

  registerForm=new FormGroup({

    firstname:new FormControl("",[Validators.required,Validators.pattern(/^[A-Z][a-z]*$/)]),
    lastname:new FormControl("",[Validators.required,Validators.pattern(/^[A-Z][a-z]*$/)]),
    gender:new FormControl("",[Validators.required]),
    email:new FormControl("",[Validators.required,Validators.email]),
    mobileno:new FormControl("",[Validators.required,Validators.pattern(/^[0-9]{10}$/)]),
    designation:new FormControl("",[Validators.required]),
    qualification:new FormControl("",[Validators.required]),
    username:new FormControl("",[Validators.required,Validators.pattern(/^\S*$/)]),
    password:new FormControl("",[Validators.required,Validators.minLength(8),Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&]).{4,20}$/)]),
    confirmpass:new FormControl("",[Validators.required, this.matchPassword.bind(this)]),
  

  });

  get firstname():any{
    return this.registerForm.get('firstname');
  }

  get lastname():any{
    return this.registerForm.get('lastname');
  }

  get gender():any{
    return this.registerForm.get('gender');
  }

  get email():any{
    return this.registerForm.get('email');
  }

  get mobileno():any{
    return this.registerForm.get('mobileno');
  }

  get designation():any{
    return this.registerForm.get('designation');
  }

  get qualification():any{
    return this.registerForm.get('qualification');
  }

  get username():any{
    return this.registerForm.get('username');
  }

  get password():any{
    return this.registerForm.get('password');
  }

  get confirmpass():any{
    return this.registerForm.get('confirmpass');
  }

  matchPassword(control: AbstractControl): { [key: string]: boolean } | null {
    if (!this.registerForm || !this.registerForm.get('password')) {
      console.error('Form or password control not initialized.');
      return { 'passwordMismatch': true }; 
    }

    const password = this.registerForm.get('password')?.value;
    const confirmPassword = control.value;

    return password === confirmPassword ? null : { 'passwordMismatch': true };
  }

  myForm:any;

  onReset(){
    this.myForm=this.registerForm;
    this.myForm.resetForm();
  }

  onRegister() {
    this.isSubmited = true;
    this.myForm = this.registerForm;

    if (this.registerForm.valid) 
    {

      const registeringData = {
        firstname: this.myForm.value.firstname,
        lastname: this.myForm.value.lastname,
        gender: this.myForm.value.gender,
        email: this.myForm.value.email,
        mobileno: +this.myForm.value.mobileno,
        designation: this.myForm.value.designation,
        qualification: this.myForm.value.qualification,
        username: this.myForm.value.username,
        password: this.myForm.value.password,
        confirmpass: this.myForm.value.confirmpass
      };

      console.log(registeringData);

      this.http.post(this.baseUrl + "/newuser", registeringData).subscribe(
        (response: any) => {
          // Handle success response
          // alert("Registered successfully!");
          console.log(response);

          Swal.fire({
            icon: 'success',
            title: 'Registration Successful!',
            text: 'Thank you for registering!',
          });

          this.router.navigateByUrl('/login');

          
          
        },
        (error: any) => {
          // Handle error response
          // alert("Error in registration: " + error.message);
          console.error('Error Register:', error);

          Swal.fire({
            icon: 'error',
            title: 'Error in Registration',
            text: 'There was an error during registration. Please try again later.',
          });
          
        }
      );
      
    } 
    
  }

  
  
}
  






