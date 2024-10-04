import { Product } from '../products/data-access/product.model'; // Assurez-vous que le chemin est correct

export interface CartItem {
  product: Product;
  quantity: number;
}