import br.inatel.DAO.HabitanteDAO;
import br.inatel.Model.Habitante;

public class Main {
    public static void main(String[] args) {
        HabitanteDAO habitanteDAO = new HabitanteDAO();

        Habitante h1 = new Habitante("Jorge","Orc",80,1.9F,"Vara negra","Rio");
        Habitante h2 = new Habitante("Carlos","Anão",29,1.3F,"anel","Ny");

        habitanteDAO.insertHabitante(h1);
        habitanteDAO.insertHabitante(h2);

        habitanteDAO.selectHabitante();

        habitanteDAO.updateHabitanteLocalizacao("cemitério","Jorge");

        habitanteDAO.insertHabitante(h2);
        habitanteDAO.selectHabitante();
    }
}
