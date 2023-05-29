import { Component } from '@angular/core';
import { UsuarioPost } from 'src/app/modelo/usuario-post';

@Component({
  selector: 'app-recuperar-cuenta',
  templateUrl: './recuperar-cuenta.component.html',
  styleUrls: ['./recuperar-cuenta.component.css']
})
export class RecuperarCuentaComponent {
  usuario:UsuarioPost;
  constructor(){
  this.usuario = new UsuarioPost();
  }
  public recuperar():void{
    console.log(this.usuario);
    }
}
