# Conversor de Moedas

## Descrição

Este é um projeto simples de um conversor de moedas em Java que utiliza a API da [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio em tempo real. O programa oferece um menu interativo no console para que o usuário possa escolher as moedas de origem e destino, além de informar o valor a ser convertido.

## Funcionalidades

* Conversão entre diferentes pares de moedas:

   * BRL (Real Brasileiro) para USD (Dólar Americano)
   * USD (Dólar Americano) para BRL (Real Brasileiro)
   * EUR (Euro) para USD (Dólar Americano)
   * USD (Dólar Americano) para EUR (Euro)
   * GBP (Libra Esterlina) para JPY (Iene Japonês)
   * JPY (Iene Japonês) para GBP (Libra Esterlina)
* Interface de linha de comando interativa para seleção de opções e entrada de valores.
* Utilização da biblioteca Gson para processar a resposta JSON da API.
* Tratamento de erros para entradas inválidas e falhas na comunicação com a API.

## Tecnologias Utilizadas

* Java
* [Gson](https://github.com/google/gson) - Para manipulação de JSON.
* [ExchangeRate-API](https://www.exchangerate-api.com/) - Para obter as taxas de câmbio.

## Pré-requisitos

* Java Development Kit (JDK) instalado (versão 8 ou superior recomendada).
* A biblioteca Gson. O projeto está configurado para usar `gson-2.13.1.jar`. Você pode baixá-la [aqui](https://search.maven.org/artifact/com.google.code.gson/gson/2.13.1/jar) ou se certificar de que o arquivo `gson-2.13.1.jar` esteja acessível ao seu projeto, conforme especificado no arquivo `.idea/libraries/gson_2_13_1.xml`.
* Uma chave de API válida da [ExchangeRate-API](https://www.exchangerate-api.com/).

## Configuração

1. **Clone o repositório (ou baixe os arquivos):**

   ```bash
   git clone https://github.com/gustavolimaf/conversor-de-moedas.git
   cd conversor-de-moedas
   ```

2. **Obtenha uma chave da API:**

* Acesse [ExchangeRate-API](https://www.exchangerate-api.com/) e registre-se para obter uma chave de API gratuita.
* Abra o arquivo `src/Main/ApiService.java`.
* Substitua o valor da constante `API_KEY` pela sua chave pessoal:

  ```java
  private static final String API_KEY = "SUA-CHAVE-API-AQUI"; // Modifique esta linha
  ```

3. **Configure a biblioteca Gson:**

* Certifique-se de que o arquivo `gson-2.13.1.jar` esteja no local correto (por exemplo, na pasta `Downloads` do seu usuário, como indicado no arquivo XML, ou adicione-o ao classpath do seu projeto na sua IDE). Se você estiver usando uma IDE como IntelliJ IDEA ou Eclipse, geralmente pode adicionar o JAR como uma dependência externa nas configurações do projeto.

## Como Executar

1. **Compile os arquivos Java:**
   Se você estiver compilando manualmente via terminal, navegue até a pasta `src` e execute:

   ```bash
   javac Main/App.java Main/ApiService.java Main/Conversor.java Main/ExchangeRateResponse.java Main/Menu.java -cp "caminho/para/gson-2.13.1.jar"
   ```

   (Substitua `"caminho/para/gson-2.13.1.jar"` pelo caminho real do arquivo Gson no seu sistema).

   Se estiver usando uma IDE, ela geralmente compilará o projeto automaticamente ou com um clique.

2. **Execute a aplicação:**
   Ainda na pasta `src` (ou na pasta de saída da compilação, dependendo da sua IDE):

   ```bash
   java -cp ".:caminho/para/gson-2.13.1.jar" Main.App
   ```

   (No Windows, pode ser necessário usar `;` em vez de `:` para separar os caminhos no classpath: `java -cp ".;caminho/para/gson-2.13.1.jar" Main.App`).

   A aplicação será iniciada e exibirá o menu no console. Siga as instruções para realizar as conversões.

   **Observação:** É necessária uma conexão com a internet para que o programa obtenha as taxas de câmbio.

## Estrutura do Projeto

```
conversor-de-moedas/
├── .idea/
│   └── libraries/
│       └── gson_2_13_1.xml       # Configuração da biblioteca Gson para IDEs JetBrains
├── src/
│   └── Main/
│       ├── ApiService.java       # Responsável por fazer chamadas à API ExchangeRate
│       ├── App.java              # Classe principal que inicia a aplicação
│       ├── Conversor.java        # Contém a lógica para realizar as conversões
│       ├── ExchangeRateResponse.java # Classe modelo para desserializar a resposta JSON da API
│       └── Menu.java             # Gerencia a interface de usuário no console
└── README.md                     # Este arquivo
```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir *issues* ou enviar *pull requests*.
