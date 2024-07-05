CREATE SCHEMA IF NOT EXISTS e_commerce;

CREATE TABLE e_commerce.customer (
                                     id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                     email varchar(255) NULL,
                                     "name" varchar(255) NULL,
                                     CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE TABLE e_commerce.item (
                                 price numeric(38, 2) NULL,
                                 id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                 "name" varchar(255) NULL,
                                 CONSTRAINT item_pkey PRIMARY KEY (id)
);

CREATE TABLE e_commerce.sale (
                                 amount numeric(38, 2) NULL,
                                 "date" date NULL,
                                 id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                 item_id int8 NULL,
                                 CONSTRAINT sale_pkey PRIMARY KEY (id)
);

CREATE TABLE e_commerce.wishlist (
                                     customer_id int8 NULL,
                                     id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
                                     CONSTRAINT wishlist_pkey PRIMARY KEY (id)
);

CREATE TABLE e_commerce.wishlist_items (
                                           items_id int8 NOT NULL,
                                           wishlist_id int8 NOT NULL
);

-- Insert Customers
INSERT INTO e_commerce.customer (id, name, email) VALUES (1, 'John Doe', 'john.doe@example.com');
INSERT INTO e_commerce.customer (id, name, email) VALUES (2, 'Jane Smith', 'jane.smith@example.com');

-- Insert Items
INSERT INTO e_commerce.item (id, name, price) VALUES (1, 'Laptop', 1000.00);
INSERT INTO e_commerce.item (id, name, price) VALUES (2, 'Smartphone', 500.00);
INSERT INTO e_commerce.item (id, name, price) VALUES (3, 'Headphones', 100.00);
INSERT INTO e_commerce.item (id, name, price) VALUES (4, 'Keyboard', 50.00);
INSERT INTO e_commerce.item (id, name, price) VALUES (5, 'Mouse', 25.00);

-- Insert Wishlists
INSERT INTO e_commerce.wishlist (id, customer_id) VALUES (1, 1);
INSERT INTO e_commerce.wishlist (id, customer_id) VALUES (2, 2);

-- Insert Wishlist Items
INSERT INTO e_commerce.wishlist_items (wishlist_id, items_id) VALUES (1, 1);
INSERT INTO e_commerce.wishlist_items (wishlist_id, items_id) VALUES (1, 3);
INSERT INTO e_commerce.wishlist_items (wishlist_id, items_id) VALUES (2, 2);
INSERT INTO e_commerce.wishlist_items (wishlist_id, items_id) VALUES (2, 4);

-- Insert Sales
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (1, '2024-07-01', 1000.00, 1);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (2, '2024-07-01', 500.00, 2);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (3, '2024-07-02', 100.00, 3);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (4, '2024-07-02', 50.00, 4);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (5, '2024-07-03', 25.00, 5);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (6, '2024-07-03', 1000.00, 1);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (7, '2024-07-03', 500.00, 2);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (8, '2024-07-05', 100.00, 3);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (9, '2024-07-05', 50.00, 4);
INSERT INTO e_commerce.sale (id, date, amount, item_id) VALUES (10, '2024-07-04', 25.00, 5);
