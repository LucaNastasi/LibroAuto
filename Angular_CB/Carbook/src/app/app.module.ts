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
