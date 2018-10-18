/// <reference path="../../../../node_modules/@types/googlemaps/index.d.ts" />
import { OnInit, NgZone, AfterContentInit, OnDestroy } from '@angular/core';
import { MapsControllerService } from '../../services/api/maps-controller.service';
import { HttpClient } from '@angular/common/http';
import { MatchingControllerService } from '../../services/api/matching-controller.service';
import { UserControllerService } from '../../services/api/user-controller.service';
import { Router } from '@angular/router';

export class MapComponent implements OnInit, OnDestroy, AfterContentInit {

  /** Holds list of markers on map representing Users */
  markers: any[] = [];

  /** Holds the map in the compnent */
  map: google.maps.Map;

  /** Stores list of users favorited locations */
  favoriteLocations: any[] = [];

  /**Toggles delete functionality in the view */
  showFavorites: boolean = true;


  /**
   * Holds a current map marker that could appear on a Google map
   */
  marker: google.maps.Marker;

  /** Stores the value of our text box locally*/
  selectedLocation: string;

  /**Store name of saved location into textbox locally **/
  favoriteName: string;

   /**Store name location to delete into textbox locally **/
   deleteFavorite: string;


  constructor(
    private matchService: MatchingControllerService, 
    private userService: UserControllerService,
    private mapService: MapsControllerService, 
    private zone: NgZone,
    private route: Router,
    private http: HttpClient
    ) { }

  /** Retrieves the current list of user's favorite locations*/
  getLocations(){
    this.showFavorites = !this.showFavorites;
    this.http.get<any>('http://ec2-35-174-153-234.compute-1.amazonaws.com:3333/favoritelocations/users/'+sessionStorage.getItem('id')).subscribe(favorites => {
      //this.tokenStorage.saveToken(token);)
      let marker:any;
      for(let favorite of favorites){
        let fav_location = new google.maps.LatLng(favorite.latitude, favorite.longitude);
         marker = new google.maps.Marker({
            position: fav_location,
            map: this.map,
            title: favorite.name
          });
          this.favoriteLocations.push(marker);
      }
    }
    )
  }

  //**Hides user's saved locations **/
  hideLocations(){
    this.showFavorites = !this.showFavorites;
    for(let favorite of this.favoriteLocations){
      favorite.setMap(null);
    }
    if(this.marker){
      this.marker.setMap(null);
    }
  }
/**TODO: Should refresh map once a location is either saved or deleted.**/
  refresh(){
    for(let favorite of this.favoriteLocations){
      favorite.setMap(null);
    }
    if(this.marker){
      this.marker.setMap(null);
    } 
    this.http.get<any>('http://ec2-35-174-153-234.compute-1.amazonaws.com:3333/favoritelocations/users/'+sessionStorage.getItem('id')).subscribe(favorites => {
      let marker:any;
      for(let favorite of favorites){
        let fav_location = new google.maps.LatLng(favorite.latitude, favorite.longitude);
         marker = new google.maps.Marker({
            position: fav_location,
            map: this.map,
            title: favorite.name
          });
          this.favoriteLocations.push(marker);
      }
    }
    )
  }

/**Delete a saved location by name */
  deleteLocation(){
    this.http.delete<any>('http://ec2-35-174-153-234.compute-1.amazonaws.com:3333/favoritelocations?name='
    +this.deleteFavorite + '&userId='
    +sessionStorage.getItem('id'),{}).subscribe(message =>
    console.log(message));
    console.log((document.getElementById("currentLocation") as HTMLInputElement).value);
    //this.refresh();
  }
}
