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
 
  email1: String;      //email di login
  password1: String;   // password di login

   constructor(
     private http: HttpClient, private router:Router,
   ){}

persone: any[];

  ngOnInit(): void {
  }
  
  richestaHttp(form: boolean){
  console.log(this.email1, this.password1);
    this.http.get<Persona[]>('http://localhost:8080/login?email=' +
    this.email1 +'&password=' + this.password1).subscribe((persone) => {
      console.log(persone);

      if(persone)
      this.router.navigate(['paginaalert'])
      else
      this.router.navigate(['login'])

      console.log})
  }

  aggiungi(nome: string, cognome: string, email: string, username: string, password: string, telefono: string, citta: string){
    console.log(nome, cognome, email, username, password, telefono, citta); //aggiungi persona del database con registrati

    let postData = new FormData();
    postData.append('cognome' , cognome);
    postData.append('nome' , nome);
    postData.append('email' , email);
    postData.append('username' , username);
    postData.append('password' , password);
    postData.append('telefono' , telefono);
    postData.append('citta' , citta);
   
   

    this.http.post('http://localhost:8080/nuovaPersona', postData).subscribe(); 

  }
}
