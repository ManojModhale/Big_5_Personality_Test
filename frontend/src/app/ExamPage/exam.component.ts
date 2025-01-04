import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ExamtimeService } from '../All-Servicess/examtime.service';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  //styleUrl: './exam.component.css'
  styleUrls: ['./exam.component.css', '../HomePage/home.component.css']
})
export class ExamComponent {

  isCheckboxChecked = false;
  security: any;

  constructor(private router: Router,private examtimer:ExamtimeService) { 

  }

  ngOnInit(): void {
    let token:any=sessionStorage.getItem("token");
    if(token)
    {
      this.security= JSON.parse(token);
    if(this.security==false || this.security==null)
    {
      this.router.navigateByUrl('/login');
    }
    }
    
    
  }

  startExam(){
    if (this.isCheckboxChecked) {
      console.log('Redirecting to the exam component...');
      this.examtimer.startExam();
      this.router.navigateByUrl('/question');
    } 
    else {
      console.log('Checkbox is not checked. Display validation message.');
      
    }
  }

}
