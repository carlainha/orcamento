create table municipio(
    id int not null primary key auto_increment,
    nome varchar(100),
    estado char(2)
);

create table cliente(
    id bigint not null primary key auto_increment,
    nome varchar(100),
    endereco varchar(120),
    numero varchar(50),
    bairro varchar(80),
    id_municipio int not null,
    telefone varchar(30),
    celular varchar(30)
);

create table lancamento(
    id bigint not null primary key auto_increment,
    datalancamento date,
    id_cliente bigint not null,
    tipolancamento varchar(10),
    valorlancamento decimal(12,2)
);

alter table cliente
add constraint FK_cliente_municipio
foreign key(id_municipio)
references municipio(id);

alter table lancamento
add constraint FK_lancamento_cliente
foreign key(id_cliente)
references cliente(id);