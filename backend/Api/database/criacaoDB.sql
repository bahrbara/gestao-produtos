CREATE TABLE User (
    id_user INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    cpf VARCHAR NOT NULL,
    birth_date DATE,
    UNIQUE (id_user, cpf)
);

CREATE TABLE Product (
    id_product INTEGER PRIMARY KEY,
    sku VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    price DECIMAL NOT NULL,
    amount VARCHAR NOT NULL,
    UNIQUE (id_product)
);

CREATE TABLE Order (
    id_order INTEGER PRIMARY KEY,
    id_user INTEGER,
    id_products_order INTEGER,
    amt_purchase DECIMAL NOT NULL,
    dt_purchase DATE,
    UNIQUE (id_order)
);

CREATE TABLE Products_order (
    id_products_order INTEGER,
    id_order INTEGER NOT NULL,
    id_product INTEGER NOT NULL,
    UNIQUE (id_products_order)
);

ALTER TABLE Order ADD CONSTRAINT FK_Order_0
    FOREIGN KEY (id_user)
    REFERENCES User (id_user);
 
ALTER TABLE Order ADD CONSTRAINT FK_Order_1
    FOREIGN KEY (id_products_order)
    REFERENCES Products_order (id_products_order);

ALTER TABLE Products_order ADD CONSTRAINT FK_Products_order_0
    FOREIGN KEY (id_order)
    REFERENCES Order (id_order);

ALTER TABLE Products_order ADD CONSTRAINT FK_Products_order_0
    FOREIGN KEY (id_product)
    REFERENCES Product (id_product);

CREATE SEQUENCE hibernate_sequence START 1;