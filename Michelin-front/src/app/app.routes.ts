import {Routes} from '@angular/router';
import {RestaurantComponent} from "./components/Restaurant/restaurant.component";
import {EvalComponent} from "./components/Eval/eval.component";

export const routes: Routes = [
  {
    path: '', redirectTo: 'Restaurant', pathMatch: "full"
  },
  {
    path: 'Restaurant', component: RestaurantComponent
  },
  {
    path: 'Eval', component: EvalComponent
  }
];
