create table if not exists users (
    id int not null AUTO_INCREMENT,
    email varchar(100) not null,
    username varchar(100) not null,
    password varchar(100) not null,
    airport varchar(100) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY ( ID )
);