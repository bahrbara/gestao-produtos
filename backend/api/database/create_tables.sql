CREATE TABLE users (
    id_user INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    birth_date DATE,
    UNIQUE (id_user, cpf)
);

CREATE TABLE products (
    id_product INTEGER PRIMARY KEY,
    sku VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    price DECIMAL NOT NULL,
    amount VARCHAR NOT NULL,
    UNIQUE (id_product)
);

CREATE TABLE orders (
    id_order INTEGER PRIMARY KEY,
    id_user INTEGER,
    id_products_order INTEGER,
    amt_purchase DECIMAL NOT NULL,
    dt_purchase DATE,
    UNIQUE (id_order)
);

CREATE TABLE products_order (
    id_products_order INTEGER,
    id_order INTEGER NOT NULL,
    id_product INTEGER NOT NULL,
    UNIQUE (id_products_order)
);

ALTER TABLE orders ADD CONSTRAINT FK_order_0
    FOREIGN KEY (id_user)
    REFERENCES users (id_user);
 
ALTER TABLE orders ADD CONSTRAINT FK_Order_1
    FOREIGN KEY (id_products_order)
    REFERENCES products_order (id_products_order);

ALTER TABLE products_order ADD CONSTRAINT FK_Products_order_0
    FOREIGN KEY (id_order)
    REFERENCES orders (id_order);

ALTER TABLE products_order ADD CONSTRAINT FK_Products_order_1
    FOREIGN KEY (id_product)
    REFERENCES product (id_product);

CREATE SEQUENCE hibernate_sequence START 1;