import { Injectable, inject, signal } from "@angular/core";
import { Product } from "./product.model";
import { HttpClient } from "@angular/common/http";
import { catchError, Observable, of, tap } from "rxjs";
import { CartService } from "app/cart/cart.service";

@Injectable({
    providedIn: "root"
}) export class ProductsService {

    private readonly http = inject(HttpClient);
    private readonly path = "/api/products";
    
    private readonly _products = signal<Product[]>([]);

    public readonly products = this._products.asReadonly();


     public get():Observable<Product[]> {
        return this.http.get<Product[]>(`${this.path}/get`).pipe(
            tap((products) => this._products.set(products)));
    }

    public getById(id:number):Observable<Product[]> {
        console.log("getById productService");
        console.log(id);
        return this.http.get<Product[]>(`${this.path}/get/${id}`).pipe(
            tap((products) => this._products.set(products)));
    }

    public create(product: Product): Observable<boolean> {
        return this.http.post<boolean>(`${this.path}/create`, product).pipe(
            catchError(() => {
                return of(true);
            }),
            tap(() => this._products.update(products => [product, ...products])),
        );
    }

    public update(product: Product): Observable<boolean> {
        return this.http.patch<boolean>(`${this.path}/update/${product.id}`, product).pipe(
            catchError(() => {
                return of(true);
            }),
            tap(() => this._products.update(products => {
                return products.map(p => p.id === product.id ? product : p)
            })),
        );
    }

    public delete(productId: number): Observable<boolean> {
        return this.http.delete<boolean>(`${this.path}/${productId}`).pipe(
            catchError(() => {
                return of(true);
            }),
            tap(() => this._products.update(products => products.filter(product => product.id !== productId))),
        );
    }
}