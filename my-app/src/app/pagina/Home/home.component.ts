import { Component } from '@angular/core';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-inicio',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class InicioComponent {
  producto: ProductoPost;
  constructor() {
    this.producto = new ProductoPost();
   
  }
  public buscar():void{
    console.log(this.producto);
    }
}
