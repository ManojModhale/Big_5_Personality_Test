import { Component } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css',
})
export class WelcomeComponent {

  images = [
    "./assets/Images/F1.jpg",
    "./assets/Images/F2.png",
    "./assets/Images/F3.jpg",
    "./assets/Images/F4.jpg"
  ];

	paused = false;
	unpauseOnArrow = false;
	pauseOnIndicator = false;
	pauseOnHover = true;
	pauseOnFocus = true;

  ngOnInit(): void {

    const security:boolean=false;
    sessionStorage.setItem("token",JSON.stringify(security));
  }

  
  
}
