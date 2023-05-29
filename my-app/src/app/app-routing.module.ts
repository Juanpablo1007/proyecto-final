import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './pagina/Home/home.component';
import { LoginComponent } from './pagina/login/login.component';
import { RegistroComponent } from './pagina/record/record.component';
import { ListProductsComponent } from './pagina/list-products/list-products.component';
import { ProductManagementListComponent } from './pagina/product-management-list/product-management-list.component';
import { ProductsComponent } from './pagina/products/products.component';
import { TrolleyComponent } from './pagina/trolley/trolley.component';
import { UploadProductComponent } from './pagina/upload-product/upload-product.component';
import { UploadUserComponent } from './pagina/upload-user/upload-user.component';
import { UserProductsComponent } from './pagina/user-products/user-products.component';

const routes: Routes = [
  { path: "", component: InicioComponent },
  { path: "login", component: LoginComponent },
  { path: "record", component: RegistroComponent },
  { path: "ListProduct", component: ListProductsComponent },
  { path: "product-management-list", component: ProductManagementListComponent },
  { path: "products", component: ProductsComponent },
  { path: "trolley", component: TrolleyComponent },
  { path: "upload-product", component: UploadProductComponent },
  { path: "upload-user", component: UploadUserComponent },
  { path: "user-products", component: UserProductsComponent },
  { path: "**", pathMatch: "full", redirectTo: "" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
