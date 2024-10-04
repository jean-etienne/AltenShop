import {Component, inject} from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router, RouterModule } from "@angular/router";

import { SplitterModule } from 'primeng/splitter';
import { ToolbarModule } from 'primeng/toolbar';
import { PanelMenuComponent } from "./shared/ui/panel-menu/panel-menu.component";
import { ContactComponent } from "./contact/contact.component";
import { CartService } from "./cart/cart.service";
import { BadgeModule } from 'primeng/badge';
import {NgIf} from '@angular/common';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
  standalone: true,
  imports: [RouterModule, SplitterModule, ToolbarModule, PanelMenuComponent, ContactComponent, BadgeModule, NgIf ],
})
export class AppComponent {
  title = "ALTEN SHOP";
  cartCount: number = 0;
  cartService = inject(CartService);
    
  constructor(private router: Router) {}

  ngOnInit() {
    this.cartService.getCartItems();
   }

  goToCart(){
    this.router.navigate(['/cart']);
  }
}
