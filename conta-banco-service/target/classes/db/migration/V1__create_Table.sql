CREATE TABLE conta (
    id bigint NOT NULL,
    idConta bigint NOT NULL,
    nome character varying(200) NOT NULL,
    cpf character varying(13) NOT NULL,
    valor numeric(16,2),
    dataCadastro timestamp NOT NULL,
    CONSTRAINT pk_conta PRIMARY KEY (id)
);