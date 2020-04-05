import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { OrdersComponent } from './orders/orders.component';
import { OrderFormComponent } from './order-form/order-form.component';




const ordersRoutes: Routes = [
    {
        path: 'orders',
        component: OrdersComponent,
        children: [
            {
                path: ':id',
                component: OrderFormComponent,
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(ordersRoutes)],
    exports: [RouterModule]
})
export class OrderRoutingModule { }
