CREATE TABLE tb_product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description TEXT,
    category_id BIGINT,
    price INT NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255)
);

CREATE TABLE tb_category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255)
);

CREATE TABLE tb_member (
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zipcode INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255)
 );

 CREATE TABLE tb_order (
     order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     member_id BIGINT,
     order_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     address VARCHAR(255) not null,
     order_status VARCHAR(20),
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     created_by VARCHAR(255) NOT NULL,
     updated_by VARCHAR(255)
 );

CREATE TABLE tb_order_detail (
    order_detail_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NUlL,
    price int NOT NULl,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255)
);

CREATE TABLE tb_payment (
    payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULl,
    payment_at DATE NOT NUlL,
    amount int NOT NULL,
    payment_method VARCHAR(20) NOT NUlL,
    transaction_id VARCHAR(100) UNIQUE,
    payment_status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255)
);

INSERT INTO tb_category(category_name, created_by)VALUES('outer','je');
INSERT INTO tb_category(category_name, created_by)VALUES('top','je');
INSERT INTO tb_category(category_name, created_by)VALUES('pants','je');
INSERT INTO tb_category(category_name, created_by)VALUES('dress','je');
INSERT INTO tb_category(category_name, created_by)VALUES('Accessories','je');
INSERT INTO tb_category(category_name, created_by)VALUES('bag','je');
INSERT INTO tb_category(category_name, created_by)VALUES('shoes','je');
INSERT INTO tb_product(product_name, category_id, price, stock, created_by) VALUES('test1', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test2', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test3', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test4', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test5', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test6', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test7', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test8', 1, 1000, 100, 'system');
INSERT INTO tb_product(product_name, category_id, price, stock) VALUES('test9', 1, 1000, 100, 'system');


