import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Order } from '../models/order.model';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class OrderService {
    constructor(private http: HttpClient) {}

    listOrders(): Observable<Order> {
        return this.http.get<Order>(`${environment.api.url}/order`);
    }

    getOrder(id: string): Observable<Order> {
        return this.http.get<Order>(`${environment.api.url}/order/${id}`);
    }

    createOrder(order: Order): Observable<any> {
        const href = `${environment.api.url}/order/`;
        return this.http.post<any>(`${href}`, {...order});
    }

    updateOrder(userId: string, order: Order): Observable<any> {

        const href = `${environment.api.url}/order/${userId}`;
        return this.http.put<any>(`${href}`, {...order});
    }

    deleteOrder(id: string): Observable<Order> {
        return this.http.delete<Order>(`${environment.api.url}/order/${id}`);
    }
}
