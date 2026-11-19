# 🏢 Sistema de Gestão Empresarial em Java (POO Pura)

Projeto desenvolvido em Java puro com o objetivo de consolidar os pilares da **Programação Orientada a Objetos (POO)**, aplicando boas práticas de desenvolvimento, modelagem de domínio consistente e validações rigorosas de dados (*Fail-Fast*).

---

## 🚀 Conceitos Aplicados

O sistema foi arquitetado para demonstrar domínio sobre os fundamentos da engenharia de software e da linguagem Java:

* **Classes Abstratas e Herança (`extends`):** Centralização de comportamentos e atributos comuns na classe base `Funcionario`, estendida por papéis específicos (`Gerente`, `Desenvolvedor`, `Estagiário` e `Vendedor`).
* **Polimorfismo:** Sobrescrita de métodos (`@Override`) para adaptar dinamicamente o cálculo de remuneração de acordo com as regras de negócio de cada cargo.
* **Encapsulamento Rigoroso:** Proteção de estado com atributos `private`, acesso restrito via `getters` e validações em tempo de instanciação nos `setters`.
* **Validação Antecipada (Fail-Fast):** Lançamento imediato de exceções descritivas (`IllegalArgumentException`) caso dados inválidos (como CPF incorreto ou valores negativos) sejam inseridos.
* **Uso de Varargs e Laços (`for-each`):** Processamento flexível e escalável para cálculo de comissões baseadas em volume variável de vendas.

---

## 📂 Estrutura do Domínio

```text
src/
└── AULA/
    └── DEVDOJO/
        └── POO/
            └── GestaoEmpresarial.java
