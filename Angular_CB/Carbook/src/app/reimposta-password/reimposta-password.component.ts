import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimposta-password',
  templateUrl: './reimposta-password.component.html',
  styleUrls: ['./reimposta-password.component.css']
})

export class ReimpostaPasswordComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
  
  controllaPassword(password: string , con_password: string){
    if( password != con_password ){
      console.log("Le password non coincidono, riprova")
    } else {
      console.log("Password aggiornata")
    }
  }
}
