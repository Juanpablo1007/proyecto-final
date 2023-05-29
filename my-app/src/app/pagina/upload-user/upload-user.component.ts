import { Component } from '@angular/core';
import { UsuarioPost } from 'src/app/modelo/usuario-post';

@Component({
  selector: 'app-upload-user',
  templateUrl: './upload-user.component.html',
  styleUrls: ['./upload-user.component.css']
})
export class UploadUserComponent {
  usuario:UsuarioPost;
  constructor(){
  this.usuario = new UsuarioPost();
  }
  public actualizar():void{
    console.log(this.usuario);
    }
    onFileChange(event:any){
      if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log(file);
      }
      }
}
