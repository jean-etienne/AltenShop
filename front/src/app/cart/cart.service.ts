import { Injectable } from "@angular/core";
import { Product } from "app/products/data-access/product.model";
import { CartItem } from "./cart-item.model";

  @Injectable({
    providedIn: 'root'
  })

  export class CartService {
    private cartItems: CartItem[] = [];

    constructor(){
      this.loadCart();
    }
    
    addToCart(product: Product) {
      const existingItem = this.cartItems.find(item => item.product.id === product.id);
      if (existingItem) {
        existingItem.quantity++;
      } else {
        this.cartItems.push({ product, quantity: 1 });
      }
      this.saveCart();
    }
  
    getCartItems(): CartItem[] {
      return this.cartItems;
    }

    getTotalItems(): number {
      return this.cartItems.reduce((total, item) => total + item.quantity, 0);

    }
  
    clearCart() {
      this.cartItems = [];

    }    

    saveCart(){
      localStorage.setItem('cart', JSON.stringify(this.cartItems));
    }
    loadCart(){
      const cartData = localStorage.getItem('cart');
      if (cartData)
      {
        this.cartItems = JSON.parse(cartData);
      }
    }
  }