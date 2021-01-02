CREATE TABLE categories (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	created_at datetime NOT NULL,
	updated_at datetime NOT NULL,
	
	PRIMARY KEY(id)
);

CREATE TABLE products (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	category_id bigint(20),
	name VARCHAR(255) NOT NULL,
	price DECIMAL(9,2) NOT NULL,
	amount INT NOT NULL,
	created_at datetime NOT NULL,
	updated_at datetime NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(category_id) REFERENCES categories(id)
);

CREATE TABLE users (
	id bigint(20) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	profile VARCHAR(255) NOT NULL,

	PRIMARY KEY(id)
);

INSERT INTO users(email, password, profile) VALUES ('user@email.com', '$2a$10$ZPoIDuSioyf2HvWmFr01o.wZDl02cwUsaIdz7/qOQ285FZjpRS5hy', 'ROLE_ADMIN');
