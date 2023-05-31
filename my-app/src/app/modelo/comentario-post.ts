import { ProductoPost } from './producto-post';
import { UsuarioPost } from './usuario-post.ts';

export class ComentarioPost {
  codigo: number = 0;
  usuario: UsuarioPost = new UsuarioPost();

  fecha: Date = new Date();
  texto: String = '';
  calificacion: number = 0;
  producto: ProductoPost = new ProductoPost;
}
