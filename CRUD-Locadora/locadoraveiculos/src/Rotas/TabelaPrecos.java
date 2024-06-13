package locadora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TabelaPrecos {
  public void buscarPrecos(){
    try {
      Connection connection = DbConfig.getConnection(); // Tentativa de conexão
      Statement statement = connection.createStatement(); // Criando um Statement (Status(200/401) / Resultado (O que trouxe de pesquisa))
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.tabelaprecos"); // SELECIONE *(tudo) DA locadoradeveiculos.TABELA

      //Primeiro nome como você deseja que apareça o Segundo deve ser identico ao que você quer que puxe do banco
      while (resultSet.next()) {
        System.out.println("ID " + resultSet.getInt("id"));
        System.out.println("Categoria " + resultSet.getString("categoria"));
        System.out.println("Preço Dia " + resultSet.getDouble("preco_por_dia"));
      }
            // Fechando a conexão
            connection.close();
          } catch (Exception e) {
            e.printStackTrace(); 
      }
    }
  }