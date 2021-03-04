import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Post } from '../model/post';
import { Automobile } from '../model/automobile'
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
   annunci:any[]
   automobili:any[]

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/pubblicazioni').subscribe((pubblicazioni) =>
    {
      this.pubblicazioni = pubblicazioni;
    })
  }

  aggiungi(fotoAuto: File, alimentazione: string, cavalli: number, 
    chilometri:number, colore:string, modello:string, prezzo: number,  
    stato: string, descrizione: string, dataPubblicazione: Date){
    console.log(fotoAuto, alimentazione, cavalli, chilometri, colore,
    modello, prezzo, stato, descrizione, dataPubblicazione);

    let annuncio = new Post();
    let automobile = new Automobile();
    annuncio.descrizione = descrizione;
    annuncio.dataPubblicazione = dataPubblicazione;
    automobile.fotoAuto = fotoAuto;
    automobile.alimentazione = alimentazione;
    automobile.cavalli = cavalli;
    automobile.chilometri = chilometri;
    automobile.colore = colore;
    automobile.modello = modello;
    automobile.prezzo = prezzo;
    automobile.stato = stato;
    console.log(JSON.stringify(annuncio));
    console.log(JSON.stringify(automobile));

    this.http.post<Post>('http://localhost:8080/pubblicazioni', annuncio).subscribe(); 
    this.http.post<Post>('http://localhost:8080/automobili', automobile).subscribe(); 
  }

}
