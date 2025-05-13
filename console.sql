CREATE DATABASE ss06;

USE ss06;

# DROP DATABASE ss06;

CREATE TABLE Books
(
    id  INT AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(255) NOT NULL,
    author   VARCHAR(255) NOT NULL,
    genre    VARCHAR(100),
    quantity INT DEFAULT 0
);

INSERT INTO Books (title, author, genre, quantity)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 10),
       ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 8),
       ('1984', 'George Orwell', 'Dystopian', 15),
       ('Pride and Prejudice', 'Jane Austen', 'Romance', 12),
       ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 20);

CREATE TABLE Users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    phone    VARCHAR(20)
);

INSERT INTO Users (username, password, email, phone)
VALUES ('hieu123', 'pass123', 'hieu123@example.com', '0123456789'),
       ('linhtran', 'linhpass', 'linhtran@example.com', '0987654321'),
       ('hoangnguyen', 'hoang2025', 'hoangnguyen@example.com', '0933221144'),
       ('anhkhoa', 'khoapass', 'anhkhoa@example.com', '0911223344'),
       ('minhthu', 'thu12345', 'minhthu@example.com', '0909090909');

CREATE TABLE Product
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    price    DECIMAL(10, 2) NOT NULL,
    imageUrl VARCHAR(500)
);

INSERT INTO Product (name, price, imageUrl)
VALUES ('Laptop Dell XPS 13', 25999.99, 'https://example.com/images/dellxps13.jpg'),
       ('iPhone 14 Pro', 29999.99, 'https://example.com/images/iphone14pro.jpg'),
       ('Sony WH-1000XM5', 7999.99, 'https://example.com/images/sonyheadphones.jpg'),
       ('Mechanical Keyboard', 1499.50, 'https://example.com/images/keyboard.jpg'),
       ('Gaming Mouse', 999.99, 'https://example.com/images/mouse.jpg');

CREATE TABLE Cart
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    userId    INT NOT NULL,
    productId INT NOT NULL,
    quantity  INT NOT NULL DEFAULT 1,
    FOREIGN KEY (userId) REFERENCES Users (id),
    FOREIGN KEY (productId) REFERENCES Product (id)
);

INSERT INTO Cart (userId, productId, quantity)
VALUES (1, 2, 1),
       (2, 1, 2),
       (3, 4, 1),
       (4, 5, 3),
       (5, 3, 2);

CREATE TABLE Employee
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    birthday DATE           NOT NULL,
    phone    VARCHAR(20),
    email    VARCHAR(255) UNIQUE,
    salary   DECIMAL(15, 2) NOT NULL,
    position VARCHAR(100)
);

INSERT INTO Employee (name, birthday, phone, email, salary, position)
VALUES ('Nguyen Van A', '1990-01-01', '0901234567', 'vana@example.com', 15000000, 'Manager'),
       ('Tran Thi B', '1992-02-15', '0912345678', 'thib@example.com', 12000000, 'Accountant'),
       ('Le Van C', '1988-06-20', '0923456789', 'vanc@example.com', 13000000, 'Developer'),
       ('Pham Thi D', '1995-09-10', '0934567890', 'thid@example.com', 11000000, 'Designer'),
       ('Do Van E', '1993-11-30', '0945678901', 'vane@example.com', 12500000, 'HR');

DELIMITER //
create procedure find_all_book()
begin
select * from Books;
end;

create procedure find_book_by_id(
    id_in int
)
begin
select * from Books where id = id_in;
end;

create procedure create_book(
    title_in varchar(255),
    author_in varchar(255),
    genre_in varchar(100),
    quantity_in int
)
begin
insert into Books (title, author, genre, quantity)
values (title_in, author_in, genre_in, quantity_in);
end;

create procedure update_book(
    id_in int,
    title_in varchar(255),
    author_in varchar(255),
    genre_in varchar(100),
    quantity_in int
)
begin
update Books
set title    = title_in,
    author   = author_in,
    genre    = genre_in,
    quantity = quantity_in
where id = id_in;
end;

create procedure delete_book(
    id_in int
)
begin
delete from Books where id = id_in;
end;

create procedure register_user(
    username_in varchar(100),
    password_in varchar(255),
    email_in varchar(255),
    phone_in varchar(20)
)
begin
insert into Users (username, password, email, phone)
values (username_in, password_in, email_in, phone_in);
end;

create procedure login_user(
    username_in varchar(100),
    password_in varchar(255)
)
begin
select * from Users
where username = username_in and password = password_in;
end;

create procedure find_all_products()
begin
select * from Product;
end;

create procedure add_product_to_cart(
    userId_in int,
    productId_in int,
    quantity_in int
)
begin
    if exists(select 1 from cart where userId = userId_in and productId = productId_in) then
update cart
set quantity = quantity + quantity_in
where userId = userId_in and productId = productId_in;
else
        insert into Cart(userId, productId, quantity)
            values (userId_in, productId_in, quantity_in);
end if;
end;

create procedure find_cart_by_userId(
    userId_in int
)
begin
select p.id as product_id,
       p.name as product_name,
       p.price as product_price,
       c.id as cart_id,
       c.userId as cart_userId,
       c.quantity as cart_quantity
from Cart c
         join Product p on c.productId = p.id
where c.userId = userId_in;
end;

create procedure remove_product_from_cart(
    userId_in int,
    productId_in int
)
begin
delete from Cart
where userId = userId_in and productId = productId_in;
end;

create procedure find_all_employee()
begin
select * from Employee;
end;

create procedure find_employee_by_id(
    id_in int
)
begin
select * from Employee where id = id_in;
end;

create procedure create_employee(
    name_in varchar(255),
    birthday_in date,
    phone_in varchar(20),
    email_in varchar(255),
    salary_in decimal(15, 2),
    position_in varchar(100)
)
begin
insert into Employee (name, birthday, phone, email, salary, position)
values (name_in, birthday_in, phone_in, email_in, salary_in, position_in);
end;

create procedure update_employee(
    id_in int,
    name_in varchar(255),
    birthday_in date,
    phone_in varchar(20),
    email_in varchar(255),
    salary_in decimal(15, 2),
    position_in varchar(100)
)
begin
update Employee
set name    = name_in,
    birthday   = birthday_in,
    phone    = phone_in,
    email = email_in,
    salary = salary_in,
    position = position_in
where id = id_in;
end;

create procedure delete_employee(
    id_in int
)
begin
delete from Employee where id = id_in;
end;
DELIMITER //