DROP TABLE IF EXISTS accounts CASCADE;

create table accounts(
  iban       VARCHAR(34) PRIMARY KEY ,
  bic        varchar(25)
);


