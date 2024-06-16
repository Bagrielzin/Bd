package br.inatel.Model;

public class Localizacao {

    private int ID;
    private String cidade;
    private String reino;

    public Localizacao(int ID, String cidade, String reino) {
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
