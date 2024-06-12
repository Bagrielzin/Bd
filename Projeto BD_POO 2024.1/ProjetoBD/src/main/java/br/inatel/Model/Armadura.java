package br.inatel.Model;

public class Armadura {

    private String nome;
    private String tipo;
    private int durabilidade;
    private float peso;
    private String material;
    private String propriedade;

    public Armadura(String nome, String tipo, int durabilidade, float peso, String material, String propriedade) {
        this.nome = nome;
        this.tipo = tipo;
        this.durabilidade = durabilidade;
        this.peso = peso;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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
