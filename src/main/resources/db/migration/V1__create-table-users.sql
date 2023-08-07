create table users(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    cep varchar(8) not null,
    place varchar(100) not null,
    complement varchar(100) not null,
    neighborhood varchar(100) not null,
    locality varchar(100) not null,
    uf char(2) not null,

    primary key(id)
);