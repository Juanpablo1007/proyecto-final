import { Component } from '@angular/core';
import { UsuarioPost} from 'src/app/modelo/usuario-post';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario:UsuarioPost;
  constructor(){
  this.usuario = new UsuarioPost();
  }
  public ingresar():void{
    console.log(this.usuario);
    }
    onFileChange(event:any){
      if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log(file);
      }
      }
}
