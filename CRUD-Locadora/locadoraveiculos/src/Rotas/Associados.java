package locadora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Associados {
  public void buscarAssociados(){
    try {
      Connection connection = DbConfig.getConnection(); // Tentativa de conexão
      Statement statement = connection.createStatement(); // Criando um Statement (Status(200/401) / Resultado (O que trouxe de pesquisa))
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.associado"); // SELECIONE *(tudo) DA locadoradeveiculos.TABELA
      
      //Primeiro nome como você deseja que apareça o Segundo deve ser identico ao que você quer que puxe do banco
      while (resultSet.next()) {
        System.out.println("ID " + resultSet.getInt("id"));
        System.out.println("Nome " + resultSet.getString("nome"));
        System.out.println("Telefone " + resultSet.getString("telefone"));
        System.out.println("E-mail " + resultSet.getString("email"));
        System.out.println("CPF " + resultSet.getString("cpf"));
      }
            // Fechando a conexão
            connection.close();
          } catch (Exception e) {
            e.printStackTrace();
      }
    }

    public void criarAssociado(){
      
    }
}
