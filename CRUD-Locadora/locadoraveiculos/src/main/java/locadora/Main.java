//CTRL + SHIFT + P - Java Create a Java Project
//Selecionar Maven
//Opcao no Archetype
//Grupo ID (id do projeto)
//Nome do Projeto
//Selecione aonde vai ser instalado e boa

//Criar uma pasta chamada lib (Significado: Livraria importada de fora / Library)
//Baixar o MySQL Connector no Product Version: 8.0.30 e Operating System: Platform Independent (Architecture Independent), ZIP Archive
//Colocar ele na pasta lib dentro do projeto criado pelo Mavem

//COMANDOS PARA COMPILAR:
//javac -cp lib/mysql-connector-java-8.0.30.jar -d bin .\locadoraveiculos\src\main\java\locadora\Main.java
//java -cp "lib/mysql-connector-java-8.0.30.jar" Main


package locadora;
import java.sql.Connection; //Possui a função de conectar ao banco de dados e tras o resultado dentro do import java.sql.Statement.
import java.sql.DriverManager; //Tem como função gerenciar o conjunto de codigos e drivers do Banco, URL USER E TUDO +, tendo como a principal caracteristica puxar a conexão(getConnection) //get = pegar/buscar.
import java.sql.ResultSet; // Traz consigo os resultados de pesquisa do Banco de dados, como SELECT, INSERT, DELETE, USE, UPDATE, ETC...
import java.sql.Statement; /* Statement retorna os status e resultados (Status 200(Consegui acessar), 401, 303) - Status de conexão bem sucedida erro.
E o Respose(JSON) retorna os valores de busca como:
{
   "id": 1
   "nome": "Gabriel"
   "telefone": "+5531 9 9999-9999"
   "email": "teste@gmail.com"
   "cpf": "111.111.111-11"
            }

*/

public class Main {
  public static void main(String[] args) {
    //URL do Banco, O QUE É NECESSARIO PARA CONECTAR COM O MYSQL? COM O NOSSO BANCO?:
    String url = "A"; //"URL DO BANCO"
    String user = "B"; //"Login para o banco (Usuario)"
    String password = "C"; //"Login para o banco (Senha)"

    try{
      //Tentativa de conexão
      Connection connection = DriverManager.getConnection(url,user, password);

      //Criando um Statement (Status(200/401) / Resultado (O que trouxe de pesquisa))
      Statement statement = connection.createStatement();


      //Executando uma tarefa no Banco (SELECT, INSERT, DELETE, USE, UPDATE, ETC...)
      //executeQuery (Execução de comandos no Banco De Dados)
      ResultSet resultSet = statement.executeQuery("SELECT categoria FROM locadoradeveiculos.associado");  //SELECIONE *(tudo) DA locadoradeveiculos.TABELA

      while(resultSet.next()){
        System.out.println("ID " + resultSet.getInt("id"));
        System.out.println("Nome " + resultSet.getString("nome"));
        System.out.println("Telefone " + resultSet.getString("telefone"));
        System.out.println("E-mail " + resultSet.getString("email"));
        System.out.println("CPF " + resultSet.getString("cpf"));
      }

      //Fechando a conexão
      connection.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
