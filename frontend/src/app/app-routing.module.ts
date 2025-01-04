import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './WelcomePage/welcome.component';
import { LoginComponent } from './LoginPage/login.component';
import { RegisterComponent } from './RegistrationPage/register.component';
import { HomeComponent } from './HomePage/home.component';
import { ChangePasswordComponent } from './ForgotPassword/change-password.component';
import { ExamComponent } from './ExamPage/exam.component';
import { ProfileComponent } from './ProfilePage/profile.component';
import { EditcompComponent } from './EditProfile/editcomp/editcomp.component';
import { QuestionComponent } from './QuestionPage/question.component';
import { DashboardComponent } from './DasboardPage/dashboard.component';
import { LogoutComponent } from './LogoutPage/logout.component';
import { NotfoundComponent } from './NotfoundPage/notfound.component';

const routes: Routes = [
  {path:'',component:WelcomeComponent},
  {path:'login',component:LoginComponent},
  {path:'forgotpass',component:ChangePasswordComponent},
  {path:'newuser',component:RegisterComponent},
  {path:'home',component:HomeComponent},
  {path:'exam',component:ExamComponent},
  {path:'question',component:QuestionComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'profile',component:ProfileComponent},
  {path:'editprofile',component:EditcompComponent},
  {path:'logout',component:LogoutComponent},
  {path:'**',component:NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
 
}
