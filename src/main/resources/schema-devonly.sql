DROP TABLE IF EXISTS currency;
create table IF NOT EXISTS currency
(
	currency_ID integer not null,
	currency_Code varchar (5) not null,
	Description varchar (255) not null,
	primary key (currency_Id)
);
DROP TABLE IF EXISTS fx;
create table IF NOT EXISTS fx
(
	fx_id integer auto_increment not null,
	contract_reference varchar (255) not null,
	exchange_rate decimal not null,
	original_amount decimal not null,
	original_currency varchar(255) not null,
	primary key (fx_id)
);
