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

        Localizacao l1 = new Localizacao("RJ","favela");
        Localizacao l2 = new Localizacao("SR","roça");
        Localizacao l3 = new Localizacao("NY","lixo");
        Item_Magico i1 = new Item_Magico("bola","a",15,"ferro","élfica");
        Item_Magico i2 = new Item_Magico("vara","grande",25,"madeira","natureza");
        Item_Magico i3 = new Item_Magico("espelho","reflexo",2,"vidro","real");
        Habitante h1 = new Habitante("Jorge","Orc",80,1.9,i1.getNome(),l1.getCidade());
        Habitante h2 = new Habitante("Carlos","Anão",29,1.3,i2.getNome(),l2.getCidade());

        //Inserindo localizações
        //localizacaoDAO.insertLocalizacao(l1);
        //localizacaoDAO.insertLocalizacao(l2);
        //localizacaoDAO.insertLocalizacao(l3);
        //Mostrando localizações
        //localizacaoDAO.selectLocalizacao();

        //Inserindo itens mágicos
        //item_magicoDAO.insertItem(i1);
        //item_magicoDAO.insertItem(i2);
        //item_magicoDAO.insertItem(i3);
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
