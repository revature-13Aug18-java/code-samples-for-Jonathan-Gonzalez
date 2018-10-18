import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Recipe } from '../../models/Recipe';

export class SearchComponent {
  recipe: Recipe;
  recipes: Recipe[];
  userId: string;
  response:any;
  search: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.getSession();
  }


  saveRecipe(json){ 


    const headers = {
      headers: new HttpHeaders({
        'Content-Type':  'application/x-www-form-urlencoded'
      })
    };
   
    this.recipe = {
      userId: this.userId,
      JSON: json,
      saved: null

    }

    let body = `userId=${this.recipe.userId}&JSON=${JSON.stringify(this.recipe.JSON)}`;

    this.httpClient.post("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/recipes/save",body,  headers )
    .subscribe( (data:any) => {
      this.response = data.recipes;
    });

    this.ngOnInit();
  }

  getSession() {
    this.httpClient.get("http://ec2-18-232-121-144.compute-1.amazonaws.com:8080/lesoptimates.project2.backend/session", {withCredentials:true})
      .subscribe( (data:any) => {
        if(data!=null){
          this.userId = data.userId;
          console.log(this.userId);
        }
      });
  }

}
