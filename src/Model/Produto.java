package Model;

import DAO.ProdutoDAO;
import java.util.*;
import java.sql.SQLException;

public class Produto {

    //atributos
    private int id;
    private String nome_produto;
    private String descrição_produto;
    private int quantidade_estoque;
    private double preço;
    private Date data_cadastro;
    private final ProdutoDAO dao;

    //construtor vazio
    public Produto() {
        this.dao = new ProdutoDAO();
    }

    public Produto(int id, String nome_produto, String descrição_produto, int quantidade_estoque, double preço, Date data_cadastro) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.descrição_produto = descrição_produto;
        this.quantidade_estoque = quantidade_estoque;
        this.preço = preço;
        this.data_cadastro = data_cadastro;
        this.dao = new ProdutoDAO();
    }

    //propício a erro, ver de remover
    public Produto(int id, String nome_produto, String descrição_produto, int quantidade_estoque, double preço, Date data_cadastro, ProdutoDAO dao) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.descrição_produto = descrição_produto;
        this.quantidade_estoque = quantidade_estoque;
        this.preço = preço;
        this.data_cadastro = data_cadastro;
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public String getDescrição_produto() {
        return descrição_produto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public double getPreço() {
        return preço;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public ProdutoDAO getDao() {
        return dao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setDescrição_produto(String descrição_produto) {
        this.descrição_produto = descrição_produto;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public ArrayList getListaProdutos() {
        return dao.getListaProdutos();
    }

    public boolean InsertProdutoBD(String nome_produto, String descrição_produto, int quantidade_estoque, double preço, Date data_cadastro) throws SQLException {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(id, nome_produto, descrição_produto, quantidade_estoque, preço, data_cadastro);
        dao.InsertProdutoBD(objeto);
        return true;
    }

    public boolean DeleteProdutoBD(int id) {
        dao.DeleteProdutoBD(id);
        return true;
    }

    public boolean UpdateProdutoBD(int id, String nome_produto, String descrição_produto, int quantidade_estoque, double preço, Date data_cadastro) {
        Produto objeto = new Produto(id, nome_produto, descrição_produto, quantidade_estoque, preço, data_cadastro);
        dao.UpdateProdutoBD(objeto);
        return true;
    }

    public Produto carregaProduto(int id) {
        dao.carregaProduto(id);
        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome_produto=" + nome_produto + ", descri\u00e7\u00e3o_produto=" + descrição_produto + ", quantidade_estoque=" + quantidade_estoque + ", pre\u00e7o=" + preço + ", data_cadastro=" + data_cadastro + ", dao=" + dao + '}';
    }
    
    

}
