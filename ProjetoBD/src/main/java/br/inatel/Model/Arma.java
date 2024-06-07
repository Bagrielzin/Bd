package br.inatel.Model;

public class Arma {

    private String nome;
    private String tipo;
    private int durabilidade;
    private String material;
    private String propriedade;

    public Arma(String nome, String tipo, int durabilidade, String material, String propriedade) {
        this.nome = nome;
        this.tipo = tipo;
        this.durabilidade = durabilidade;
        this.material = material;
        this.propriedade = propriedade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }
}
