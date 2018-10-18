import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Recipe } from '../models/Recipe';
import { HttpHeaders } from '@angular/common/http';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor(private httpClient: HttpClient,
  private sessionService: SessionService) { }
  chefsUrl:string = "api/chefs/";
  recipeUsersUrl:string = "api/recipeChefs/";
  recipe: Recipe;

  response:any;

  showRecipe() {
    this.httpClient.get("https://www.food2fork.com/api/search?key=1f15f4b4b0d1f534478e53ac0e52e894")
      .subscribe( (data:any) => {
        this.response = data.recipes;
      });
  }

  showUserRecipes(){

    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes")
    .subscribe( (data:any) => {
  
      for (var i=0; i<data.length; i++){
        data[i].recipeJSON = JSON.parse(data[i].recipeJSON);
  
      }
  
      console.log(data);
      this.response = data;
      
    });

  }


  saveRecipe(userId, json){ 
    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes")
      .subscribe( (data:any) => {
        for (var i=0; i<data.length; i++){
          data[i].recipeJSON = JSON.parse(data[i].recipeJSON);
        }
        console.log(data);
        this.response = data;
      });
  }

  deleteRecipe(recipeId){ 
    const headers = {
      headers: new HttpHeaders({
        'Content-Type':  'application/x-www-form-urlencoded'
      })
    };

    let body = `recipeId=${recipeId}`;

    this.httpClient.post("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes/delete",body,  headers )
    .subscribe( (data:any) => {
      this.response = data.recipes;
    });

  }

  returnUserRecipes(user):any{

    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes"+user)
    .subscribe( (data:any) => {
  
      for (var i=0; i<data.length; i++){
        data[i].recipeJSON = JSON.parse(data[i].recipeJSON);
      }
      return data;
    });

  }

}
