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


public class DAO_historico {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;  

    public void inserir(String cpf, double valor_total, int[] vetor){
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("INSERT INTO HISTORICO (CPF, VALOR_TOTAL, SALADA, BURGER, CACHORRO, MISTO, FRUTAS, REFRI, SUCO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
    
    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstmt = conn.prepareStatement("SELECT * FROM HISTORICO ORDER BY CPF");
            // Executando o comando sql e armazenando no ResultSet
            rs = pstmt.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    
}
