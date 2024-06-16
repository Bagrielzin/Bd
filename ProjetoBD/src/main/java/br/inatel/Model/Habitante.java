package br.inatel.Model;

public class Habitante {

    private String nome;
    private String raca;
    private int idade;
    private double altura;
    private int ID_Item;
    private int ID_Local;

    public Habitante(String nome, String raca, int idade, double altura, int ID_Item, int ID_Local) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.altura = altura;
        this.ID_Item = ID_Item;
        this.ID_Local = ID_Local;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public int getID_Item() {
        return ID_Item;
    }

    public int getID_Local() {
        return ID_Local;
    }
}
