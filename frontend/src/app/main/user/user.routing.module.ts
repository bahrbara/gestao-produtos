import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from './users/users.component';
import { UserFormComponent } from './user-form/user-form.component';


const usersRoutes: Routes = [
    {
        path: 'users',
        component: UsersComponent,
        children: [
            {
                path: ':id',
                component: UserFormComponent,
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(usersRoutes)],
    exports: [RouterModule]
})
export class UserRoutingModule { }
