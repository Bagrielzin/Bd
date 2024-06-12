package br.inatel.DAO;

import br.inatel.Model.Localizacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalizacaoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertLocalizacao(Localizacao localizacao){
        connectToDB();

        String sql = "INSERT INTO Localizacao (ID, cidade, reino) VALUES (?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,localizacao.getID());
            pst.setString(2,localizacao.getCidade());
            pst.setString(3, localizacao.getReino());
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

    public ArrayList<Localizacao> selectLocalizacao() {
        ArrayList<Localizacao> localizacoes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Localizacao";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de locais: ");
            System.out.println("--------------------------------");

            while (rs.next()) {

                Localizacao localizacaoAux = new Localizacao(rs.getInt("ID") ,rs.getString("cidade"), rs.getString("reino"));

                System.out.println("ID = " + localizacaoAux.getID());
                System.out.println("Cidade = " + localizacaoAux.getCidade());
                System.out.println("Reino = " + localizacaoAux.getReino());
                System.out.println("--------------------------------");

                localizacoes.add(localizacaoAux);
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
        return localizacoes;
    }

    public boolean deleteLocalizacao(String nome) {
        connectToDB();
        String sql = "DELETE FROM Localizacao where cidade=?";
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
