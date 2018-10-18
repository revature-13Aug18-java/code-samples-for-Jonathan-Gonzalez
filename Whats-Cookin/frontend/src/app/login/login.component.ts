import { Component, OnInit, Input } from '@angular/core';
import { SessionService } from '../session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() username: string;
  @Input() password: string;

  constructor(private sessionService: SessionService) {  }
  
  
  ngOnInit() {}

  login(){
    this.sessionService.login(this.username,this.password);
  }

  logout(){
    this.sessionService.logout();
  }

}
