import { Component } from '@angular/core';
import { ComentarioPost } from 'src/app/modelo/comentario-post';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-producto-visualizacion',
  templateUrl: './producto-visualizacion.component.html',
  styleUrls: ['./producto-visualizacion.component.css']
})
export class ProductoVisualizacionComponent {
  
  producto: ProductoPost;
  comentario: ComentarioPost;
  constructor() {
    this.producto = new ProductoPost();
   this.comentario = new ComentarioPost();
  }
  public comentar():void{
    console.log(this.producto);
    }
    public agregarCarrito():void{
      console.log(this.producto);
      }
      public agregarFavorito():void{
        console.log(this.producto);
        }
}
