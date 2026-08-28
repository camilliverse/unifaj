package br.edu.poo.exemplo.instrumentos_service.dbimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ArquivoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> listar() throws Exception {
        List<String> list = new ArrayList<>();
        String query = "SELECT arquivo FROM IMAGENS";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query);){
            while (rs.next()) {
                list.add(rs.getString("arquivo"));
            }
        } catch (Exception ex) {
            System.err.println("Erro ao obter os dados:" + ex);
            throw ex;
        }
        return list;

    }

    public void gravarImagem(Arquivo arquivo) throws Exception {
        String sqlInsert = "INSERT INTO IMAGENS(arquivo, type, data) VALUES (?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(
                     sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, arquivo.getArquivo());
            ps.setInt(2, 0);
            ps.setBytes(3, arquivo.getData());
            int result = ps.executeUpdate();
            if (result == 1) {
                return;
            }
            throw new Exception("Erro ao inserir no banco.");
        }
    }

    public Arquivo obterArquivoByName(String filename) throws Exception {
        String query = "SELECT id, arquivo, type, data FROM IMAGENS where arquivo = '" + filename + "'";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);){
            rs.next();
            Arquivo a = new Arquivo();
            a.setId(rs.getInt("id"));
            a.setArquivo(rs.getString("arquivo"));
            a.setType(rs.getInt("type"));
            a.setData(rs.getBytes("data"));
            return a;
        } catch (Exception ex) {
            System.err.println("Erro ao obter os dados:" + ex);
            throw ex;
        }
    }
}
