import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

import { PagesRoutingModule } from './pages-routing.module';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';

@NgModule({
    declarations: [
      PaginaNaoEncontradaComponent
    ],
  imports: [
    CommonModule,
    MatIconModule,
    PagesRoutingModule
  ]
})
export class PagesModule { }
