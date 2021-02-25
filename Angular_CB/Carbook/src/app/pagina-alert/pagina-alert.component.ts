import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-alert',
  templateUrl: './pagina-alert.component.html',
  styleUrls: ['./pagina-alert.component.css']
})
export class PaginaAlertComponent implements OnInit {

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


  constructor() {
   
   }

  ngOnInit(): void {
  }

  
}
