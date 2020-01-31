create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 100 );

create table categories (
    id      integer primary key,
    name    varchar(255) not null
);

insert into categories values (1, 'Book');
insert into categories values (2, 'Grocery');

create table products (
    id          integer primary key,
    name        varchar(255) not null,
    price       double precision not null,
    quantity    integer not null,
    category_id integer references categories(id)
);

insert into products values (1, 'A Game of Thrones', 6.99, 5, 1);
insert into products values (2, 'Milk', 3.99, 10, 2);
