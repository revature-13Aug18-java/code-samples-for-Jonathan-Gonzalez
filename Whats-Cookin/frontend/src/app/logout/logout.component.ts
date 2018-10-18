import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../session.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private router: Router,
    private sessionService: SessionService) {  }

  ngOnInit() {
    this.sessionService.logout();
    this.router.navigateByUrl('/login');
    
  }
}
