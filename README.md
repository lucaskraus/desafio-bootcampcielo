# desafio-bootcampcielo
Projeto desenvolvido para o bootcamp promovido pela Cielo em parceria com a Ada Tech.

<img width="400" height="250" alt="script client" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/42014375-62ac-4d73-8493-2f99dc1b29fb">

> [!WARNING]
> Para execução do repositório, serão necessárias as seguintes instalações:

- Node.JS
- Java (Foi utilizada a versão JDK 17 para o desenvolvimento do desafio)
- Apache Maven

# Configuração de Ambiente

Para testar a aplicação, será necessário executar dois scripts.

*build.bat* - Configura as dependências da aplicação Maven. <br/>
<img width="170" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/4cd75bd3-73d0-4163-a78d-37eb9d68ec53">

*server.bat* - Executa o servidor Java para receber e enviar as solicitações. <br/>
<img width="228" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/4f610a01-6dc0-4041-b07e-7df3f8a17e5d">

*client.bat* - Inicia a aplicação React. <br/>
<img width="179" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/983b2991-b918-42be-8d40-e437d0f2e547">

Após atualizar os diretórios, execute os scripts.

> [!NOTE]
> Por padrão, o script *server.bat* irá gerar 10 feedbacks fictícios para cada tópico SNS para que seja possível verificar o processamento da fila na aplicação. O servidor irá processar os feedbacks fictícios sequencialmente. Você pode interagir com o front-end enquanto isso acontece.

<img width="938" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/7885cd65-a9ce-403f-9da0-245651bf4193">

# Rotas

Nosso front-end possuí rotas para interações com o servidor. Aproveite a imersão como um cliente ou colaborador da Cielo!

[localhost:3000/](https://localhost:3000) - Consulte os feedbacks das filas.<br/>
[localhost:3000/feedback](https://localhost:3000/feedback) - Escolha um tipo de feedback e deixe sua mensagem para ser enviada à fila SQS.
