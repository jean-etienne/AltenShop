import { Routes } from "@angular/router";
import { HomeComponent } from "./shared/features/home/home.component";
import { ContactComponent } from "./contact/contact.component";
import { CartComponent } from "./cart/cart.component";

export const APP_ROUTES: Routes = [
  {
    path: "home",
    component: HomeComponent,
  },
  {
    path: "products",
    loadChildren: () =>
      import("./products/products.routes").then((m) => m.PRODUCTS_ROUTES)
  },
  { path: "", redirectTo: "home", pathMatch: "full" },

  {
    path: "contact",
    component: ContactComponent,
  },
  {
    path:"cart",
    component: CartComponent,
  },
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "**", redirectTo: "home" }
];
