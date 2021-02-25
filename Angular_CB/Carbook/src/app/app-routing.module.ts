  
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { PaginaAlertComponent } from './pagina-alert/pagina-alert.component';
import { PUtenteComponent } from './p-utente/p-utente.component';
import { DirettiveComponent} from './direttive/direttive.component'
  

const routes: Routes = [
  {path: 'primapagina', component: PrimapaginaComponent},
  {path: 'login', component: LoginComponent},
  {path: 'paginaalert', component: PaginaAlertComponent},
  {path: 'putente', component: PUtenteComponent},
  {path: 'direttive', component: DirettiveComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }