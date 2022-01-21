import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListadosComponent } from './components/formulario/listados.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'formulario' },
  { path: 'formulario', component: FormularioComponent },
  { path: 'formulario/listado', component: ListadosComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
