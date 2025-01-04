import { Component } from '@angular/core';
import { ExamtimeService } from '../All-Servicess/examtime.service';
import { SendAnswersService } from '../All-Servicess/send-answers.service';
import { QuestionService } from '../All-Servicess/question.service';
import { Subject, takeUntil } from 'rxjs';
import { Router } from '@angular/router';
import { TimerComponent } from '../Timer/timer/timer.component';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})
export class QuestionComponent {

  showTimer: boolean = true;
  currentQuestion: any;
  selectedOption: string | null = null;
  private destroy$ = new Subject<void>();
  security: any;

  constructor(private router: Router,private examtimer:ExamtimeService,private sendanswer:SendAnswersService,private questionService: QuestionService){

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
      
 

    this.questionService.loadQuestions();
    this.questionService.currentQuestion$
      .pipe(takeUntil(this.destroy$))
      .subscribe((question) => {
        this.currentQuestion = question;
        this.selectedOption = this.currentQuestion?.options[this.currentQuestion?.defaultIndex || 0];
        console.log('Current Question:', this.currentQuestion);
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
    
  onButtonClick(): void {
    console.log('Button Clicked');
    if (this.isLastQuestion) {
      this.submitResponses();
    } else {
      this.nextQuestion();
    }
  }
  
    
    nextQuestion(): void {
      
      if (this.currentQuestion) {
        const response = {
          questionId: this.currentQuestion.id,
          questionType: this.currentQuestion.questionType,
          selectedOption: this.selectedOption,
          personalityTrait: this.currentQuestion.personalityTrait 
        };
    
        console.log('Current response:', response);
    
        this.questionService.recordUserResponse(response);
        this.questionService.nextQuestion();
      }
    }
    
    
    
    get isLastQuestion(): boolean {
      const isLast = this.questionService.isLastQuestion();
      return isLast;
    }
    
  
    selectOption(event: any): void {
      const target = event.target;
      this.selectedOption = target.value;
    }
  
  
    submitResponses(): void {
      const LoggedUser = sessionStorage.getItem("LoggedUser");
      this.showTimer = false;
      if(LoggedUser)
      {
      let parsedUser = JSON.parse(LoggedUser);
      const username1=parsedUser.username;
      const responses = this.questionService.getUserResponses();
      const examstartTime=this.examtimer.getStartTime();
      //console.log("At Last exam started at :: ",examstartTime);
      this.sendanswer.submitResponsesToBackend(username1, examstartTime,responses);

      console.log('Submitted Responses:', responses);

      this.showResponsesSubmittedAlert();

      this.router.navigateByUrl('/dashboard');
      
      }
      
    }

    private showResponsesSubmittedAlert() {
      Swal.fire({
        icon: 'success',
        title: 'Responses Submitted!',
        text: 'Your responses have been submitted successfully.',
      });
    }



}
