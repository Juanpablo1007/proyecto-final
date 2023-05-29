import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './pagina/Home/home.component';
import { LoginComponent } from './pagina/login/login.component';
import { RegistroComponent } from './pagina/record/record.component';
import { UploadProductComponent } from './pagina/upload-product/upload-product.component';
import { ProductManagementListComponent } from './pagina/product-management-list/product-management-list.component';
import { UserProductsComponent } from './pagina/user-products/user-products.component';
import { ProductsComponent } from './pagina/products/products.component';
import { TrolleyComponent } from './pagina/trolley/trolley.component';
import { UploadUserComponent } from './pagina/upload-user/upload-user.component';
import { ListProductsComponent } from './pagina/list-products/list-products.component';

@NgModule({
  declarations: [
   AppComponent,InicioComponent,LoginComponent,RegistroComponent, UploadProductComponent, ProductManagementListComponent, UserProductsComponent, ProductsComponent, TrolleyComponent, UploadUserComponent, ListProductsComponent,

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    ,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
