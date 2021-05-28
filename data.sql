create table tb_stock (
	id int8 not null generated by default as identity,
	"date" date not null,
	"name" varchar(100) not null,
	price numeric(8, 2) not null,
	variation numeric(5, 2) not null,
	constraint tb_stock_pkey primary key (id)
);