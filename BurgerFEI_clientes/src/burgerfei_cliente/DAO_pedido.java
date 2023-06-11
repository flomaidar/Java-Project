/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerfei_cliente;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAO_pedido {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;  

    public void inserir(String cpf, double valor_total, int[] vetor){
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("INSERT INTO PEDIDO (CPF, VALOR_TOTAL, SALADA, BURGER, CACHORRO, MISTO, FRUTAS, REFRI, SUCO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // Setando o valor aos parâmetros
            pstmt.setString(1, cpf);
            pstmt.setDouble(2, valor_total);
            pstmt.setInt(3, vetor[0]);
            pstmt.setInt(4, vetor[1]);
            pstmt.setInt(5, vetor[2]);
            pstmt.setInt(6, vetor[3]);
            pstmt.setInt(7, vetor[4]);
            pstmt.setInt(8, vetor[5]);
            pstmt.setInt(9, vetor[6]);

            // Executando o comando sql do objeto preparedStatement​
            pstmt.execute();
            System.out.println("Inserido com Sucesso");
            conexao.desconectar(); // Fechando a conexão com o banco​
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
            System.err.println("Falha em Inserir no DB" + e.getMessage());
        }
    }
    
    public void remover(String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            String remover = "DELETE FROM PEDIDO WHERE CPF = ?";
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

    public ResultSet buscarPorCPF(String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM PEDIDO WHERE CPF = ? ORDER BY CPF");
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
    
    public boolean checkPedido (String cpf) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM PEDIDO WHERE CPF = ?");
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
