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