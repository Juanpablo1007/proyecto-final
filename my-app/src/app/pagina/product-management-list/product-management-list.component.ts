import { Component } from '@angular/core';
import { ProductoPost } from 'src/app/modelo/producto-post';

@Component({
  selector: 'app-product-management-list',
  templateUrl: './product-management-list.component.html',
  styleUrls: ['./product-management-list.component.css'],
})
export class ProductManagementListComponent {
  estado_producto: String[] = [];
  producto: ProductoPost;
  constructor() {
    this.producto = new ProductoPost();
    this.estado_producto = [];
  }
  public inhabilitar():void{
    console.log(this.producto);
    }
    public autorizar():void{
      console.log(this.producto);
      }

}
