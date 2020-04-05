import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './products/products.component';
import { ProductFormComponent } from './product-form/product-form.component';




const productsRoutes: Routes = [
    {
        path: 'products',
        component: ProductsComponent,
        children: [
            {
                path: ':id',
                component: ProductFormComponent,
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(productsRoutes)],
    exports: [RouterModule]
})
export class ProductRoutingModule { }
