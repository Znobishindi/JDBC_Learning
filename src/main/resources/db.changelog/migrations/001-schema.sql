create table CUSTOMERS
(
    id           int auto_increment primary key,
    name         char(20),
    surname      char(50),
    age          int,
    phone_number char(12)
);
create table ORDERS
(
    id           int auto_increment primary key,
    date         date,
    customer_id  int,
    product_name char(150),
    amount       double,
    foreign key c_id(customer_id) references customers(id)
);