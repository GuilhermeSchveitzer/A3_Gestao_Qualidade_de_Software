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

- [Java](https://www.oracle.com/java/)
- [NetBeans](https://netbeans.apache.org/)
- [SQLite3](https://www.sqlite.org/index.html)
- [Maven](https://maven.apache.org/)
- [JUnit](https://junit.org/)
- [GitHub Actions](https://github.com/features/actions)

---

## ✨ Versão das Tecnologias

JaCoCo 0.8.8.
JUnit 5.9.0.
Java 21
SQLite 3.49.2


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
