# Interface para empréstimo de ferramentas

## 📖 Introdução 
Projeto para a UC de programação do curso de Sistemas de Informação. Consiste em uma interface gráfica para registrar amigos, ferramentas e conceder e gerenciar empréstimos
dessas ferramentas para esses amigos, com tudo sendo registrado em um banco de dados com mySQL.

## 🧭Status do Projeto
- Concluído.

## 💻Tecnologias utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=javafx&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)


  ### Principais funcionalidades
```bash
. CRUD de amigos: Criar, ler, atualizar ou deletar amigos da BD.
. CRUD de ferramentas: Criar, ler, atualizar ou deletar ferramentas da BD.
. CRUD de empréstimos: Criar, ler, atualizar ou deletar empréstimos da BD.
. Interface gráfica: Possui uma interface gráfica feita com JavaFX para ser possível realizar cada uma das funcionalidades.
```

  ### Requisitos Funcionais
```bash
. RF001 - Cadastrar ferramentas com nome, marca e custo.
. RF002 - Cadastrar amigo com nome, telefone e e-mail.
. RF003 - Registrar o empréstimo da(s) ferramentas(s) ao amigo, incluindo a data 
de empréstimo e devolução.
. RF004 - O programa deve ter uma lista de todas as ferramentas e o valor gasto 
nelas.
. RF005 - Mostrar relatório de todos os empréstimos ativos.
. RF006 - Mostrar relatório de todos os empréstimos realizados.
. RF007 - Mostrar qual amigo fez mais empréstimos.
. RF008 - Mostrar se algum amigo nunca devolveu uma ferramenta.
. RF009 - Ao fazer um novo empréstimo, mostrar se o amigo tem alguma
ferramenta não devolvida.
```
  ### Requisitos não funcionais
```bash
. RNF001 - O programa deve rodar localmente em um computador pessoal com o Windows 11.
. RNF002 - O programa deve ser desenvolvido em Java 22.0.1.
. RNF002 - O programa deve ser conectado a uma base de dados usando mySQL 8.4.0.
```

## Configurando BD
Usuário: root

Senha: root

Scripts usados no mySQL estão no arquivo banco.sql

## 💡IDE utilizada:
- NetBeans


## Telas
<img src="./FrmMenuPrincipal.png" height=300 width=300>  | <img src="./FrmCadastroAmigo.png" height=300  width=300>  |  <img src="./FrmCadastroEmprestimo.png" height=300  width=300>  |  <img src="./FrmGerenciaAmigo.png" height=300  width=300>  |  <img src="./FrmGerenciaFerramenta.png" height=300  width=300>  |  <img src="./FrmGerenciaEmprestimo.png" height=300  width=300>  

## Desenvolvedores

```bash
. João Pedro Becker Ayres (1072417223, JP-Becker)
. Bernardo Antoniolli (1072414784, Computador, Bernardo)
. Igor Mirandolli (1072416369)
. Luiz Henrique Garcia Ribeiro (0Gandalfo)
. Hiago de Mendonça (1072419632, HiagoDeMendonca)
```
