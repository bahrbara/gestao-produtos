import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { DashboardComponent } from './main/dashboard/dashboard.component';
import { UsersComponent } from './main/user/users/users.component';
import { UserFormComponent } from './main/user/user-form/user-form.component';
import { ProductsComponent } from './main/product/products/products.component';
import { ProductFormComponent } from './main/product/product-form/product-form.component';

const appRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    {
        path: 'users',
        children: [
            { path: '', component: UsersComponent},
            { path: ':id', component: UserFormComponent }
        ]
    },
    {
        path: 'products',
        children: [
            { path: '', component: ProductsComponent},
            { path: ':id', component: ProductFormComponent }
        ]
    },
    { path: '', component: DashboardComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [
        RouterModule.forRoot(
            appRoutes,
            {
                onSameUrlNavigation: 'reload',
                useHash: true
            }
        )],
    exports: [RouterModule],
    providers: [Location]
})
export class AppRoutingModule { }