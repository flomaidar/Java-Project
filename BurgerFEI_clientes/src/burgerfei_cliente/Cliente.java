/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerfei_cliente;

/**
 *
 * @author flomaidar
 */
public class Cliente extends Pessoa {
    private String senha;
    

    public Cliente(String nome, String CPF, String senha) {
        super(nome, CPF);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() + "senha=" + senha + '}';
    }
}
