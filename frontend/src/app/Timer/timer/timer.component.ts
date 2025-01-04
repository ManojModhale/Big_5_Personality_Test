import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrl: './timer.component.css'
})
export class TimerComponent implements OnInit,OnDestroy{

  timeLeft: number = 150; // Initial time in seconds (5 minutes)
  timerRunning: boolean = false;
  timerSubscription: Subscription | undefined;

  constructor() { }

  ngOnInit() {
    this.startTimer();
  }

  startTimer() {
    if (!this.timerRunning) {
      this.timerRunning = true;
      this.timerSubscription = interval(1000).subscribe(() => {
        this.timeLeft--;
        if (this.timeLeft <= 0) {
          this.stopTimer();
        }
      });
    }
  }

  stopTimer() {
    this.timerRunning = false;
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
  }

  formatTime(): string {
    const minutes: string = Math.floor(this.timeLeft / 60).toString().padStart(2, '0');
    const seconds: string = (this.timeLeft % 60).toString().padStart(2, '0');
    return `${minutes}:${seconds}`;
  }

  ngOnDestroy() {
    this.stopTimer();
  }  




}
