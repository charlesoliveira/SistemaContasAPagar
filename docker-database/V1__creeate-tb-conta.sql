CREATE TABLE IF NOT EXISTS TB_CONTA (
    id SERIAL PRIMARY KEY,
    dataVencimento DATE NOT NULL,
    dataPagamento DATE,
    valor NUMERIC(10, 2) NOT NULL,
    descricao VARCHAR(255),
    situacao VARCHAR(50) NOT NULL
    );