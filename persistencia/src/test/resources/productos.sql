
insert into usuario values ("123","contraseña","calle 6","juano@gmail.com",1,"juan","3136142910");
insert into usuario values ("321","contraseña","calle 6","juanp@gmail.com",1,"juanpa","3136142910");

insert into producto values (123,"es un martillo","AUTORIZADO","2023-05-23","imagen",1,1,"martillo",10500,"123");
insert into producto values (124,"es un destornillador","DENEGADO","2023-05-23","imagen",1,1,"destornillador",10500,"123");
insert into usuario_productos_favoritos values ("123",124);
insert into usuario_productos_favoritos values ("123",123);
insert into comentario values (1,"2023-04-22","buen producto", 124,"123");
