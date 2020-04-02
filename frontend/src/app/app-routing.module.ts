import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaNaoEncontradaComponent } from './pages/pagina-nao-encontrada/pagina-nao-encontrada.component';

const appRoutes: Routes = [
    { path: '**', component: PaginaNaoEncontradaComponent }
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
    exports: [RouterModule]
})
export class AppRoutingModule {}