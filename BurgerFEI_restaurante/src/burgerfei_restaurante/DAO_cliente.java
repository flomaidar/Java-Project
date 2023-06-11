/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerfei_restaurante;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAO_cliente {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;  

    
    public void remover(String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            String remover = "DELETE FROM CLIENTES WHERE CPF = ?";
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement(remover);
            // Setando o valor ao parâmetro​
            pstmt.setString(1, cpf);
            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Removido com Sucesso");
            conexao.desconectar(); // Fechando a conexão com o banco​
        } catch (SQLException e) {
            conexao.desconectar(); // Fechando a conexão com o banco​
        }
    }
    
    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM CLIENTES ORDER BY CPF");
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    
    public ResultSet buscarPorCPF(String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM CLIENTES WHERE CPF = ? ORDER BY NOME");
            pstmt.setString(1, cpf);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    
    public boolean checkCPF(String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM CLIENTES WHERE CPF = ?");
            pstmt.setString(1, cpf);
            
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException e) {
            conexao.desconectar();
            return false;
        }
        return false;
    }
    
}
