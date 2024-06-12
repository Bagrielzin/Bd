package br.inatel.Model;

public class Habtante_Has_Arma {

    private String habitante_nome;
    private String arma_nome;

    public Habtante_Has_Arma(String habitante_nome, String arma_nome) {
        this.habitante_nome = habitante_nome;
        this.arma_nome = arma_nome;
    }

    public String getHabitante_nome() {
        return habitante_nome;
    }

    public void setHabitante_nome(String habitante_nome) {
        this.habitante_nome = habitante_nome;
    }

    public String getArma_nome() {
        return arma_nome;
    }

    public void setArma_nome(String arma_nome) {
        this.arma_nome = arma_nome;
    }
}
