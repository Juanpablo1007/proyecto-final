import { Component } from '@angular/core';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  categoria:string[];

  producto:ProductoPost;
  constructor(){
  this.producto = new ProductoPost();
  this.categoria = [];
 
  }
  public subir():void{
    console.log(this.producto);
    }
    onFileChange(event:any){
      if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log(file);
      }
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
