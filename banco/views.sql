CREATE VIEW all_transactions AS
SELECT t.id_transaction, 
t.transaction_title, 
t.transaction_description, 
t.transaction_amount, 
t.transaction_date
-- condicional
CASE
    WHEN t.id_expense IS NOT NULL THEN 'Despesa'
    WHEN t.id_income IS NOT NULL THEN 'Entrada'
    WHEN t.id_reserve IS NOT NULL THEN 'Reserva'
    ELSE 'Outro'
END AS transaction_type,
i.installment_number,
i.installment_amount,
i.installment_due_date
FROM 
    transactions t
LEFT JOIN
    expenses e ON t.id_expense = e.id_expense
LEFT JOIN 
    incomes i ON t.id_income = i.id_income
