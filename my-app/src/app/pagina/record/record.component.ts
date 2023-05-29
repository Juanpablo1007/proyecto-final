import { Component } from '@angular/core';
import { UsuarioPost } from 'src/app/modelo/usuario-post';


@Component({
  selector: 'app-registro',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.css']
})

export class RegistroComponent {
  
usuario:UsuarioPost;
constructor(){
this.usuario = new UsuarioPost();
}
public registrar():void{
  console.log(this.usuario);
  }
  onFileChange(event:any){
    if (event.target.files.length > 0) {
    const file = event.target.files[0];
    console.log(file);
    }
    }
}
