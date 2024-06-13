//CTRL + SHIFT + P - Java Create a Java Project
//Selecionar Maven
//Opcao no Archetype
//Grupo ID (id do projeto)
//Nome do Projeto
//Selecione aonde vai ser instalado e boa

//Criar uma pasta chamada lib (Significado: Livraria importada de fora / Library)
//Baixar o MySQL Connector no Product Version: 8.0.30 e Operating System: Platform Independent (Architecture Independent), ZIP Archive
//Colocar ele na pasta lib dentro do projeto criado pelo Mavem

//COMANDOS PARA COMPILAR O CODIGO:
//javac -cp .\lib\mysql-connector-java-8.0.30.jar -d bin .\src\BancoDeDados\DbConfig.java .\src\Main\Main.java .\src\Rotas\Associados.java .\src\Rotas\Veiculos.java .\src\Rotas\TabelaPrecos.java
//java -cp "bin;lib/mysql-connector-java-8.0.30.jar" locadora.Main

package locadora;

import java.sql.Connection; // Possui a função de conectar ao banco de dados e traz o resultado dentro do import java.sql.Statement.
import java.sql.ResultSet; // Traz consigo os resultados de pesquisa do Banco de dados, como SELECT, INSERT, DELETE, USE, UPDATE, ETC...
import java.sql.Statement;

public class Main {
  public static void main(String[] args) {
    Associados BuscaTabelaAssociado = new Associados();
    BuscaTabelaAssociado.buscarAssociados();

    TabelaPrecos BuscaTabelaPrecos = new TabelaPrecos();
    BuscaTabelaPrecos.buscarPrecos();

    Veiculos BuscaTabelaVeiculos = new Veiculos();
    BuscaTabelaVeiculos.buscarVeiculos();
  }
}
