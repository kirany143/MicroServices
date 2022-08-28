CREATE TABLE account (
    id bigint NOT NULL PRIMARY KEY,
    sort_code CHAR(8) NOT NULL,
    account_number CHAR(8) NOT NULL,
    current_balance NUMERIC(10,3) NOT NULL,
    bank_name VARCHAR(50) NOT NULL,
    owner_name VARCHAR(50) NOT NULL,
    ic_number VARCHAR(50) NOT NULL,
    mother_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    company_name VARCHAR(50) NOT NULL,
    UNIQUE (sort_code, account_number)
);