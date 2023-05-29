import { Component } from '@angular/core';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-buscar-rango-precios',
  templateUrl: './buscar-rango-precios.component.html',
  styleUrls: ['./buscar-rango-precios.component.css']
})
export class BuscarRangoPreciosComponent {
  producto:ProductoPost;
  constructor(){
  this.producto = new ProductoPost();
 
 
  }
  public buscar():void{
    console.log(this.producto);
    }
}
