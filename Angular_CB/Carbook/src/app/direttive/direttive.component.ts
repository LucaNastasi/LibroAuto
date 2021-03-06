import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Post } from '../model/post';
import { Automobile } from '../model/automobile'
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Byte } from '@angular/compiler/src/util';
import { Immagine } from '../model/immagine'


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



 /* public onSelectFile(event) {
    //Select File
    this.selectedFile = event.target.files[0];
  }*/
 

 /* onUpload() {
    console.log(this.selectedFile);
    
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile);
  
    //Make a call to the Spring Boot Application to save the image
    //this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
    this.http.post('http://localhost:8080/imgupload', uploadImageData)

  }*/
                      //httpClient
  constructor(private http: HttpClient,) 
   {}

 
   pubblicazioni:any[]
   annunci:any[]
   automobili:any[]

  /* selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
   immagini: any[]*/

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/pubblicazioni').subscribe((pubblicazioni) =>
    {
      this.pubblicazioni = pubblicazioni;
    })
  }

  aggiungi(/*picByte:Byte,*/ fotoAuto: File, alimentazione: string, cavalli: number,
    chilometri:number, modello:string, prezzo: number,  
    stato: string, cambio:string, marca:string, annoIMM:number, citta:string, descrizione: string, dataPubblicazione: Date){
    console.log(  alimentazione, alimentazione, citta, cavalli, chilometri, prezzo,
    modello, stato, cambio, descrizione, dataPubblicazione);

   // const uploadImageData = new FormData();
   // uploadImageData.append('imageFile', this.selectedFile);
    let annuncio = new Post();
    let automobile = new Automobile();
    annuncio.descrizione = descrizione;
    annuncio.dataPubblicazione = dataPubblicazione;
    //let immagine = new Immagine();

    /*automobile.fotoAuto = fotoAuto;
    automobile.alimentazione = alimentazione;
    automobile.cavalli = cavalli;
    automobile.chilometri = chilometri;
   
    automobile.modello = modello;
    automobile.prezzo = prezzo;
    automobile.stato = stato;
    automobile.cambio = cambio;
    automobile.marca = marca;
    automobile.AnnoIMM = AnnoIMM;*/
    
    //console.log(JSON.stringify(immagine));

    let DataAuto = new FormData();
    DataAuto.append('fotoAuto' , fotoAuto);
    DataAuto.append('alimentazione' , alimentazione);
    DataAuto.append('cavalli' , cavalli.toString());
    DataAuto.append('chilometri' , chilometri.toString());
    DataAuto.append('modello' , modello);
    DataAuto.append('prezzo' , prezzo.toString());
    DataAuto.append('stato' , stato);
    DataAuto.append('cambio' , cambio);
    DataAuto.append('marca' , marca);
    DataAuto.append('citta' , citta);
    DataAuto.append('annoIMM' , annoIMM.toString());
   
    console.log(JSON.stringify(annuncio));
    console.log(JSON.stringify(automobile));

    this.http.post('http://localhost:8080/automobili', DataAuto).subscribe(); 

  
    //Make a call to the Spring Boot Application to save the image
    //this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
    //this.http.post<Immagine>('http://localhost:8080/imgupload', uploadImageData).subscribe();

    this.http.post<Post>('http://localhost:8080/pubblicazioni', annuncio).subscribe(); 
   // this.http.post<Automobile>('http://localhost:8080/automobili', automobile).subscribe(); 
  }

}
