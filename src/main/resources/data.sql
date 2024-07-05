
-- Create Database and Schema --
CREATE DATABASE wall_street;
CREATE SCHEMA e_commerce;

-- Insert Customers
INSERT INTO customer (id, name, email) VALUES (1, 'John Doe', 'john.doe@example.com');
INSERT INTO customer (id, name, email) VALUES (2, 'Jane Smith', 'jane.smith@example.com');

-- Insert Items
INSERT INTO item (id, name, price) VALUES (1, 'Laptop', 1000.00);
INSERT INTO item (id, name, price) VALUES (2, 'Smartphone', 500.00);
INSERT INTO item (id, name, price) VALUES (3, 'Headphones', 100.00);
INSERT INTO item (id, name, price) VALUES (4, 'Keyboard', 50.00);
INSERT INTO item (id, name, price) VALUES (5, 'Mouse', 25.00);

-- Insert Wishlists
INSERT INTO wishlist (id, customer_id) VALUES (1, 1);
INSERT INTO wishlist (id, customer_id) VALUES (2, 2);

-- Insert Wishlist Items
INSERT INTO wishlist_items (wishlist_id, items_id) VALUES (1, 1);
INSERT INTO wishlist_items (wishlist_id, items_id) VALUES (1, 3);
INSERT INTO wishlist_items (wishlist_id, items_id) VALUES (2, 2);
INSERT INTO wishlist_items (wishlist_id, items_id) VALUES (2, 4);

-- Insert Sales
INSERT INTO sale (id, date, amount, item_id) VALUES (1, '2024-07-01', 1000.00, 1);
INSERT INTO sale (id, date, amount, item_id) VALUES (2, '2024-07-01', 500.00, 2);
INSERT INTO sale (id, date, amount, item_id) VALUES (3, '2024-07-02', 100.00, 3);
INSERT INTO sale (id, date, amount, item_id) VALUES (4, '2024-07-02', 50.00, 4);
INSERT INTO sale (id, date, amount, item_id) VALUES (5, '2024-07-03', 25.00, 5);
INSERT INTO sale (id, date, amount, item_id) VALUES (6, '2024-07-03', 1000.00, 1);
INSERT INTO sale (id, date, amount, item_id) VALUES (7, '2024-07-03', 500.00, 2);
INSERT INTO sale (id, date, amount, item_id) VALUES (8, '2024-07-05', 100.00, 3);
INSERT INTO sale (id, date, amount, item_id) VALUES (9, '2024-07-05', 50.00, 4);
INSERT INTO sale (id, date, amount, item_id) VALUES (10, '2024-07-04', 25.00, 5);









