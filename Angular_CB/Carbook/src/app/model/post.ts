import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Url } from 'url';
import { Automobile } from './automobile';

export class Post {

        idPubblicazione:number;
        descrizione: string;
        media: File;
        dataPubblicazione:Date;
        automobile_idAutomobile:number;
        persona_id:number;
        automobile:Automobile;

   
    //public mipiaceCount: number;
}
