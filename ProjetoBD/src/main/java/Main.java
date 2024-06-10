import br.inatel.DAO.HabitanteDAO;
import br.inatel.DAO.Item_MagicoDAO;
import br.inatel.DAO.LocalizacaoDAO;
import br.inatel.Model.Habitante;
import br.inatel.Model.Item_Magico;
import br.inatel.Model.Localizacao;

public class Main {
    public static void main(String[] args) {
        HabitanteDAO habitanteDAO = new HabitanteDAO();
        LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
        Item_MagicoDAO item_magicoDAO = new Item_MagicoDAO();

        Localizacao l1 = new Localizacao("Leyndell","Lands between");
        Localizacao l2 = new Localizacao("Anor londo","Lorian");
        Localizacao l3 = new Localizacao("Yharnam","Victorian");
        Item_Magico i1 = new Item_Magico("Cutelo","serrado",15,"ferro","humana");
        Item_Magico i2 = new Item_Magico("Cajado","cetro",25,"madeira","mágica");
        Item_Magico i3 = new Item_Magico("Arco negro","arco",30,"madeira","élfica");
        Habitante h1 = new Habitante("Jorge","Orc",80,1.9,"Cutelo","Yharnam");
        Habitante h2 = new Habitante("Carlos","Anão",29,1.3,"Cajado","Leyndell");

        //Inserindo localizações
        //localizacaoDAO.insertLocalizacao(l1);
        //localizacaoDAO.insertLocalizacao(l2);
        //localizacaoDAO.insertLocalizacao(l3);
        //Mostrando localizações
        //localizacaoDAO.selectLocalizacao();

        //Inserindo itens mágicos
        item_magicoDAO.insertItem(i1);
        item_magicoDAO.insertItem(i2);
        item_magicoDAO.insertItem(i3);
        item_magicoDAO.selectItem();

        //Inserindo novos habitante
        //habitanteDAO.insertHabitante(h1);
        //habitanteDAO.insertHabitante(h2);

        //Mostrando os habitantes
        //habitanteDAO.selectHabitante();

        //Atualizando a altura pelo nome
        //habitanteDAO.updateHabitanteLocalizacao(2.2,"Jorge");

        //Deletando um habitante
        //habitanteDAO.deleteHabitante("Carlos");
        //habitanteDAO.deleteHabitante("Jorge");
    }
}
