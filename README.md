# persistencia-ufc-2022-2
Atividades e trabalhos desenvolvidos na disciplina Desenvolvimento de Software para Persistência no semestre 2022.2.

A disciplina consistiu em quatro partes.
Esse repositório tem código Java escrito nas duas primeiras partes: manipulação de arquivos e integração com banco de dados.
As outras duas partes consistiram em cursos e no estudo de bancos dados NoSQL como o MongoDB, o Redis e o Slasticsearch.
Não houver trabalhos práticos sobre esses últimos assuntos.

## Parte I: manipulação de arquivos com Java
As atividades de 1 a 5 e o trabalho 1 consistiram em utilizar recursos do Java e de algumas das suas bibliotecas para manipular arquivos.
As tarefas desenvolvidas envolveram:
- leitura e escrita de arquivos (copiando e compactando arquivos binários, visualizando linhas específicas de arquivos de texto, etc)
- geração e verificação de *hashcodes* de arquivos utilizando funções de resumo
- utilização de arquivos de propriedades, com linhas do tipo chave-valor
- serialização e desserialização de objetos Java em arquivos JSON, XML e CSV

## Parte II: integração com banco de dados usando Java
As atividades 6, 7 e 8, e o trabalho 2, contém códigos que utilizam o banco de dados PostgreSQL para armazenamento dos dados das entidades.
Esses projetos utilizam desde o JDBC simples até a JPA com Hibernate e alguns módulos do *framework* Spring.
Cada um dos projetos contém operações CRUD para uma ou mais entidades e utilizam o padrão DAO.
O padrão Factory também é usado para criar conexões com o banco de dados e EntityManagers.

No trabalho 2 há relacionamentos entre as entidades, e eles são mantidos usando a JPA (Hibernate).
