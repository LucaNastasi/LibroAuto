import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Url } from 'url';
import { Automobile } from './automobile';
import { Persona } from './persona';

export class Pubblicazione {

        idPubblicazione:number;
        descrizione: string;
        dataPubblicazione:Date;
        persona:Persona;
        automobile:Automobile;
        id_automobile:number;

}
