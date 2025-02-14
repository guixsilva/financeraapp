CREATE TABLE movimentacoes (
    id_movimentacao INT PRIMARY KEY,
    valor_movimentacao NUMERIC(11, 2),
    titulo_movimentacao VARCHAR(30),
    descricao_movimentacao VARCHAR(50),
    data_movimentacao DATE,
    id_saida INT,
    id_entrada INT,
    id_reserva INT,
    FOREIGN KEY (id_saida) REFERENCES saida (id_saida),
    FOREIGN KEY (id_entrada) REFERENCES entrada (id_entrada),
    FOREIGN KEY (id_reserva) REFERENCES reservas (id_reserva)
);

CREATE TABLE saida (
    id_saida INT PRIMARY KEY,
    parcelamento INT,
    saida_recorrente INTEGER --boolean
);

CREATE TABLE entrada (
    id_entrada INT PRIMARY KEY,
    entrada_recorrente INTEGER --boolean
);

CREATE TABLE etiquetas (
    id_etiqueta INT PRIMARY KEY,
    nome_etiqueta VARCHAR(20) UNIQUE,
    tipo_etiqueta VARCHAR(20)
);

CREATE TABLE reservas (
    id_reserva INT PRIMARY KEY,
    titulo_reserva VARCHAR(30) UNIQUE,
    descricao_reserva VARCHAR(50),
    valor_atual_reserva NUMERIC(11, 2),
    valor_max_reserva NUMERIC(11,2)
);

CREATE TABLE parcelamento (
    id_parcela INT PRIMARY KEY,
    id_saida INT,
    num_parcela INT,
    valor_parcela NUMERIC(11,2),
    data_vencimento_parcela DATE,
    FOREIGN KEY (id_saida) REFERENCES saida (id_saida)
);

CREATE TABLE "etiquetas de transações" (
    id_movimentação INT,
    id_etiqueta INT,
    PRIMARY KEY (id_etiqueta, id_movimentação),
    FOREIGN KEY (id_etiqueta) REFERENCES etiquetas (id_etiqueta),
    FOREIGN KEY (id_movimentação) REFERENCES movimentacoes (id_movimentacao)
);