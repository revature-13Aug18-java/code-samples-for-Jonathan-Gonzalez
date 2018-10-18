import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SessionService } from '../session.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  
  isLoggedIn: Observable<boolean>;

  constructor(private route: ActivatedRoute,
    private router: Router, private sessionService: SessionService) { }


  recipeSearch: string;

  ngOnInit() {
    this.sessionService.getSessionPromise().then((data:any) => {
      if(data){
        this.sessionService.isValidSession(true);
      }
        })
    this.isLoggedIn = this.sessionService.isLoggedIn;
  }

}
