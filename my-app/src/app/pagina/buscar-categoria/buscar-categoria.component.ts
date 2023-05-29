import { Component } from '@angular/core';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-buscar-categoria',
  templateUrl: './buscar-categoria.component.html',
  styleUrls: ['./buscar-categoria.component.css']
})
export class BuscarCategoriaComponent {
  producto:ProductoPost;
  categoria:string[];
  constructor(){
  this.producto = new ProductoPost();
  this.categoria = [];
 
  }
  public buscar():void{
    console.log(this.producto);
    }

    ngOnInit(): void {
      this.categoria.push("TECNOLOGIA");
      this.categoria.push("VEHICULO");
      this.categoria.push("SUPERMERCADO");
      this.categoria.push("ELECTRODOMESTICOS");
      this.categoria.push("HOGAR_Y_MUEBLES");
      this.categoria.push("BELLEZA_Y_CUIDADO_PERSONAL");
      this.categoria.push("ACCESORIOS_PARA_VEHICULOS");
      this.categoria.push("HERRAMIENTAS");
      this.categoria.push("CONSTRUCCION");
      this.categoria.push("INMUEBLES");
      this.categoria.push("MODA");
      this.categoria.push("JUEGOS_Y_JUGUETES");
      this.categoria.push("BEBES");
      
     
      }

}
