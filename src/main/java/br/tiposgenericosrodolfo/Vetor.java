package br.tiposgenericosrodolfo;

public class Vetor <T> {
    private final Object[] vetor;
    private final int tamanho;

    public Vetor(int tamanho){
        vetor = new Object[tamanho];
        this.tamanho = tamanho;
    }

    // getters and setters
    public int getTamanho() {
        return tamanho;
    }


    public T getVetor(int j){
        return (T) vetor[j];
    }

    public void setVetor(T v, int j){
        vetor[j] = v;
    }


}