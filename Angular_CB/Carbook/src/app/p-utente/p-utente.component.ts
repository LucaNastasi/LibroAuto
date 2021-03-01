import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Post } from '../model/post';
import { HttpClient, HttpClientModule } from '@angular/common/http'


@Component({
  selector: 'app-p-utente',
  templateUrl: './p-utente.component.html',
  styleUrls: ['./p-utente.component.css']
})
export class PUtenteComponent implements OnInit {

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

  constructor(private http: HttpClient,) { }

  ngOnInit(): void {
  }


  aggiungi(media: File, descrizione: string, dataPubblcazione: Date){
    console.log(media, descrizione, dataPubblcazione);

    let pubblicazione = new Post();
    pubblicazione.media = media;
    pubblicazione.descrizione = descrizione;
    pubblicazione.dataPubblicazione = dataPubblcazione;
    console.log(JSON.stringify(pubblicazione));

    this.http.post<Post>('http://localhost:8080/pubblicazioni', pubblicazione).subscribe(); 

  }

}
