import {Component, Input} from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import {RestaurantDto} from "../../../models/dto/restaurant.dto";
import {RouterLink, RouterOutlet} from '@angular/router';


@Component({
  selector: 'app-restaurant-display',
  standalone: true,
    imports: [CommonModule, NgOptimizedImage, RouterLink, RouterOutlet],
  templateUrl: './restaurant-display.component.html',
  styleUrl: './restaurant-display.component.css'
})
export class RestaurantDisplayComponent {

  @Input() restaurant: RestaurantDto[] = [];

}
