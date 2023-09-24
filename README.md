# desafio-bootcampcielo
Projeto desenvolvido para o bootcamp promovido pela Cielo em parceria com a Ada Tech.

<img width="600" height="250" alt="script client" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/ce8b80ca-0ef1-44ee-b9d4-4992ae1d8047">

> [!WARNING]
> Para execução do repositório, serão necessárias as seguintes instalações:

Node.JS 
Java (Foi utilizada a versão JDK 17 para o desenvolvimento do desafio)

##Environment Setup

Para testar a aplicação, será necessário executar dois scripts. Porém, antes da execução, atualize o caminho dos scripts com o diretório onde seu repositório está clonado.

*client.bat*
<img width="362" alt="script client" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/d0ddfa3a-22f7-4735-8d21-585104a2258a">

*server.bat*
<img width="305" alt="script server" src="https://github.com/lucaskraus/desafio-bootcampcielo/assets/72233741/e17f076a-1c53-4601-9617-41a026f8a493">

> [!NOTE]
> Por padrão, o script server.bat irá gerar 10 mensagens fictícias para cada tópico SNS para que seja possível verificar o processamento da fila na aplicação.

##Rotas

Nosso front-end possuí rotas para interações com o servidor. Aproveite a imersão como um cliente ou colaborador da Cielo!

[localhost:3000/feedback](localhost:3000/feedback) - Escolha um tipo de feedback e deixe sua mensagem para ser enviada à fila SQS.
