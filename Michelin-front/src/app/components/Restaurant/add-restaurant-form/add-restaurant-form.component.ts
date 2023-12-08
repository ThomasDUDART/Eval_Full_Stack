import {Component, EventEmitter, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, NgForm} from "@angular/forms";
import {ErrorDirective} from "../../../directives/error.directive";

@Component({
  selector: 'app-add-restaurant-form',
  standalone: true,
  imports: [CommonModule, FormsModule, ErrorDirective],
  templateUrl: './add-restaurant-form.component.html',
  styleUrl: './add-restaurant-form.component.css'
})
export class AddRestaurantFormComponent {

  @Output("restauSubmitted") restauSubmittedEmiter = new EventEmitter<AddRestauFormData>();

  public formData: AddRestauFormData = {
    nom: ""
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restauSubmittedEmiter.emit(this.formData);
    }
  }

}

export interface AddRestauFormData {
  nom: string
}
