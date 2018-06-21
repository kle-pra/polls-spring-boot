import { AddPollComponent } from './components/add-poll/add-poll.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PollComponent } from './components/poll/poll.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MyPollsComponent } from './components/my-polls/my-polls.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'my-polls', canActivate: [AuthGuard], component: MyPollsComponent },
  { path: 'add-poll', canActivate: [AuthGuard], component: AddPollComponent },
  { path: 'poll/:id', component: PollComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
