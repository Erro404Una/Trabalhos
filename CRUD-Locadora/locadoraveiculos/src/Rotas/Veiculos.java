package locadora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Veiculos {
  public void buscarVeiculos(){
    try {
      Connection connection = DbConfig.getConnection(); // Tentativa de conexão
      Statement statement = connection.createStatement(); // Criando um Statement (Status(200/401) / Resultado (O que trouxe de pesquisa))
      ResultSet resultSet = statement.executeQuery("SELECT * FROM locadoradeveiculos.veiculos"); // SELECIONE *(tudo) DA locadoradeveiculos.TABELA

      //Primeiro nome como você deseja que apareça o Segundo deve ser identico ao que você quer que puxe do banco
      while (resultSet.next()) {
        System.out.println("ID " + resultSet.getInt("id"));
        System.out.println("Marca " + resultSet.getString("marca"));
        System.out.println("Modelo " + resultSet.getString("modelo"));
        System.out.println("Ano " + resultSet.getInt("ano"));
        System.out.println("Placa " + resultSet.getString("placa"));
        System.out.println("Status " + resultSet.getString("disponivel"));
        System.out.println("Categoria " + resultSet.getString("categoria"));
        System.out.println("Imagem " + resultSet.getString("url_veiculo"));
        System.out.println("Preço " + resultSet.getDouble("preco"));
      }
            // Fechando a conexão
            connection.close();
          } catch (Exception e) {
            e.printStackTrace();
      }
    }
}