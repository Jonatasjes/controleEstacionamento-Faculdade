# UNIVERSIDADE VEIGA DE ALMEIDA

## Trabalho para o desenvolvimento de Aplicação om interface gráfica e acesso a banco de dados para controle de carros de um estacionamento. 
### Disciplina: PROGRMAÇÃO ORIENTADA A OBJETOS II
### Professor: MARCIO AURELIO NOVAES ESTEVES
### Tecnologia: JAVA

## Desenvolvimento de projeto de aplicação em Java com uso da API JDBC para a manipulação de dados de uma tabela.

  Uma empresa precisa controlar o estacionamento de seus funcionários. Sabe-se que o estacionamento só permite a entrada de automóveis. Crie um banco de dados Access para armazenamento dos carros do estacionamento de acordo com os atributos da classe Carro. Crie a classe Carro e a classe CarroDAO para a manipulação da tabela, e uma classe para realizar a conexão com o banco de dados. Crie uma aplicação com interfaces gráficas para o controle do estacionamento e para as operações de manutenção da tabela, com inclusão, alteração e exclusão, além da geração de um relatório de carros cadastrados.
  
## Introtução

  A aplicação foi desenvolvida e separada em quatro pacotes distintos a fim de manter o código escalável e de fácil compreensão. Os pacotes são os connection onde foi criada a classe ConnectionFactory de conexão com o banco de dados, model onde foi criada a classe Carro para definir construção do modelo de carro, model.dao foi criada a classe CarroDAO para a manipulação da tabela com o banco de dados e por fim o pacote view onde foi criado o JFrame da aplicação com a classe de nome viewCarros. Foi criado o banco de dados bdcarros para que os dados fossem armazenados.
