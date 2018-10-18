import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { Router } from '../../node_modules/@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  userId:string;
  private loggedIn = new BehaviorSubject<boolean>(false);

  constructor(private httpClient: HttpClient,
  private router: Router) { }

  getCurrentUserId():string {
    
    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/session", {withCredentials:true})
      .subscribe( (data:any) => {
        if(data!=null){
          this.userId = data.userId;
        }
      });
      return this.userId;
  }

  getSessionPromise():Promise<string> {
    return this.httpClient.get<string>("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/session", {withCredentials:true}).toPromise();
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  isValidSession(bool:boolean){
    this.loggedIn.next(bool);
  }

  login(username, password){

    
    const headers = {
      headers: new HttpHeaders({
        'Content-Type':  'application/x-www-form-urlencoded',
      }), withCredentials:true
    };   

    let body = `userName=${username}&pswd=${password}`;

    this.httpClient.post("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/login",body,  headers )
    .subscribe( (data:any) => {
      if(data){
        this.router.navigateByUrl('/home');
        this.isValidSession(true);
      }
    });

  }

  logout(){
    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/logout",{withCredentials:true}).subscribe();
    this.isValidSession(false);
  }

  getUserRecipes(userId):any{
    let response;
      this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes/users/"+userId)
      .subscribe( (data:any) => {
    
          for (var i=0; i<data.length; i++){
            data[i].recipeJSON = JSON.parse(data[i].recipeJSON);
    
          }
    
          
          response = data;
          
        });

        return response;
  }

}
