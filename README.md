[![Github Actions Status for GuilhermeSchveitzer/A3_Gestao_Qualidade_de_Software](https://github.com/GuilhermeSchveitzer/A3_Gestao_Qualidade_de_Software/workflows/Integra%C3%A7%C3%A3o%20continua%20de%20Java%20com%20Maven/badge.svg)](https://github.com/GuilhermeSchveitzer/A3_Gestao_Qualidade_de_Software/actions) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=GuilhermeSchveitzer_A3_Gestao_Qualidade_de_Software&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=GuilhermeSchveitzer_A3_Gestao_Qualidade_de_Software)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=GuilhermeSchveitzer_A3_Gestao_Qualidade_de_Software&metric=coverage)](https://sonarcloud.io/component_measures?id=GuilhermeSchveitzer_A3_Gestao_Qualidade_de_Software&metric=coverage)

# 💻 Projeto de Empréstimo de Ferramentas – Java (1ª Fase)

Este repositório contém um projeto desenvolvido na primeira fase do curso de graduação, cujo objetivo é gerenciar o **empréstimo de ferramentas** entre amigos. A aplicação foi construída com **Java**, utilizando **NetBeans** como IDE e **SQLite3** como banco de dados. O projeto está sendo evoluído para aplicar conceitos de **Clean Code** e **testes automatizados com JUnit**.

---

## 📌 Objetivos do Projeto

- Criar um sistema simples para **cadastro de amigos** e **ferramentas**.
- Realizar o **controle de empréstimos** dessas ferramentas.
- Estabelecer uma conexão persistente com o **banco de dados SQLite3**.
- Utilizar padrões de desenvolvimento como **DAO** para organização das telas e acesso a dados.

---

## 👥 Alunos / Desenvolvedores

  Bernardo Santos Vieira - RA: 1072415392 - GitHub: <a href="https://github.com/BernardoSVieira">bernardosvieira</a><br>
  Guilherme Schveitzer - RA: 1072415715 - GitHub: <a href="https://github.com/GuilhermeSchveitzer">guilhermeSchveitzer</a> - PC Gamer<br>
  Victor Hasse - RA: 10724111755 - GitHub: <a href="https://github.com/victorhasse">victorhasse</a><br>
  Igor Vinicius Sotile Mirandolli - RA: 1072416369 - GitHub: <a href="https://github.com/IgorMirandolli">igormirandolli</a><br>

---

## 🧱 Estrutura Inicial

O sistema conta com as seguintes classes principais:

- `Amigo`: Responsável por armazenar os dados da pessoa que pode pegar ferramentas emprestadas.
- `Ferramenta`: Responsável por armazenar os dados das ferramentas disponíveis.
- `Conexao`: Classe que realiza a conexão com o banco de dados SQLite.
- `DAO`: Camada de acesso aos dados utilizada pelas telas da aplicação.

---

## 🚀 Tecnologias Utilizadas

- [Java](https://www.oracle.com/java/) - Versão: 21
- [NetBeans](https://netbeans.apache.org/)
- [SQLite3](https://www.sqlite.org/index.html) - Versão: 3.49.2
- [Maven](https://maven.apache.org/)
- [JUnit](https://junit.org/) - Versão: 5.9.0.
- [GitHub Actions](https://github.com/features/actions)
- JaCoCo  Versão: 0.8.8.

---

## 🧼 Melhorias em Andamento

Este projeto está passando por uma refatoração com os seguintes focos:

- Aplicação de princípios de **Clean Code** para melhorar legibilidade e manutenção.
- **Cobertura de testes automatizados com JUnit** em pelo menos 50% do código.
- Criação de pipelines de **CI com GitHub Actions** para automatizar testes e builds.
- Registro do **antes e depois da refatoração** para fins de aprendizado e comparação.

---

## 🧪 Testes

Estamos implementando testes unitários com **JUnit 5**, buscando alcançar pelo menos **50% de cobertura de código**.  
Os testes serão automatizados via **GitHub Actions**, garantindo que a qualidade seja mantida a cada commit.
