
CREATE TABLE users (
codUser int PRIMARY KEY NOT NULLemail varchar(40) NOT NULL,
password varchar(40) NOT null
);

CREATE TABLE items (
codItem int PRIMARY KEY NOT NULL,
description varchar(40) NOT null ,
price double NOT NULL,
quantity int NOT NULL 
);

CREATE TABLE orders(
codOrder int PRIMARY KEY NOT NULL,
codUser int NOT NULL 
);


CREATE TABLE objects(
codObject int PRIMARY KEY NOT NULL,
codItem int NOT NULL ,
codOrder int NOT NULL
);

