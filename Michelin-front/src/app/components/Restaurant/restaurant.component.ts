import {Component, OnInit} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {RestaurantService} from "../../services/restaurant.service";
import {RestaurantDto} from "../../models/dto/restaurant.dto";
import {RestaurantDisplayComponent} from "./restaurant-display/restaurant-display.component";
import {AddRestaurantFormComponent, AddRestauFormData} from "./add-restaurant-form/add-restaurant-form.component";

@Component({
  selector: 'app-restaurant',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage, RestaurantDisplayComponent, AddRestaurantFormComponent],
  templateUrl: './restaurant.component.html',
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent implements OnInit {

  public restaurant: RestaurantDto[] = [];

  constructor(private readonly restaurantService: RestaurantService) {
  }

  ngOnInit(): void {
    this.refreshRestaurant();
  }

  public refreshRestaurant() {
    this.restaurantService.loadRestau().subscribe(value => {
      this.restaurant = value;
      this.restaurant.forEach(livre => this.getCover(livre));
    })
  }

  public getCover(livre: RestaurantDto): void {
    this.restaurantService.getRestauCover(livre.id).subscribe(urlDto => {
      livre.coverUrl = urlDto.url;
    });
  }

  public onRestauSubmitted(newLivreData: AddRestauFormData): void {
    this.restaurantService.addRestau(newLivreData).subscribe(value => {
      this.restaurant.push(value);
      this.getCover(value);
    })
  }

}
