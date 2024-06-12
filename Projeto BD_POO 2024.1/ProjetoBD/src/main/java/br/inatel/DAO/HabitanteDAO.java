package br.inatel.DAO;

import br.inatel.Model.Habitante;
import br.inatel.Model.Item_Magico;
import br.inatel.Model.Localizacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class HabitanteDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertHabitante(Habitante habitante){
        connectToDB();

        String sql = "INSERT INTO Habitante (nome, raça, idade, altura, ID_Item, ID_Local) VALUES (?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,habitante.getNome());
            pst.setString(2, habitante.getRaca());
            pst.setInt(3, habitante.getIdade());
            pst.setDouble(4, habitante.getAltura());
            pst.setInt(5,habitante.getID_Item());
            pst.setInt(6,habitante.getID_Local());
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

    public ArrayList<Habitante> selectHabitante() {
        ArrayList<Habitante> habitantes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT h.nome, h.raça, h.idade, h.altura, h.ID_Item, h.ID_Local, im.ID as im_ID, im.nome as im_nome, im.tipo, im.durabilidade, im.material, im.natureza, l.ID as l_ID, l.cidade, l.reino " +
                "FROM Habitante h " +
                "JOIN Item_Magico im ON im.ID = h.ID_Item " +
                "JOIN Localizacao l ON l.ID = h.ID_Local;";


        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de habitantes: ");
            System.out.println("--------------------------------");

            while (rs.next()) {
                Habitante habitanteAux = new Habitante(rs.getString("nome"), rs.getString("raça"), rs.getInt("idade"), rs.getDouble("altura"), rs.getInt("ID_Item"), rs.getInt("ID_Local"));
                Item_Magico itemAux = new Item_Magico(rs.getInt("im_ID"), rs.getString("im_nome"), rs.getString("tipo"), rs.getInt("durabilidade"), rs.getString("material"), rs.getString("natureza"));
                Localizacao localizacaoAux = new Localizacao(rs.getInt("l_ID"), rs.getString("cidade"), rs.getString("reino"));

                System.out.println("Nome = " + habitanteAux.getNome());
                System.out.println("Raça = " + habitanteAux.getRaca());
                System.out.println("Idade = " + habitanteAux.getIdade());
                System.out.println("Altura = " + habitanteAux.getAltura());
                System.out.println("Item mágico = " + itemAux.getNome());
                System.out.println("Cidade = " + localizacaoAux.getCidade());
                System.out.println("--------------------------------");

                habitantes.add(habitanteAux);
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
        return habitantes;
    }

    public boolean updateHabitanteLocalizacao(int  idade, String nome) {
        connectToDB();
        String sql = "UPDATE Habitante SET idade =? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idade);
            pst.setString(2, nome);
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

    public boolean deleteHabitante(String nome) {
        connectToDB();
        String sql = "DELETE FROM Habitante where nome=?";
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
