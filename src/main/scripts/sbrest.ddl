
    create table categories (
       id integer not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table products (
       id integer not null,
        name varchar(255) not null,
        price double precision not null,
        quantity integer not null,
        category_id integer,
        primary key (id)
    ) engine=InnoDB;

    alter table products 
       add constraint FKog2rp4qthbtt2lfyhfo32lsw9 
       foreign key (category_id) 
       references categories (id);
