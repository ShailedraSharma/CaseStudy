create database ECommerce;
use  ECommerce;
CREATE TABLE customer (
    customerId BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    productId BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(255),
    stockQuantity INT NOT NULL
);

CREATE TABLE cart (
    cartId BIGINT PRIMARY KEY auto_increment,
    customerId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(customerId),
    FOREIGN KEY (productId) REFERENCES product(productId)
);

CREATE TABLE orders (
    orderId BIGINT PRIMARY KEY auto_increment,
    customerId BIGINT NOT NULL,
    orderDate DATE NOT NULL,
    totalPrice INT NOT NULL,
    shippingAddress VARCHAR(255) NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE orderItems (
    orderItemId BIGINT PRIMARY KEY auto_increment,
    orderId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (orderId) REFERENCES orders(orderId),
    FOREIGN KEY (productId) REFERENCES product(productId)
);



