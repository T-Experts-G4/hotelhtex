INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('fidel@email.com', '123', 'USUARIO');
INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('01001-000', 'Praça da Sé', 'lado ímpar', 'Sé', 'São Paulo', 'SP');
INSERT INTO CLIENTES (NOME, CPF, TELEFONE, ENDERECO_ID, USUARIO_ID) VALUES ('Fidel', '0992828822','99 9999-9999', 1, 1);

INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('adriano@email.com', '123', 'ADMIN');
INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('01001-000', 'Praça da Sé', 'lado ímpar', 'Sé', 'São Paulo', 'SP');
INSERT INTO CLIENTES (NOME, CPF, TELEFONE, ENDERECO_ID, USUARIO_ID)
    VALUES ('Adriano', '0992828822','99 9999-9999', 2, 2);

INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('ygor@email.com', '123', 'USUARIO');
INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('01001-000', 'Praça da Sé', 'lado ímpar', 'Sé', 'São Paulo', 'SP');
INSERT INTO CLIENTES (NOME, CPF, TELEFONE, ENDERECO_ID, USUARIO_ID) VALUES ('Ygor', '0992828822','99 9999-9999', 3, 3);

INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('silvio@email.com', '123', 'USUARIO');
INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('01001-000', 'Praça da Sé', 'lado ímpar', 'Sé', 'São Paulo', 'SP');
INSERT INTO CLIENTES (NOME, CPF, TELEFONE, ENDERECO_ID, USUARIO_ID) VALUES ('Silvio', '0992828822','99 9999-9999', 4, 4);

INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('anderson@email.com', '123', 'USUARIO');
INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('01001-000', 'Praça da Sé', 'lado ímpar', 'Sé', 'São Paulo', 'SP');
INSERT INTO CLIENTES (NOME, CPF, TELEFONE, ENDERECO_ID, USUARIO_ID)
    VALUES ('Anderson', '0992828822','99 9999-9999', 5, 5);

INSERT INTO USUARIOS (EMAIL, SENHA, USUARIO_ROLE) VALUES ('adm@email.com', '123', 'ADMIN');
INSERT INTO FUNCIONARIOS (CARGO, MATRICULA, NOME, USUARIO_ID)
    VALUES ('ADMIN', '0992828822','ADMINISTRADO', 6);

INSERT INTO ENDERECOS (cep, logradouro, complemento, bairro, localidade, uf)
    VALUES('11650-2025', 'rua sem fim', 'lado par', 'ja foi', 'São Paulo', 'SP');

INSERT INTO HOTEIS (cnpj, nome, telefone, endereco_id)
    VALUES('0992828822/002', 'Hotel Tex', '333-33333', 6);

INSERT INTO QUARTOS (disponivel, numero, preco, hotel_id)
    VALUES(true, 1, 100, 1);

INSERT INTO QUARTOS (disponivel, numero, preco, hotel_id)
    VALUES(true, 2, 200, 1);

INSERT INTO QUARTOS (disponivel, numero, preco, hotel_id)
    VALUES(true, 3, 300, 1);

INSERT INTO SERVICOS (nome, preco) VALUES('SEM SERVICO', 0);
INSERT INTO SERVICOS (nome, preco) VALUES('Almoco', 70.0);
INSERT INTO SERVICOS (nome, preco) VALUES('Janta', 50.0);
INSERT INTO SERVICOS (nome, preco) VALUES('Massagem', 80.0);
INSERT INTO SERVICOS (nome, preco) VALUES('ALUGUEL DE EQUIPAMENTOS', 50.0);
INSERT INTO SERVICOS (nome, preco) VALUES('INTERPRETE', 150.0);
INSERT INTO SERVICOS (nome, preco) VALUES('TRASLADO', 50.0);


