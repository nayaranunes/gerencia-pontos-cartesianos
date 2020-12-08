CREATE TABLE ponto
(
    id         BIGINT           NOT NULL PRIMARY KEY,
    abscissa   DOUBLE PRECISION NOT NULL,
    ordenada   DOUBLE PRECISION NOT NULL,
    quadrante  INTEGER          NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);

CREATE SEQUENCE IF NOT EXISTS ponto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;