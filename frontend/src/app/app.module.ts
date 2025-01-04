import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './WelcomePage/welcome.component';
import { LoginComponent } from './LoginPage/login.component';
import { RegisterComponent } from './RegistrationPage/register.component';
import { CarouselComponent } from './carousel/carousel.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbCarouselModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProfileComponent } from './ProfilePage/profile.component';
import { EditcompComponent } from './EditProfile/editcomp/editcomp.component';
import { HomeComponent } from './HomePage/home.component';
import { TestComponent } from './Testing/test.component';
import { HttpClientModule } from '@angular/common/http';
import { ExamComponent } from './ExamPage/exam.component';
import { ChangePasswordComponent } from './ForgotPassword/change-password.component';
import { TimerComponent } from './Timer/timer/timer.component';
import { QuestionComponent } from './QuestionPage/question.component';
import { TestFComponent } from './TestingF/test-f.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule, MatLabel} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { NotfoundComponent } from './NotfoundPage/notfound.component';
import { ExamtimeService } from './All-Servicess/examtime.service';
import { SendAnswersService } from './All-Servicess/send-answers.service';
import { QuestionService } from './All-Servicess/question.service';
import { GetAllTestsService } from './All-Servicess/get-all-tests.service';
import { DashboardComponent } from './DasboardPage/dashboard.component';
import { LogoutComponent } from './LogoutPage/logout.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    RegisterComponent,
    CarouselComponent,
    ProfileComponent,
    EditcompComponent,
    ChangePasswordComponent,
    CarouselComponent,
    HomeComponent,
    TestComponent,
    ExamComponent,
    TimerComponent,
    QuestionComponent,
    TestFComponent,
    TimerComponent,
    DashboardComponent,
    LogoutComponent,
    NotfoundComponent,
    DashboardComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    NgbCarouselModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
  ],
  providers: [ExamtimeService,SendAnswersService,QuestionService,GetAllTestsService],
  bootstrap: [AppComponent]
})

export class AppModule {
  
 }
