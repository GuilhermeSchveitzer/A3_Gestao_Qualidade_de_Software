**💻 Projeto de Empréstimo de Ferramentas – Java (1ª Fase)**
Este repositório contém um projeto desenvolvido na primeira fase do curso de graduação, cujo objetivo é gerenciar o empréstimo de ferramentas. A aplicação foi construída com Java, utilizando NetBeans como IDE e SQLite3 como banco de dados. O projeto está sendo evoluído para aplicar conceitos de Clean Code e testes automatizados com JUnit.

*📌 Objetivos do Projeto*
Criar um sistema simples para cadastro de amigos e ferramentas.

Realizar o controle de empréstimos dessas ferramentas.

Estabelecer uma conexão persistente com o banco de dados SQLite3.

Utilizar padrões de desenvolvimento como DAO para organização das telas e acesso a dados.

*🧱 Estrutura Inicial*
O sistema conta com as seguintes classes principais:

Amigo: Responsável por armazenar os dados da pessoa que pode pegar ferramentas emprestadas.

Ferramenta: Responsável por armazenar os dados das ferramentas disponíveis.

Conexao: Classe que realiza a conexão com o banco de dados SQLite.

DAO: Camada de acesso aos dados utilizada pelas telas da aplicação.

*🚀 Tecnologias Utilizadas*
Java

NetBeans

SQLite3

Maven

JUnit

GitHub Actions

*🧼 Melhorias em Andamento*
Este projeto está passando por uma refatoração com os seguintes focos:

Aplicação de princípios de Clean Code para melhorar legibilidade e manutenção.

Cobertura de testes automatizados com JUnit em pelo menos 50% do código.

Criação de pipelines de CI com GitHub Actions para automatizar testes e builds.

Registro do antes e depois da refatoração para fins de aprendizado e comparação.

*🧪 Testes*
Estamos implementando testes unitários com JUnit 5, buscando alcançar pelo menos 50% de cobertura de código. Os testes serão automatizados via GitHub Actions, garantindo que a qualidade seja mantida a cada commit.
