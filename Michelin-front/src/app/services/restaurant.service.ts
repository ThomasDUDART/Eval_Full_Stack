import {Injectable} from '@angular/core';
import {RestaurantDto} from "../models/dto/restaurant.dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlDto} from "../models/dto/url.dto";
import {AddRestauFormData} from "../components/Restaurant/add-restaurant-form/add-restaurant-form.component";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) {
    this.loadRestau();
  }

  public loadRestau(): Observable<RestaurantDto[]> {
    return this.httpClient.get<RestaurantDto[]>(`http://localhost:8080/restau`)
  }

  public getRestauCover(id: number): Observable<UrlDto> {
    return this.httpClient.get<UrlDto>(`http://localhost:8080/livres/${id}/cover`);
  }

  public addRestau(newRestauData: AddRestauFormData): Observable<RestaurantDto> {
    return this.httpClient.post<RestaurantDto>(`http://localhost:8080/restau`, newRestauData);
  }
}
