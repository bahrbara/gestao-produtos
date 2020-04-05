import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { User } from '../models/user.model';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    constructor(private http: HttpClient) {}

    listUsers(): Observable<User> {
        return this.http.get<User>(`${environment.api.url}/user`);
    }

    getUser(id: string): Observable<User> {
        return this.http.get<User>(`${environment.api.url}/user/${id}`);
    }

    createUser(user: User): Observable<any> {
        const href = `${environment.api.url}/user/`;
        return this.http.post<any>(`${href}`, {...user});
    }

    updateUser(userId: string, user: User): Observable<any> {
        const href = `${environment.api.url}/user/${userId}`;
        return this.http.put<any>(`${href}`, {...user});
    }

    deleteUser(id: string): Observable<User> {
        return this.http.delete<User>(`${environment.api.url}/user/${id}`);
    }
}
