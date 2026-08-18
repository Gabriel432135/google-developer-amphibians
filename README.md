# Amphibians App 🐸

O **Amphibians App** é um projeto desenvolvido como parte do desafio do Google Developer para o aprendizado de **Jetpack Compose**. O objetivo do aplicativo é exibir uma lista de anfíbios buscada diretamente de uma API REST, consolidando conceitos fundamentais de desenvolvimento Android moderno.

## 🚀 Funcionalidades

- **Consumo de API:** Busca dados em tempo real de um endpoint remoto.
- **Estados de UI:** Tratamento completo para os estados de **Carregamento (Loading)**, **Sucesso (Success)** e **Erro (Error)** com opção de re-tentativa.
- **Carregamento de Imagens:** Uso da biblioteca Coil para processar imagens da web de forma eficiente, com placeholders e tratamento de erros.
- **Arquitetura Robusta:** Separação clara de responsabilidades seguindo os princípios do Android.

## 🛠️ Tecnologias e Bibliotecas

- **[Kotlin](https://kotlinlang.org/):** Linguagem de programação oficial para Android.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Toolkit moderno para construção de UI declarativa.
- **[Retrofit](https://square.github.io/retrofit/):** Cliente HTTP para requisições de rede.
- **[Kotlinx Serialization](https://kotlinlang.org/docs/serialization.html):** Conversão de JSON para objetos Kotlin (Type-safe).
- **[Coil](https://coil-kt.github.io/coil/):** Carregamento de imagens assíncrono.
- **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** Gerenciamento de tarefas assíncronas e chamadas de rede sem bloquear a UI.

## 🏗️ Arquitetura

O projeto utiliza o padrão **MVVM (Model-View-ViewModel)** com a seguinte estrutura:

- **Data Layer:** 
    - **Repository Pattern:** Abstração da fonte de dados para o restante do app.
    - **AppContainer:** Implementação manual de **Injeção de Dependência** para gerenciar instâncias únicas (Singletons) do Retrofit e dos Repositórios.
- **UI Layer:**
    - **ViewModel:** Gerencia o estado da interface (`UiState`) e sobrevive a mudanças de configuração (como rotação de tela).
    - **Stateless Composables:** Componentes de UI que recebem apenas dados e callbacks, facilitando o teste e o uso de Previews.

## 📖 Como rodar o projeto

1. Clone este repositório.
2. Abra o projeto no **Android Studio (versão Ladybug ou superior)**.
3. Certifique-se de que o Gradle Sync foi concluído com sucesso.
4. Execute o app em um emulador ou dispositivo físico com acesso à internet.

---
*Este projeto foi desenvolvido para fins educacionais seguindo o currículo oficial do Google Android Basics with Compose.*
