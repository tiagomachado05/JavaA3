package DAO;

import Model.Produto;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    public static ArrayList<Produto> ListaProdutos = new ArrayList<Produto>();
    
    public ArrayList getListaProdutos; //DAR UMA OLHADA COM LEO

    public ProdutoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produtos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;

        try {

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_produtos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "rootroot";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getListaProdutos() {
        
        ListaProdutos.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");
            while (res.next()) {
               
                String nome_produto = res.getString("nome_produto");
                String descrição_produto = res.getString("descrição_produto");
                int id = res.getInt("id");
                int quantidade_estoque = res.getInt("quantidade_estoque");
                double preço = res.getDouble("preço");
                Date data_cadastro = res.getDate("data_cadastro");
                System.out.print(nome_produto);

                Produto produto = new Produto(id, nome_produto, descrição_produto, quantidade_estoque, preço, data_cadastro);
                
                ListaProdutos.add(produto);
                        
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ListaProdutos;
    }

    // Cadastra novo aluno
    public boolean InsertProdutoBD(Produto objeto) {
        String sql = "INSERT INTO tb_produtos(id,nome_produto,descrição_produto,quantidade_estoque,preço,data_cadastro) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome_produto());
            stmt.setString(3, objeto.getDescrição_produto());
            stmt.setInt(4, objeto.getQuantidade_estoque());
            stmt.setDouble(5, objeto.getPreço());
            stmt.setDate(6, new java.sql.Date(objeto.getData_cadastro().getTime()));

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteProdutoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateProdutoBD(Produto objeto) {
        System.out.println(objeto.toString());

        String sql = "UPDATE tb_produtos set nome_produto = ? ,descrição_produto = ? , quantidade_estoque = ? ,preço = ? ,data_cadastro = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome_produto());
            stmt.setString(2, objeto.getDescrição_produto());
            stmt.setInt(3, objeto.getQuantidade_estoque());
            stmt.setDouble(4, objeto.getPreço());
            stmt.setDate(5, new java.sql.Date(objeto.getData_cadastro().getTime()));
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }

    }

    public Produto carregaProduto(int id) {
        
        Produto objeto = new Produto();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id = " + id);
            res.next();

            objeto.setNome_produto(res.getString("nome_produto"));
            objeto.setDescrição_produto(res.getString("descrição_produto"));
            objeto.setQuantidade_estoque(res.getInt("quantidade_estoque"));
            objeto.setPreço(res.getDouble("preço"));
            objeto.setData_cadastro(res.getDate("data_cadastro"));

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }


}