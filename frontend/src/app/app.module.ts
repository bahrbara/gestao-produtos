import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';

import { UserComponent } from './user/user.component';
import { ProductsComponent } from './products/products.component';
import { OrdersComponent } from './orders/orders.component';
import { SidenavResponsive } from './navigation/sidenav-responsive.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ProductsComponent,
    OrdersComponent,
    SidenavResponsive
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    MatNativeDateModule,
    MatIconModule,
    MatSidenavModule,
    MatButtonModule,
    MatListModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
