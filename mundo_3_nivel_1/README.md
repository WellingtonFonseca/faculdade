# Material de orientações para desenvolvimento da missão prática do 1º nível de conhecimento.

## RPG0014  - Iniciando o caminho pelo Java

Implementação de um cadastro de clientes em modo texto, com persistência em
arquivos, baseado na tecnologia Java.

## Objetivos da prática

1. Utilizar herança e polimorfismo na  definição de entidades.
1. Utilizar persistência de objetos em arquivos binários.
1. Implementar uma interface cadastral em modo texto.
1. Utilizar o controle de exceções da plataforma Java.
1. No final do projeto, o aluno terá implementado um sistema cadastral em Java, utilizando os recursos da programação orientada a objetos e a persistência em arquivos binários

## Relatório discente de acompanhamento
1. Quais as vantagens e desvantagens do uso de herança?
    - vantagem: reutilização de código
    - vantagem: traz uma melhor organização do código, pois será feito mais uso e menos linhas
    - desvantagem: se usar de modo excessivo por trazer confusão e dificuldade na manutenção
    - desvantagem: pesquisando sobre encontrei que não existe a possibilidade de incrementar múltiplas heranças

1. Por que a interface Serializable é necessária ao efetuar persistência em arquivos
binários?
    - creio que ele funcione como banco de dados, é através dele que possuímos as "conexões" e "conversões" necessárias para salvar os dados

1. Como o paradigma funcional é utilizado pela API stream no Java?
    - O paradigma funcional utiliza meios de operações de alto nível que podem manipular coleções de elementos, essas operações permitem escrever código de forma mais eficiente.

1. Quando trabalhamos com Java, qual padrão de desenvolvimento é adotado na persistência de dados em arquivos?
    - Um dos padrões comumentes usado é o DAO (Data Access Object). O padrão DAO separa a lógica de acesso aos dados da lógica de negócios do aplicativo, permitindo uma melhor manutenção do código. De modo geral envolve criação de classes que envolvem operações de CRUD (Create, Read, Update, Delete)