# desafio-bootcampcielo
Projeto desenvolvido para o bootcamp promovido pela Cielo em parceria com a Ada Tech.

<img width="400" height="250" alt="script client" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/42014375-62ac-4d73-8493-2f99dc1b29fb">

> [!WARNING]
> Para execução do repositório, serão necessárias as seguintes instalações:

Node.JS 
Java (Foi utilizada a versão JDK 17 para o desenvolvimento do desafio)

# Configuração de Ambiente

Para testar a aplicação, será necessário executar dois scripts. Porém, antes da execução, atualize o caminho dos scripts com o diretório onde seu repositório está clonado.

*client.bat*<br/>
<img width="366" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/1f87be0e-d29d-49c8-bdcb-1eea32023eb1">

*server.bat*<br/>
<img width="307" alt="image" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/e41fbeb5-2abf-4870-a45e-709b7dffebf6">


> [!NOTE]
> Por padrão, o script server.bat irá gerar 10 mensagens fictícias para cada tópico SNS para que seja possível verificar o processamento da fila na aplicação.

# Rotas

Nosso front-end possuí rotas para interações com o servidor. Aproveite a imersão como um cliente ou colaborador da Cielo!

[localhost:3000/feedback](https://localhost:3000/feedback) - Escolha um tipo de feedback e deixe sua mensagem para ser enviada à fila SQS.
