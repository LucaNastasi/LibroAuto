import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reimposta-password',
  templateUrl: './reimposta-password.component.html',
  styleUrls: ['./reimposta-password.component.css']
})

export class ReimpostaPasswordComponent implements OnInit {
  
  password: string;
  n_password: string;
  

  constructor() { }

  ngOnInit(): void {
  }

}
