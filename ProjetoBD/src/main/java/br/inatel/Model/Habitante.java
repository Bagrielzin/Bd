package br.inatel.Model;

public class Habitante {

    private String nome;
    private String raca;
    private int idade;
    private double altura;
    private String item_magico_nome;
    private String localizacao_cidade;

    public Habitante(String nome, String raca, int idade, double altura) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.altura = altura;
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

    public String getItem_magico_nome() {
        return item_magico_nome;
    }

    public String getLocalizacao_cidade() {
        return localizacao_cidade;
    }
}
