# desafio-bootcampcielo
Projeto desenvolvido para o bootcamp promovido pela Cielo em parceria com a Ada Tech.

<img width="400" height="250" alt="script client" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/42014375-62ac-4d73-8493-2f99dc1b29fb">

> [!WARNING]
> Para execução do repositório, serão necessárias as seguintes instalações:

- Node.JS
- Java (Foi utilizada a versão JDK 17 para o desenvolvimento do desafio)

# Configuração de Ambiente

Para testar a aplicação, será necessário executar dois scripts. Porém, antes da execução, atualize o caminho dos scripts com o diretório onde seu repositório está clonado.

*client.bat*<br/>
<img width="366" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/1f87be0e-d29d-49c8-bdcb-1eea32023eb1">

*server.bat*<br/>
<img width="306" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/a724bd68-58e9-4e5d-8d40-0630273b427e">

Após atualizar os diretórios, execute os scripts.

> [!NOTE]
> Por padrão, o script *server.bat* irá gerar 10 feedbacks fictícios para cada tópico SNS para que seja possível verificar o processamento da fila na aplicação.

**O servidor irá processar os feedbacks fictícios sequencialmente. Você pode interagir com o front-end enquanto isso acontece.**

<img width="938" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/7885cd65-a9ce-403f-9da0-245651bf4193">

# Rotas

Nosso front-end possuí rotas para interações com o servidor. Aproveite a imersão como um cliente ou colaborador da Cielo!

[localhost:3000/feedback](https://localhost:3000/feedback) - Escolha um tipo de feedback e deixe sua mensagem para ser enviada à fila SQS.
