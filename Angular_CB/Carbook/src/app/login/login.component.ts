import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../model/persona';
import { HttpClient, HttpClientModule, HttpResponse } from '@angular/common/http'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  email1: string;      //email di login
  password1: String;   // password di login
  

   constructor(
     private http: HttpClient, private router:Router
   ){}



  ngOnInit(): void {
  }

       
/*  richestaHttp(form: boolean){
  console.log(this.email1, this.password1);
          //post
    this.http.get<Persona[]>('http://localhost:8080/login?email=' +
    this.email1 +'&password=' + this.password1).subscribe((persone) => {
      console.log(persone);

      if(persone)
      this.router.navigate(['primapagina'])
      else
      this.router.navigate(['login'])

      console.log})
  } */



  aggiungi(nome: string, cognome: string, email: string, username: string, password: string, telefono: string, citta: string){
    console.log(nome, cognome, email, username, password, telefono, citta); 

    let persona = new Persona();
    persona.username = username;
    persona.citta = citta;
    persona.cognome = cognome;
    persona.email = email;
    persona.password = password;
    persona.telefono = telefono;
    persona.nome = nome;
   
    this.http.post<Persona>('http://localhost:8080/nuovaPersona', persona).subscribe(); 

  }

  loginUser(email1: string, password1: string){
    //post
    let personaLogin = new Persona();
    personaLogin.email= email1;
    personaLogin.password = password1;
    this.http.post<Persona>('http://localhost:8080/accesso', personaLogin, {observe: 'response'} ).subscribe(response => {
      if(response.status == 200){
        this.router.navigate(['primapagina'])
      }
    }) 

  }


}
