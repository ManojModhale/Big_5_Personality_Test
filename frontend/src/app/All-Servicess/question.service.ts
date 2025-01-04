import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  
  questions: any[] = [];
  private currentQuestionIndex: number = 0;
  private userResponses: any[] = [];
  private questionsLoaded: boolean = false; 

  currentQuestion$ = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) {}

  loadQuestions() {
    if (!this.questionsLoaded) {
      this.http.get<any>('assets/question.json').subscribe(
        (response) => {
          this.questions = response.questions;
          console.log('Questions loaded:', this.questions);
          this.currentQuestionIndex = 0;
          this.nextQuestion();
          this.questionsLoaded = true;
        },
        (error) => {
          console.error('Error loading questions:', error);
        }
      );
    }
  }
  

  getCurrentQuestion() {
    return this.questions[this.currentQuestionIndex];
  }

  nextQuestion() {
    if (this.questions && this.currentQuestionIndex < this.questions.length) {
      this.currentQuestion$.next(this.questions[this.currentQuestionIndex]);
      this.currentQuestionIndex++;
    } 
    else {    
      console.log('End of questions');
    }
  }
  

  recordUserResponse(response: any) {
    this.userResponses.push(response);
    this.nextQuestion();
  }

  getUserResponses() {
    return this.userResponses;
  }

  isLastQuestion(): boolean {
    return this.currentQuestionIndex === this.questions.length - 1;
  }
}
