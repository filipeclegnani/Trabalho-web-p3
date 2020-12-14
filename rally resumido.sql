create database resumidaRally;
use resumidaRally;

create table campeonato(
	id int not null auto_increment,
    nome varchar(100),
    datainicio datetime,
    datafim datetime,
    rgulamento BLOB,
    primary key(id)
);

create table categoria(
	id int not null auto_increment,
    descricao varchar(100),
    primary key(id)
);

create table piloto(
	id int not null auto_increment,
    nome varchar(250),
    email varchar(100),
    cpf varchar(15),
    dataNascimento date,
    cidade varchar(300),
    uf varchar(2),
    modelo_moto varchar(45),
	cilindrada varchar(45),
    marca varchar (150),
    primary key(id)
);

create table etapa(
	id int not null auto_increment,
    localizacao	varchar(200),
    cidade varchar(300),
    uf varchar(2),
    distancia decimal(10,3),
    idCampeonato int not null,
    primary key(id),
    FOREIGN KEY (idCampeonato) REFERENCES campeonato(id)
);

create table participante(
	id int not null auto_increment,
    idPiloto int not null,
    idCampeonato int not null,
    idCategoria int not null,
    primary key(id),
    FOREIGN KEY (idPiloto) REFERENCES piloto(id),
    FOREIGN KEY (idCampeonato) REFERENCES campeonato(id),
    FOREIGN KEY (idCategoria) REFERENCES categoria(id)
);

create table volta(
	id int not null auto_increment,
    tipo varchar(45),
    tempo decimal(10,4),
    horaChegada varchar(10),
    horaSaida varchar(10),
    idParticipante int not null,
    idEtapa int not null,
    primary key(id),
    FOREIGN KEY (idParticipante) REFERENCES participante(id),
    FOREIGN KEY (idEtapa) REFERENCES etapa(id)
);

