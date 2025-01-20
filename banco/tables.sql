CREATE TABLE transactions (
    id_movimentacao INT PRIMARY KEY,
    valor_movimentacao DECIMAL(7, 2),
    titulo_movimentacao VARCHAR(50),
    descricao_movimentacao VARCHAR(100),
    data_movimentacao DATE,
    id_etiqueta INT,
    id_saida INT,
    id_entrada INT,
    id_reserva INT
);

CREATE TABLE expense (
    id_saida INT PRIMARY KEY,
    parcelamento INT,
    saida_recorrente BOOLEAN
);

CREATE TABLE income (
    id_entrada INT PRIMARY KEY,
    entrada_recorrente BOOLEAN
);

CREATE TABLE tags (
    id_etiqueta INT PRIMARY KEY,
    nome_etiqueta VARCHAR(20) UNIQUE,
    tipo_etiqueta VARCHAR(20)
    cor_etiqueta VARCHAR(20)
);

CREATE TABLE reserves (
    id_reserva INT PRIMARY KEY,
    titulo_reserva VARCHAR(50) UNIQUE,
    descricao_reserva VARCHAR(100),
    valor_atual_reserva DECIMAL(7, 2),
    valor_max_reserva DECIMAL(7, 2)
);

CREATE TABLE installments (
    id_parcela INT PRIMARY KEY,
    id_saida INT,
    num_parcela INT,
    valor_parcela DECIMAL(7, 2),
    data_vencimento_parcela DATE
);
 
ALTER TABLE movimentacoes ADD CONSTRAINT FK_movimentacoes_2
    FOREIGN KEY (id_saida)
    REFERENCES saida (id_saida);
 
ALTER TABLE movimentacoes ADD CONSTRAINT FK_movimentacoes_3
    FOREIGN KEY (id_entrada)
    REFERENCES entrada (id_entrada);
 
ALTER TABLE movimentacoes ADD CONSTRAINT FK_movimentacoes_4
    FOREIGN KEY (id_etiqueta)
    REFERENCES etiquetas (id_etiqueta);
 
ALTER TABLE movimentacoes ADD CONSTRAINT FK_movimentacoes_5
    FOREIGN KEY (id_reserva)
    REFERENCES reservas (id_reserva);
 
ALTER TABLE parcelamento ADD CONSTRAINT FK_parcelamento_2
    FOREIGN KEY (id_saida)
    REFERENCES saida (id_saida);