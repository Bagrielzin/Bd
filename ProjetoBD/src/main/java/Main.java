import br.inatel.DAO.HabitanteDAO;
import br.inatel.Model.Habitante;

public class Main {
    public static void main(String[] args) {
        HabitanteDAO habitanteDAO = new HabitanteDAO();

        Habitante h1 = new Habitante("Jorge","Orc",80,1.9);
        Habitante h2 = new Habitante("Carlos","Anão",29,1.3);

        //Inserindo novos habitantes
        habitanteDAO.insertHabitante(h1);
        habitanteDAO.insertHabitante(h2);

        //Mostrando os habitantes
        habitanteDAO.selectHabitante();

        //Atualizando a altura pelo nome
        habitanteDAO.updateHabitanteLocalizacao(2.2,"Jorge");

        //Deletando um habitante
        habitanteDAO.deleteHabitante("Carlos");

        //Mostrando novamente os habitantes
        habitanteDAO.selectHabitante();
    }
}
