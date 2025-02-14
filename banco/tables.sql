CREATE TABLE transactions (
    id_transaction INTEGER PRIMARY KEY,
    transaction_amount REAL,
    transaction_title TEXT,
    transaction_description TEXT,
    transaction_date DATE, /* generic data */
    id_expense INTEGER,
    id_income INTEGER,
    id_reserve INTEGER,
    FOREIGN KEY (id_expense) REFERENCES expenses (id_expense),
    FOREIGN KEY (id_income) REFERENCES incomes (id_income),
    FOREIGN KEY (id_reserve) REFERENCES reserves (id_reserve)
);

CREATE TABLE expenses (
    id_expense INTEGER PRIMARY KEY,
    id_installment INTEGER, 
    recurring_expense INTEGER, /* boolean */
    FOREIGN KEY (id_installment) REFERENCES installments (id_installment)
);

CREATE TABLE incomes (
    id_income INTEGER PRIMARY KEY,
    recurring_income INTEGER /* boolean */
);

CREATE TABLE tags (
    id_tag INTEGER PRIMARY KEY,
    tag_name TEXT UNIQUE,
    tag_type TEXT
);

CREATE TABLE reserves (
    id_reserve INTEGER PRIMARY KEY,
    reserve_title TEXT UNIQUE,
    reserve_description TEXT,
    current_reserve_amount REAL,
    max_reserve_amount REAL
);

CREATE TABLE installments (
    id_installment INTEGER PRIMARY KEY,
    installment_number INTEGER,
    installment_amount REAL,
    installment_due_date DATE
);

CREATE TABLE tags_transactions (
    id_transaction INTEGER,
    id_tag INTEGER,
    PRIMARY KEY (id_tag, id_transaction),
    FOREIGN KEY (id_tag) REFERENCES tags (id_tag),
    FOREIGN KEY (id_transaction) REFERENCES transactions (id_transaction)
);