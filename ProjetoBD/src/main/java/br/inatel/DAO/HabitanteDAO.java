package br.inatel.DAO;

import br.inatel.Model.Habitante;

import java.sql.SQLException;
import java.util.ArrayList;

public class HabitanteDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertHabitante(Habitante habitante){
        connectToDB();

        String sql = "INSERT INTO Habitante (nome, raça, idade, altura) VALUES (?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,habitante.getNome());
            pst.setString(2, habitante.getRaca());
            pst.setInt(3, habitante.getIdade());
            pst.setDouble(4, habitante.getAltura());
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
        String sql = "SELECT * FROM Habitante";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de habitantes: ");

            while (rs.next()) {

                Habitante habitanteAux = new Habitante(rs.getString("nome"), rs.getString("raça"), rs.getInt("idade"), rs.getDouble("altura"));

                System.out.println("Nome = " + habitanteAux.getNome());
                System.out.println("Raça = " + habitanteAux.getRaca());
                System.out.println("Idade = " + habitanteAux.getIdade());
                System.out.println("Altura = " + habitanteAux.getAltura());
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

    public boolean updateHabitanteLocalizacao(double  altura, String nome) {
        connectToDB();
        String sql = "UPDATE Habitante SET altura =? where nome=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, altura);
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
