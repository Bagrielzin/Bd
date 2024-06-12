import br.inatel.DAO.HabitanteDAO;
import br.inatel.DAO.Item_MagicoDAO;
import br.inatel.DAO.LocalizacaoDAO;
import br.inatel.Model.Habitante;
import br.inatel.Model.Item_Magico;
import br.inatel.Model.Localizacao;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HabitanteDAO habitanteDAO = new HabitanteDAO();
        LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
        Item_MagicoDAO item_magicoDAO = new Item_MagicoDAO();

        boolean flag = true;
        while(flag){
            System.out.println();
            System.out.println("******************************");
            System.out.println("Menu");
            System.out.println("1 - Cadastrar Localização");
            System.out.println("2 - Cadastrar Item mágico");
            System.out.println("3 - Cadastrar Habitante");
            System.out.println("4 - Listar habitantes");
            System.out.println("5 - Listar Locais");
            System.out.println("6 - Listar itens");
            System.out.println("7 - Atualizar idade de um habitante pelo nome");
            System.out.println("8 - Deletar um habitante");
            System.out.println("9 - Deletar um item");
            System.out.println("10 - Deletar um local");
            System.out.println("11 - Sair");
            System.out.println("******************************");

            int op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cidade: ");
                    String localCidade = sc.nextLine();
                    System.out.print("Reino: ");
                    String localReino = sc.nextLine();
                    Localizacao l1 = new Localizacao(id,localCidade,localReino);
                    localizacaoDAO.insertLocalizacao(l1);
                    break;

                case 2:
                    System.out.print("ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeItem = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipoItem = sc.nextLine();
                    System.out.print("Durabilidade: ");
                    int durabItem = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Material: ");
                    String materialItem = sc.nextLine();
                    System.out.print("Natureza: ");
                    String naturezaItem = sc.nextLine();
                    Item_Magico im1 = new Item_Magico(id2,nomeItem,tipoItem,durabItem,materialItem,naturezaItem);
                    item_magicoDAO.insertItem(im1);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeHab = sc.nextLine();
                    System.out.print("Raça: ");
                    String racaHab = sc.nextLine();
                    System.out.print("Idade: ");
                    int idadeHab = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Altura: ");
                    double alturaHab = sc.nextDouble();
                    System.out.print("ID do item: ");
                    int id_item = sc.nextInt();
                    System.out.print("ID do local: ");
                    int id_local = sc.nextInt();
                    Habitante hab1 = new Habitante(nomeHab,racaHab,idadeHab,alturaHab,id_item,id_local);
                    habitanteDAO.insertHabitante(hab1);
                    break;

                case 4:
                    habitanteDAO.selectHabitante();
                    break;

                case 5:
                    localizacaoDAO.selectLocalizacao();
                    break;

                case 6:
                    item_magicoDAO.selectItem();
                    break;

                case 7:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeHabAlt = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int idadeAlt = sc.nextInt();
                    habitanteDAO.updateHabitanteLocalizacao(idadeAlt,nomeHabAlt);
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Nome para deletar: ");
                    String nomeDelet = sc.nextLine();
                    habitanteDAO.deleteHabitante(nomeDelet);
                    break;

                case 9:
                    sc.nextLine();
                    System.out.print("Item para deletar: ");
                    String nomeItemDelet = sc.nextLine();
                    item_magicoDAO.deleteItem(nomeItemDelet);
                    break;

                case 10:
                    sc.nextLine();
                    System.out.print("Cidade para deletar: ");
                    String cidadeDelet = sc.nextLine();
                    localizacaoDAO.deleteLocalizacao(cidadeDelet);
                    break;

                case 11:
                    flag = false;
                    break;
            }
        }
    }
}
