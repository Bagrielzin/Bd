package br.inatel.Model;

public class Habtante_Has_Armadura {

    private String habitante_nome;
    private String armadura_nome;

    public Habtante_Has_Armadura(String habitante_nome, String armadura_nome) {
        this.habitante_nome = habitante_nome;
        this.armadura_nome = armadura_nome;
    }

    public String getHabitante_nome() {
        return habitante_nome;
    }

    public void setHabitante_nome(String habitante_nome) {
        this.habitante_nome = habitante_nome;
    }

    public String getArmadura_nome() {
        return armadura_nome;
    }

    public void setArmadura_nome(String armadura_nome) {
        this.armadura_nome = armadura_nome;
    }
}
