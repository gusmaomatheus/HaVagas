# 📄 HaVagas - Cadastro de Talentos

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-7F52FF?style=for-the-badge&logo=kotlin)
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android)
![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)

Projeto educacional desenvolvido como parte de uma disciplina de Programação para Dispositivos Móveis. O objetivo é criar uma tela de cadastro para uma plataforma de empregos fictícia, aplicando conceitos de layouts dinâmicos, manipulação de UI, estilização de componentes nativos e captura de dados do usuário.

## 📸 Screenshot

- Formulário
<img width="402" height="848" alt="image" src="https://github.com/user-attachments/assets/73ee72f3-72a9-4db9-ac40-cf14c53b5d73" />

- Pop Up Pós Salvar:
<img width="402" height="880" alt="image" src="https://github.com/user-attachments/assets/206ae205-a7fc-4d73-bab5-12838463b1b2" />

## 🎯 Requisitos do Projeto

Este projeto foi desenvolvido para atender aos seguintes requisitos:

1.  **Tela Única**: O aplicativo deve conter uma única tela com um formulário de cadastro.
2.  **Campos de Cadastro**: O formulário deve incluir:
    -   Nome Completo, E-mail e Telefone (comercial/residencial).
    -   Um campo opcional para Telefone Celular.
    -   Sexo e Data de Nascimento.
    -   Nível de Formação (fundamental, médio, graduação, etc.).
    -   Vagas de Interesse.
3.  **Campos Dinâmicos**: Conforme o nível de formação selecionado, campos adicionais devem ser exibidos (ex: Ano de Conclusão, Instituição, Título de Monografia).
4.  **Ações do Formulário**: Botões para "Salvar" e "Limpar" o formulário.
5.  **Feedback ao Salvar**: Ao clicar em "Salvar", os dados preenchidos devem ser exibidos em uma mensagem pop-up.
6.  **Entrega**: O projeto final deve ser entregue em um repositório no GitHub.

## ✨ Funcionalidades Implementadas

-   **Formulário de Cadastro Completo**: Implementação de todos os campos solicitados utilizando componentes nativos do Android.
-   **Layouts Dinâmicos**: A interface se adapta em tempo real à seleção do nível de formação do usuário, exibindo apenas os campos relevantes.
-   **Máscaras de Entrada**: Campos de Data de Nascimento e Telefones possuem máscaras `(##/##/####)` e `(##) #####-####` para guiar o preenchimento e padronizar os dados.
-   **Estilização Padronizada**: Criação de um sistema de estilos em `themes.xml` para garantir uma aparência coesa e profissional em todos os componentes (campos de texto, botões, títulos).
-   **Feedback de Interação**: Os componentes visuais respondem às ações do usuário (ex: a borda de um campo de texto muda de cor quando focado; botões mudam de cor ao serem pressionados).
-   **Resumo para o Usuário**: Uma caixa de diálogo (`AlertDialog`) exibe um resumo completo de todos os dados inseridos antes do "salvamento".

## 🛠️ Tecnologias Utilizadas

-   **Linguagem**: [Kotlin](https://kotlinlang.org/)
-   **IDE**: [Android Studio](https://developer.android.com/studio)
-   **Arquitetura e Componentes**:
    -   **ViewBinding**: Para acessar as views do layout de forma segura e concisa.
    -   **Layouts em XML**: Construção da interface declarativa com `ScrollView` e `LinearLayout`.
    -   **`TextWatcher`**: Para implementação das máscaras de formatação de texto.
    -   **AppCompat**: Para garantir compatibilidade com versões mais antigas do Android.
-   **UI (Interface do Usuário)**:
    -   **Estilos e Temas (`themes.xml`)**: Para padronizar a aparência de `EditText`, `Button`, `TextView`, etc.
    -   **Drawables com Seletores (`Selectors`)**: Para criar aparências diferentes para os componentes com base em seu estado (focado, pressionado, etc.).

## 🚀 Como Executar o Projeto

Para executar este projeto localmente, siga os passos abaixo:

1.  **Pré-requisitos**:
    -   [Git](https://git-scm.com/) instalado.
    -   [Android Studio](https://developer.android.com/studio) (versão Iguana ou mais recente).

2.  **Clone o repositório**:
    ```bash
    git clone [[https://github.com/seu-usuario/HaVagas.git](https://github.com/seu-usuario/HaVagas.git)]
    ```

3.  **Abra no Android Studio**:
    -   Inicie o Android Studio e selecione "Open".
    -   Navegue até a pasta `HaVagas` que você clonou e selecione-a.

4.  **Sincronize o Gradle**:
    -   O Android Studio irá sincronizar as dependências do Gradle automaticamente. Aguarde a conclusão.

5.  **Execute o App**:
    -   Selecione um emulador ou conecte um dispositivo físico e clique no botão "Run" (▶️).

## 📂 Estrutura do Projeto

Os principais arquivos e diretórios que compõem a aplicação são:

```
└── app/
└── src/
└── main/
├── java/br/com/havagas/
│   ├── MainActivity.kt        # Contém a lógica do formulário
│   └── MaskWatcher.kt         # Classe que implementa as máscaras
│
└── res/
├── drawable/              # XMLs para os backgrounds de botões e EditText
├── layout/
│   └── activity_main.xml  # Layout principal do formulário
│
└── values/
├── colors.xml         # Cores utilizadas no app
├── strings.xml        # Textos e mensagens
└── themes.xml         # Tema global e estilos dos componentes
```

## 👨‍💻 Autor

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gusmaom/)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/gusmaomatheus/)
