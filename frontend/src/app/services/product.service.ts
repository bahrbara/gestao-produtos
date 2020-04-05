import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Product } from '../models/product.model';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    constructor(private http: HttpClient) {}

    listProducts(): Observable<Product> {
        return this.http.get<Product>(`${environment.api.url}/product`);
    }

    getProduct(id: string): Observable<Product> {
        return this.http.get<Product>(`${environment.api.url}/product/${id}`);
    }

    createProduct(product: Product): Observable<any> {
        const href = `${environment.api.url}/product/`;
        return this.http.post<any>(`${href}`, {...product});
    }

    updateProduct(userId: string, product: Product): Observable<any> {

        const href = `${environment.api.url}/product/${userId}`;
        return this.http.put<any>(`${href}`, {...product});
    }

    deleteProduct(id: string): Observable<Product> {
        return this.http.delete<Product>(`${environment.api.url}/product/${id}`);
    }
}
