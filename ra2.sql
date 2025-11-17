create database ra2;
use ra2;

create table libro(
id int auto_increment primary key,
nombre varchar(100) not null
);

create table genero(
nombre_genero varchar(100) primary key
);

create table cliente(
id int auto_increment primary key,
nombre varchar(100) not null
);

create table pedido(
id int auto_increment primary key,
id_libro int not null,
id_cliente int not null,
genero_libro varchar(100) not null,
fecha date not null,
FOREIGN KEY (id_libro) REFERENCES libro(id) ON DELETE CASCADE,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id) ON DELETE CASCADE,
FOREIGN KEY (genero_libro) REFERENCES genero(nombre_genero) ON DELETE CASCADE
);

insert into libro(nombre) values
('Juanito caminante'),
('La torre'),
('La mudanza');

insert into genero(nombre_genero) values 
('terror'),
('suspense'),
('comedia');

insert into Cliente(nombre) values
('Pedro'),
('Adri'),
('Jesus');

insert into pedido(id_libro, id_cliente, genero_libro, fecha) values
('1', '1', 'terror', '2023-01-01'),
('2', '2', 'suspense', '2023-02-02'),
('3', '3', 'comedia', '2023-03-03');

select * from pedido;