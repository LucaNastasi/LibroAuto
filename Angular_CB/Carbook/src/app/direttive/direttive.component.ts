import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Post } from '../model/post';
import { HttpClient, HttpClientModule } from '@angular/common/http'


@Component({
  selector: 'app-direttive',
  templateUrl: './direttive.component.html',
  styleUrls: ['./direttive.component.css']
})
export class DirettiveComponent implements OnInit {

 
  url = '';
  onSelectFile(event) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); 

      reader.onload = (event) => { 
        this.url = event.target.result as string;
      }
    }
  }
  constructor(private http: HttpClient,) 
   {}

   pubblicazioni:any[]

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/pubblicazioni').subscribe((pubblicazioni) =>
    {
      this.pubblicazioni = pubblicazioni;
    })
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
