create table accounts (
    id  bigserial not null,
    email varchar(255),
    password varchar(255),
    username varchar(255),
    primary key (id)
);

create table categories (
    id  bigserial not null,
    description varchar(255),
    path_to_image varchar(255),
    user_id int8,
    primary key (id)
);

create table order_order_item (
    order_id int8 not null,
    item_id int8 not null
);


create table orders (
    id  bigserial not null,
    date timestamp,
    order_number int8,
    order_price numeric(19, 2),
    user_id int8,
    primary key (id)
);

create table orders_item (
    id  bigserial not null,
    name varchar(255),
    item_price numeric(19, 2),
    quantity int8,
    primary key (id)
);

create table position_category (
    position_id int8 not null,
    category_id int8 not null
);

create table positions (
    id  bigserial not null,
    availability boolean,
    description varchar(255),
    position_name varchar(255),
    price numeric(19, 2),
    stock int4,
    user_id int8,
    primary key (id)
);

create table users (
    id  bigserial not null,
    age int4,
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(255),
    role varchar(255),
    user_status varchar(255),
    account_id int8,
    primary key (id)
);