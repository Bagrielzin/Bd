package br.inatel.DAO;

import br.inatel.Model.Item_Magico;

import java.sql.SQLException;
import java.util.ArrayList;

public class Item_MagicoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertItem(Item_Magico item_magico){
        connectToDB();

        String sql = "INSERT INTO Item_Magico (ID, nome, tipo, durabilidade, material, natureza) VALUES (?,?,?,?,?,?);";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,item_magico.getID());
            pst.setString(2,item_magico.getNome());
            pst.setString(3, item_magico.getTipo());
            pst.setInt(4,item_magico.getDurabilidade());
            pst.setString(5,item_magico.getMaterial());
            pst.setString(6,item_magico.getNatureza());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Item_Magico> selectItem() {
        ArrayList<Item_Magico> item_magicos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Item_Magico";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de itens: ");
            System.out.println("--------------------------------");

            while (rs.next()) {

                Item_Magico itemAux = new Item_Magico(rs.getInt("ID") ,rs.getString("nome"), rs.getString("tipo"), rs.getInt("durabilidade"), rs.getString("material"), rs.getString("natureza"));

                System.out.println("ID = " + itemAux.getID());
                System.out.println("Nome = " + itemAux.getNome());
                System.out.println("Tipo = " + itemAux.getTipo());
                System.out.println("Durabilidade = " + itemAux.getDurabilidade());
                System.out.println("Mateiral = " + itemAux.getMaterial());
                System.out.println("Natureza = " + itemAux.getNatureza());
                System.out.println("--------------------------------");

                item_magicos.add(itemAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return item_magicos;
    }

    public boolean deleteItem(String nome) {
        connectToDB();
        String sql = "DELETE FROM Item_Magico where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}
