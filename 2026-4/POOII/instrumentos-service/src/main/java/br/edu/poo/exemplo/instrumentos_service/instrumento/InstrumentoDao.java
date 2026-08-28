package br.edu.poo.exemplo.instrumentos_service.instrumento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Instrumento> listar() throws Exception {
        List<Instrumento> list = new ArrayList<>();
        String query = "SELECT * FROM Instrumento";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                Instrumento p = getInstrumentoRS(rs);
                list.add(p);
            }
        } catch (Exception ex) {
            System.err.println("Erro ao obter os dados:" + ex);
            throw ex;
        }
        return list;
    }

    public Instrumento obter(int id) throws Exception {
        String query = "SELECT * FROM Instrumento where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Instrumento p = getInstrumentoRS(rs);
                    return p;
                }
            }
        } catch (Exception ex) {
            System.err.println("Erro ao obter os dados:" + ex);
            throw ex;
        }
        throw new Exception("Instrumento não encontrado:" + id);
    }

    private Instrumento getInstrumentoRS(ResultSet rs) throws SQLException {
        Instrumento p = new Instrumento();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setTipo(rs.getString("tipo"));
        p.setDescricao(rs.getString("descricao"));
        p.setPreco(rs.getFloat("preco"));
        return p;
    }

    public Instrumento incluir(Instrumento m) throws Exception {
        validar(m, true);

        String sqlInsert = "INSERT INTO Instrumento (NOME, TIPO, DESCRICAO, PRECO) " +
                "VALUES (?, ?, ?, ?)";
        String generatedColumns[] = { "ID" };
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert, generatedColumns);) {
            ps.setString(1, m.getNome());
            ps.setString(2, m.getTipo());
            ps.setString(3, m.getDescricao());
            ps.setFloat(4, m.getPreco());

            int result = ps.executeUpdate();
            if (result == 1) {
                ResultSet tableKeys = ps.getGeneratedKeys(); //ID Gerado.
                if (tableKeys.next()) {
                    m.setId(tableKeys.getInt(1));
                }
                System.out.println("Instrumento inserido com sucesso:" + m.getNome());
                return m;
            }
            throw new Exception("Erro ao inserir no banco.");
        }
    }

    public Instrumento alterar(Instrumento inst) throws Exception {
        validar(inst, false);

        String sqlUpdate = "UPDATE Instrumento set NOME = ?, TIPO = ?, DESCRICAO = ?, PRECO = ? " +
                " WHERE ID = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate);) {
            ps.setString(1, inst.getNome());
            ps.setString(2, inst.getTipo());
            ps.setString(3, inst.getDescricao());
            ps.setFloat(4, inst.getPreco());
            ps.setInt(5, inst.getId());

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Instrumento alterado com sucesso:" + inst.getNome());
                return inst;
            }
            throw new Exception("Erro ao alterar no banco.");
        }
    }

    public Instrumento alterarPreco(Instrumento inst) throws Exception {
        String sqlUpdate = "UPDATE Instrumento set PRECO = ? WHERE ID = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlUpdate);) {
            ps.setFloat(1, inst.getPreco());
            ps.setInt(2, inst.getId());

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Preco do Instrumento alterado com sucesso:" + inst.getNome());
                return inst;
            }
            throw new Exception("Erro ao alterar no banco.");
        }
    }


    public boolean excluir(int id) throws Exception {
        String sqlDelete = "DELETE FROM Instrumento WHERE ID = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlDelete);) {
            ps.setInt(1, id);

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Instrumento excluido com sucesso:" + id);
                return true;
            }
            throw new Exception("Erro ao excluir no banco.");
        }
    }

    private void validar(Instrumento p, boolean incluir) throws Exception {
        if (p.getNome() == null || p.getNome().trim().isEmpty()) {
            throw new Exception("Nome do instrumento vazio");
        }
        if (p.getTipo() == null || p.getTipo().trim().isEmpty()) {
            throw new Exception("Tipo do instrumento vazio");
        }
        if (incluir) {
            String query = "select nome from Instrumento where nome = ?";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query);) {
                ps.setString(1, p.getNome());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Nome já cadastrado");
                    }
                }
            }
        } else {
            String query = "select nome from Instrumento where nome = ? and id <> ?";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query);) {
                ps.setString(1, p.getNome());
                ps.setInt(2, p.getId());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Nome já cadastrado");
                    }
                }
            }
        }
    }
}
