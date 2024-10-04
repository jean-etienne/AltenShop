import { Component} from '@angular/core';
import { CartService } from './cart.service'; 
import { NgFor, NgIf } from '@angular/common';
import { ProductListComponent } from 'app/products/features/product-list/product-list.component';
import { ButtonModule } from "primeng/button";
import { DataViewModule } from 'primeng/dataview';
import { CardModule } from "primeng/card";
import { Product} from 'app/products/data-access/product.model';
import { CartItem } from "./cart-item.model";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [NgFor, ProductListComponent, NgIf, ButtonModule, DataViewModule, CardModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {

   cartItems: CartItem[] = [];
 

  constructor(private cartService: CartService) {}

  ngOnInit() {
    this.cartItems = this.cartService.getCartItems();
  }

  onDelete(product: Product) {
    const item = this.cartItems.find(item => item.product.id === product.id);
    if (item) {
      item.quantity--; 
      if (item.quantity <= 0) {
        this.cartItems = this.cartItems.filter(i => i.product.id !== product.id);
      }
    }
  }

  addItemOnProductInCart(product:Product)
  {
    this.cartService.addToCart(product);
    this.cartItems = this.cartService.getCartItems(); //  refresh du panier quand on augmente sa quantite
  }


  trackByFn(index: number, item: CartItem) {
    return item.product.id; 
  }

  
}

