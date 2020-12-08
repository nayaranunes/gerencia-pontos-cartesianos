## Sistema de gerenciamento de pontos em um plano cartesiano.
####Um ponto é formado por duas coordenadas denominadas X e Y.

Seu sistema deve ser capaz de:

- 1 - Gravar um ponto;
- 2 - Listar os pontos gravados até então;
- 3 - Verificar se determinado ponto existe na base. Nesse caso o serviço deve receber as coordenadas X e Y para verificar se o ponto existe ou não;
- 4 - Deve existir uma forma de dado um ponto P(Xp, Yp) encontrar todos os pontos Q, tais que a distância de P e Q seja menor que D (Xp, Yp e D são parâmetros que seu serviço deve receber).

----------

*Requisitos:*

- Seu sistema deve ser feito em Java 8+;
- Você deve criar o banco de dados de fato, mas pode escolher o que mais lhe agradar, e entregar os devidos scripts de criação do banco, tabelas e triggers/procedures se necessário;
- As coordenadas são números decimais;
- A cobertura de testes deve ser 100%;
- Se desligar e ligar seu sistema, os pontos cadastrados devem constar ainda na base.
- E seu sistema deve expor API's para cumprir os objetivos de 1 a 4.

- Opcional: Entregar o desenho do banco de dados e o fluxograma do sistema.
