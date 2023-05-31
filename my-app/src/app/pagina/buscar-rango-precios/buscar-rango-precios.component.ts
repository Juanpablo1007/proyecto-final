import { Component } from '@angular/core'; 
import { ProductoPost } from 'src/app/modelo/producto-post';
import { RangoDePreciosDTO } from 'src/app/modelo/rango-de-precios-dto';

@Component({
  selector: 'app-buscar-rango-precios',
  templateUrl: './buscar-rango-precios.component.html',
  styleUrls: ['./buscar-rango-precios.component.css']
})
export class BuscarRangoPreciosComponent {
  producto:ProductoPost;
  rango: RangoDePreciosDTO;
  constructor(){
  this.producto = new ProductoPost();
 this.rango = new RangoDePreciosDTO ();
 
  }
  public buscar():void{
    console.log(this.producto);
    }
}
