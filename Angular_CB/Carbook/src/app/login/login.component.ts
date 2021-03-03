import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from '../model/persona';
import { HttpClient, HttpClientModule } from '@angular/common/http'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  email: String;      //email di login
  password: String;   // password di login

   constructor(
     private http: HttpClient, private router:Router,
   ){}

persone: any[];

  ngOnInit(): void {
  }
  
  richestaHttp(form: boolean){
  console.log(this.email, this.password);
    this.http.get<Persona[]>('http://localhost:8080/login?email=' +
    this.email +'&password=' + this.password).subscribe((persone) => {
      console.log(persone);

      if(persone)
      this.router.navigate(['paginaalert'])
      else
      this.router.navigate(['login'])

      console.log})
  }

  aggiungi(nome: string, cognome: string, email: string, username: string, password: string, telefono: string, citta: string){
    console.log(nome, cognome, email, username, password, telefono, citta); //aggiungi persona del databse con registrati

    let persona = new Persona();
    persona.nome = nome;
    persona.cognome = cognome;
    persona.email = email;
    persona.username = username;
    persona.password = password; 
    persona.telefono = telefono;
    persona.citta = citta;
    console.log(JSON.stringify(persona));

    this.http.post<Persona>('http://localhost:8080/persone', persona).subscribe(); 

  }
}
