package unifaj.com.planosaude.dao;

import unifaj.com.planosaude.entity.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public Medico inserir(Medico m) {
        String sql = "INSERT INTO medico (nome, crm, especialidade, telefone) VALUES (?,?,?,?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preencher(ps, m);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) m.setId(rs.getLong(1));
            }
            return m;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir medico", e);
        }
    }

    public List<Medico> listar() {
        String sql = "SELECT * FROM medico ORDER BY nome";
        List<Medico> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar medicos", e);
        }
    }

    public Medico buscarPorId(long id) {
        String sql = "SELECT * FROM medico WHERE id = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar medico", e);
        }
    }

    public boolean atualizar(Medico m) {
        String sql = "UPDATE medico SET nome=?, crm=?, especialidade=?, telefone=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            preencher(ps, m);
            ps.setLong(5, m.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar medico", e);
        }
    }

    public boolean excluir(long id) {
        String sql = "DELETE FROM medico WHERE id = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir medico", e);
        }
    }

    private void preencher(PreparedStatement ps, Medico m) throws SQLException {
        ps.setString(1, m.getNome());
        ps.setString(2, m.getCrm());
        ps.setString(3, m.getEspecialidade());
        ps.setString(4, m.getTelefone());
    }

    private Medico mapear(ResultSet rs) throws SQLException {
        Medico m = new Medico();
        m.setId(rs.getLong("id"));
        m.setNome(rs.getString("nome"));
        m.setCrm(rs.getString("crm"));
        m.setEspecialidade(rs.getString("especialidade"));
        m.setTelefone(rs.getString("telefone"));
        return m;
    }
}
