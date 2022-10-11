package br.tiposgenericosrodolfo;

public class Cidade {
    private String nome;
    private String adjetivo;
    private String estado;


    public Cidade(String nome, String adjetivo, String estado) {
        super();
        this.nome = nome;
        this.adjetivo = adjetivo;
        this.estado = estado;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAdjetivo() {
        return adjetivo;
    }
    public void setAdjetivo(String adjetivo) {
        this.adjetivo = adjetivo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Cidade [nome=" + nome + ", adjetivo=" + adjetivo + ", estado=" + estado + "]";
    }


}