import { compileNgModuleFromRender2 } from '@angular/compiler/src/render3/r3_module_compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Pubblicazione } from '../model/pubblicazione';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Automobile } from '../model/automobile'

@Component({
  selector: 'app-primapagina',
  templateUrl: './primapagina.component.html',
  styleUrls: ['./primapagina.component.css']
})
export class PrimapaginaComponent implements OnInit {
  DataOra = new Date();
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
  idAuto:number;
  pubblicazioni:any[]
  automobili:any[]
  ngOnInit(): void {
  
    this.http.get<any[]>('http://localhost:8080/pubblicazioni').subscribe((pubblicazioni) =>
    {
      this.pubblicazioni = pubblicazioni;
    })

    this.http.get<any[]>('http://localhost:8080/automobili').subscribe((automobili) =>
    {
      this.automobili = automobili;
    })
  }

  /*getAllTableDataById(tableName:string, idColumn:string, idValue:string): Promise<Object[]> {
    return this.http.get(`${'http://localhost:8080/automobili'}/${tableName}(${idColumn}='${idValue}')`)
    .toPromise()
    .then(response => response = JSON.parse('[' + response['_body'] + ']'));
    }*/

  aggiungi(fotoAuto: File, alimentazione: string, potenza: number,
    chilometraggio:number, modello:string, costo: number,  
    stato: string, cambio:string, marca:string, annoImmatricolazione:number, citta:string, descrizione: string, dataPubblicazione: Date){
    //console.log(  alimentazione, alimentazione, citta, potenza, chilometraggio, costo,
   // modello, stato, cambio, descrizione, dataPubblicazione);

 
    let pubblicazione = new Pubblicazione();
    let automobile = new Automobile();
    pubblicazione.descrizione = descrizione;
    pubblicazione.dataPubblicazione = dataPubblicazione;

  //  pubblicazione.id_automobile = id_automobile;

    automobile.fotoAuto = fotoAuto;
    automobile.alimentazione = alimentazione;
    automobile.potenza = potenza;
    automobile.chilometraggio = chilometraggio;
    automobile.marca = marca;
    automobile.modello = modello;
    automobile.costo = costo;
    automobile.citta = citta;
    automobile.stato = stato;
    automobile.cambio = cambio;
    automobile.marca = marca;
    automobile.annoImmatricolazione = annoImmatricolazione;


/*
    let DataAuto = new FormData();
    DataAuto.append('fotoAuto' , fotoAuto);
    DataAuto.append('alimentazione' , alimentazione);
    DataAuto.append('potenza' , potenza.toString());
    DataAuto.append('chilometraggio' , chilometraggio.toString());
    DataAuto.append('modello' , modello);
    DataAuto.append('costo' , costo.toString());
    DataAuto.append('stato' , stato);
    DataAuto.append('cambio' , cambio);
    DataAuto.append('marca' , marca);
    DataAuto.append('citta' , citta);
    DataAuto.append('annoImmatricolazione' , annoImmatricolazione.toString());
    */


   console.log(JSON.stringify(pubblicazione));
   console.log(JSON.stringify(automobile));


    this.http.post<Automobile>('http://localhost:8080/automobili', automobile).subscribe((dati) => {
 
      console.log(dati.idAutomobile)
    });
  

/*
    
*/
    
    this.http.post<Pubblicazione>('http://localhost:8080/pubblicazioni', pubblicazione).subscribe();

}
}


