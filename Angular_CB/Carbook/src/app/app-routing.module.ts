  
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { PaginaAlertComponent } from './pagina-alert/pagina-alert.component';
import { DirettiveComponent} from './direttive/direttive.component'
import { PAnnuncioComponent} from './p-annuncio/p-annuncio.component'
import { ModificadatiComponent} from './modificadati/modificadati.component'
//import { VisioneAnnuncioComponent } from './visione-annuncio/visione-annuncio.component';
import { ReimpostaPasswordComponent } from './reimposta-password/reimposta-password.component'



const routes: Routes = [
  {path: 'primapagina', component: PrimapaginaComponent},
  {path: 'login', component: LoginComponent},
  {path: 'paginaalert', component: PaginaAlertComponent},
  {path: 'direttive', component: DirettiveComponent},
  {path: 'pannuncio', component: PAnnuncioComponent},
  {path: 'modificadati', component: ModificadatiComponent},
  {path: 'reimpostapassword', component: ReimpostaPasswordComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }