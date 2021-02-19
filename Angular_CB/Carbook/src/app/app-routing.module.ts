  
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { PaginaAlertComponent } from './pagina-alert/pagina-alert.component'

const routes: Routes = [
  {path: 'primapagina', component: PrimapaginaComponent},
  {path: 'login', component: LoginComponent},
  {path: 'paginaalert', component: PaginaAlertComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }