import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { UserInterface } from '../common.models';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public user: UserInterface;

  constructor(private appService: AppService, private route: Router) { 
    this.user = {
      username: "",
      password: ""
    }
  }

  ngOnInit(){
  }

  login() {
    this.appService.login(this.user).subscribe((res: UserInterface) => {
      window.localStorage.setItem('username', res.username);
      this.route.navigate(['/menu']);
    });
  }

}
