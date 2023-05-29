import { CarritoPost } from "./carrito-post";
import { ComentarioPost } from "./comentario-post";
import { TransaccionPost } from "./transaccion-post";
import { UsuarioPost } from "./usuario-post";

export class ProductoPost {
codigo:number = 0;

usuario:UsuarioPost = new UsuarioPost;
usuariosFavoritos: UsuarioPost[] = [];

isActivo:boolean = true;

UrlImagen: String = "";

nombre: String = "";

descripcion: String="";

precio: number=0;
precioMenor: number=0;
precioMayor: number=0;

unidades: number=0;

estado_producto:string ="SIN_REVISAR";

fechaLimite:Date = new Date;

categoria:string="";

comentarios:ComentarioPost[] =[];
compras:TransaccionPost[]=[];
ventas:TransaccionPost[]=[];
carritos:CarritoPost[]=[];





}
