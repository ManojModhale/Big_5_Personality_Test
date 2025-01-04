import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExamtimeService {
  private startTime: Date | null = null;

  
  startExam(): void {
    this.startTime = new Date();
  }

  getStartTime(): Date | null {
    return this.startTime;
  }
}
