import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Persona } from '../model/persona';
import { HttpClient, HttpClientModule } from '@angular/common/http'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 

   constructor(
     private http: HttpClient,
   ){}

persone: Persona[];

  ngOnInit(): void {
  }
  
  richestaHttp(){
    this.http.get<Persona[]>('http://localhost:8080/persone').subscribe((persone) => {
    this.persone = persone;})
  }

  aggiungi(nome: string, cognome: string, email: string, username: string, password: string, dataNascita: Date, citta: string){
    console.log(nome, cognome, email, username, password, dataNascita, citta);

    let persona = new Persona();
    persona.nome = nome;
    persona.cognome = cognome;
    persona.email = email;
    persona.username = username;
    persona.password = password; 
    persona.dataNascita = dataNascita;
    persona.citta = citta;
    console.log(JSON.stringify(persona));

    this.http.post<Persona>('http://localhost:8080/persone', persona).subscribe(); 

  }

  


}
