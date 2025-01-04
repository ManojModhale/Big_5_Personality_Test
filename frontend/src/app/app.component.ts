import { Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Big-Five-Personality-Test';

  
}

/*
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  ngOnInit(): void {
    this.fadeOut();
    throw new Error('Method not implemented.');
  }

  loader() {
    const loaderContainer = document.querySelector(".loader-container");
    if (loaderContainer) {
      loaderContainer.classList.add("fade-out");
    }
  }

  fadeOut() {
    setInterval(() => {
      this.loader();
    }, 300);
  }

  title = 'Big-Five-Personality-Test';

  
}

 */
