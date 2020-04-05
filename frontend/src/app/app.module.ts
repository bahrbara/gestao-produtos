import { NgModule, LOCALE_ID } from '@angular/core';
import {registerLocaleData} from '@angular/common';
import pt from '@angular/common/locales/pt-PT';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexModule } from '@angular/flex-layout';

import { MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatBadgeModule } from '@angular/material/badge';
import { MatCardModule } from '@angular/material/card';

import { OrdersComponent } from './main/orders/orders.component';
import { DashboardModule } from './main/dashboard/dashboard.module';
import { PagesModule } from './pages/pages.module';
import { UserModule } from './main/user/user.module';
import { ProductModule } from './main/product/products.module';

registerLocaleData(pt, 'pt-PT');

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    CommonModule,
    RouterModule,
    MatNativeDateModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatBadgeModule,
    MatCardModule,
    DashboardModule,
    PagesModule,
    UserModule,
    ProductModule,
    FlexModule
  ],
  bootstrap: [AppComponent],
  providers: [ { provide: LOCALE_ID, useValue: 'pt-PT' }  ]
})
export class AppModule { }
