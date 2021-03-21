  
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { PaginaAlertComponent } from './pagina-alert/pagina-alert.component';
import { DirettiveComponent} from './direttive/direttive.component'
import { PAnnuncioComponent} from './p-annuncio/p-annuncio.component'
import { ModificadatiComponent} from './modificadati/modificadati.component'
<<<<<<< HEAD
import { VisioneAnnuncioComponent } from './visione-annuncio/visione-annuncio.component';
=======
import { ReimpostaPasswordComponent } from './reimposta-password/reimposta-password.component'
>>>>>>> 295626d8453b1f070aaf95412f4bc896dacea42f



const routes: Routes = [
  {path: 'primapagina', component: PrimapaginaComponent},
  {path: 'login', component: LoginComponent},
  {path: 'paginaalert', component: PaginaAlertComponent},
  {path: 'direttive', component: DirettiveComponent},
  {path: 'pannuncio', component: PAnnuncioComponent},
  {path: 'modificadati', component: ModificadatiComponent},
<<<<<<< HEAD
  {path: 'visioneannuncio', component: VisioneAnnuncioComponent}
=======
  {path: 'reimpostapassword', component: ReimpostaPasswordComponent}
>>>>>>> 295626d8453b1f070aaf95412f4bc896dacea42f
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }