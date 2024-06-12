package br.inatel.Model;

public class Item_Magico {

    private int ID;
    private String nome;
    private String tipo;
    private int durabilidade;
    private String  material;
    private String natureza;

    public Item_Magico(int ID, String nome, String tipo, int durabilidade, String material, String natureza) {
        this.ID = ID;
        this.nome = nome;
        this.tipo = tipo;
        this.durabilidade = durabilidade;
        this.material = material;
        this.natureza = natureza;
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

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
