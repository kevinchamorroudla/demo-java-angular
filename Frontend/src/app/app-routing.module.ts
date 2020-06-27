import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionContratosComponent } from './componentes/gestion-contratos/gestion-contratos.component';


const routes: Routes = [
  { path: 'gestion-contratos', component: GestionContratosComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
