# Sistema CRUD de Clientes

## 📌 Descrição do Projeto

Este projeto consiste em um **Sistema CRUD de Clientes**, desenvolvido com o objetivo de praticar e aprimorar **lógica de programação** e **Programação Orientada a Objetos (POO)**.
O sistema permite realizar operações completas de gerenciamento de clientes, utilizando o banco de dados **SQLite** para persistência dos dados.

CRUD é um acrônimo para:

* **C**reate (Criar)
* **R**ead (Ler)
* **U**pdate (Atualizar)
* **D**elete (Remover)

---

## ⚙️ Funcionalidades

O sistema oferece as seguintes funcionalidades:

* ✅ Cadastrar cliente
* 📋 Listar todos os clientes
* 🔍 Buscar cliente por identificador
* ✏️ Atualizar dados do cliente
* ❌ Remover cliente
* 🧹 Limpar todos os registros do banco de dados

---

## 🧠 Justificativa

Este projeto foi desenvolvido com foco em:

* Aprimorar a **lógica de programação**
* Consolidar conceitos de **Programação Orientada a Objetos (POO)**
* Praticar a integração de aplicações com **banco de dados SQLite**
* Simular um sistema real de cadastro e gerenciamento de dados

---

## 🛠️ Tecnologias Utilizadas

> 📌 **Observação:** Atualmente, o sistema funciona **via console (terminal)**.

* **Linguagem:** Java
* **Banco de Dados:** SQLite
* **Paradigma:** Programação Orientada a Objetos (POO)
* **IDE recomendada:** IntelliJ IDEA (ou qualquer IDE compatível com Java)

---

## 📥 Como Baixar o Projeto

1. Acesse este repositório no GitHub
2. Clique no botão **Code**
3. Escolha uma das opções:

   * **Download ZIP** (extraia os arquivos após o download)
   * **Clone via Git**:

     ```bash
     git clone https://github.com/ikaro9/SistemaCrudClientesBD
     ```

---

## 🚀 Como Instalar e Executar o Sistema

### Pré-requisitos

* Java JDK 8 ou superior instalado
* SQLite (ou driver SQLite incluído no projeto)
* IDE Java ou terminal configurado

### Passos para execução

1. Abra o projeto em sua IDE Java
2. Verifique se o driver SQLite está corretamente configurado
3. Compile o projeto
4. Execute a classe principal (`Main` ou equivalente)

O banco de dados SQLite será criado automaticamente (caso ainda não exista).

---

## 📖 Passo a Passo de Utilização do Sistema

1. Ao iniciar o sistema, um menu será exibido com as opções disponíveis
2. Escolha a operação desejada digitando o número correspondente

### Exemplo de uso:

* **Cadastrar cliente:**

  * Informe nome, telefone e e-mail

* **Listar clientes:**

  * Exibe todos os clientes cadastrados

* **Buscar cliente:**

  * Informe o ID do cliente

* **Atualizar cliente:**

  * Informe o ID e os novos dados

* **Remover cliente:**

  * Informe o ID do cliente a ser removido

* **Limpar registros:**

  * Remove todos os dados da tabela de clientes

---

## 🗂️ Estrutura do Projeto

Estrutura real do projeto conforme organização atual:

```
Sistema-de-Cadastro-de-Clientes/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── ikarodev/
│   │   │           ├── dao/
│   │   │           │   └── ClienteDAO.java
│   │   │           ├── db/
│   │   │           │   └── Conexao.java
│   │   │           ├── menu/
│   │   │           │   ├── Menu.java
│   │   │           │   └── Utilitarios.java
│   │   │           ├── model/
│   │   │           │   └── Cliente.java
│   │   │           └── Main.java
│   │   └── resources/
│   └── test/
├── target/
├── clientes.db
├── pom.xml
└── .gitignore
```

Essa estrutura segue uma separação por responsabilidade:

* **dao**: acesso e manipulação dos dados no banco
* **db**: conexão com o SQLite
* **menu**: interface de interação via console
* **model**: representação da entidade Cliente
* **Main**: ponto de entrada da aplicação

---

## 👨‍💻 Desenvolvedor

**Nome:** Ikaro Ferreira Brito
**Área de Estudo:** Tecnologia da Informação
**Objetivo:** Aprendizado prático em desenvolvimento de sistemas, lógica de programação e POO

* GitHub: [*https://github.com/ikaro9*](https://github.com/ikaro9)
* LinkedIn: [www.linkedin.com/in/ikaro-ferreira-ti](http://www.linkedin.com/in/ikaro-ferreira-ti)

---

## 📌 Melhorias Futuras (Sugestões)

* 🔐 Validação avançada de dados
* 🖥️ Interface gráfica (Swing ou JavaFX)
* 📊 Relatórios de clientes
* 🔍 Filtros e ordenação de dados
* 🧪 Testes automatizados

---

## 📄 Licença

Este projeto é de uso educacional e livre para estudos e modificações.

---

✨ *Projeto desenvolvido para fins de aprendizado e evolução na programação.*
