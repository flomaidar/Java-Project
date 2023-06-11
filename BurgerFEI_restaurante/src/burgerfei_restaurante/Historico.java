/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerfei_restaurante;

import java.util.ArrayList;

/**
 *
 * @author flomaidar
 */
public class Historico {
    private double valor_total = 0;
    int vetor[] = new int[7];
    
    public Historico(int[] vetor) {
        this.vetor = vetor;
        valor_total = vetor[0]*10 + vetor[1]*10 + vetor[2]*7.5 + vetor[3]*8 + vetor[4]*5.5 + vetor[5]*4.5 + vetor[6]*4.25;
    }


    public double getValor_total() {
        return valor_total;
    }
    

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    @Override
    public String toString() {
        return "Pedidos{valor_total=" + valor_total + ", vetor=" + vetor + '}';
    }

    


        
}
