import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { DirettiveComponent } from './direttive/direttive.component';
import { PaginaAlertComponent } from './pagina-alert/pagina-alert.component';
import { ReimpostaPasswordComponent } from './reimposta-password/reimposta-password.component';
import { HttpClientModule } from '@angular/common/http';
import { PUtenteComponent}  from'./p-utente/p-utente.component'
import { FormsModule } from '@angular/forms';
import { ModificadatiComponent } from './modificadati/modificadati.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PrimapaginaComponent,
    DirettiveComponent,
    PaginaAlertComponent,
    ReimpostaPasswordComponent,
    PUtenteComponent,
    ModificadatiComponent
  ],
  imports: [
      BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }

/*
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PrimapaginaComponent } from './primapagina/primapagina.component';
import { DirettiveComponent } from './direttive/direttive.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PrimapaginaComponent,
    DirettiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
*/