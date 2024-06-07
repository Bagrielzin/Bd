package br.inatel.Model;

public class Localizacao {

    private String cidade;
    private String reino;

    public Localizacao(String cidade, String reino) {
        this.cidade = cidade;
        this.reino = reino;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }
}
