import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primapagina',
  templateUrl: './primapagina.component.html',
  styleUrls: ['./primapagina.component.css']
})
export class PrimapaginaComponent implements OnInit {

  url = '';
  onSelectFile(event) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.url = event.target.result as string;
      }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}