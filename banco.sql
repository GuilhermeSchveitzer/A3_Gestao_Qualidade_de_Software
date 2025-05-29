CREATE DATABASE IF NOT EXISTS db_a3;

USE db_a3;

DROP TABLE IF EXISTS tb_amigos;
DROP TABLE IF EXISTS tb_ferramentas;
DROP TABLE IF EXISTS tb_emprestimos;


# criando tabela dos amigos
CREATE TABLE tb_amigos (
    idAmigo INTEGER NOT NULL,
    nomeAmigo VARCHAR(100),
    telefone VARCHAR(100),
    PRIMARY KEY(idAmigo)
);

# criando tabela das ferramentas
CREATE TABLE tb_ferramentas (
    idFerramenta INTEGER NOT NULL,
    nomeFerramenta VARCHAR(100),
    marca VARCHAR(100),
    custo DOUBLE,
    PRIMARY KEY(idFerramenta)
);

# criando tabela dos emprestimos 
CREATE TABLE tb_emprestimos (
    idEmprestimo INTEGER NOT NULL,
    idAmigo INTEGER,
    idFerramenta INTEGER,
    dataEmprestimo DATE,
    dataDevolucao DATE,
    pendente BOOLEAN,
    PRIMARY KEY(idEmprestimo)
);



# inserindo amigos na BD
INSERT INTO tb_amigos(idAmigo,nomeAmigo,telefone) VALUES (1,"João","48999666847");
INSERT INTO tb_amigos(idAmigo,nomeAmigo,telefone) VALUES (2,"José","48991234589");
INSERT INTO tb_amigos(idAmigo,nomeAmigo,telefone) VALUES (3,"Maria","489923452145");

# inserindo ferramentas
INSERT INTO tb_ferramentas(idFerramenta, nomeFerramenta, marca, custo) VALUES (1, 'chave de fenda', 'philips', 9.99);
INSERT INTO tb_ferramentas(idFerramenta, nomeFerramenta, marca, custo) VALUES (2, 'furadeira', 'samsung', 109.99);

# inserindo emprestimos na tabela de emprestimos
INSERT INTO tb_emprestimos(idEmprestimo,idAmigo,idFerramenta,dataEmprestimo,dataDevolucao,pendente) VALUES (1,NULL,NULL,NULL,NULL,true);
INSERT INTO tb_emprestimos(idEmprestimo,idAmigo,idFerramenta,dataEmprestimo,dataDevolucao,pendente) VALUES (2,NULL,NULL,NULL,NULL,true);
INSERT INTO tb_emprestimos(idEmprestimo,idAmigo,idFerramenta,dataEmprestimo,dataDevolucao,pendente) VALUES (3,NULL,NULL,NULL,NULL,true);
