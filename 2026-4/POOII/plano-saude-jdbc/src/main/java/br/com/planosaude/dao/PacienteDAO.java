package br.com.planosaude.dao;

import br.com.planosaude.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Paciente inserir(Paciente p) {
        String sql = "INSERT INTO paciente (nome, cpf, data_nascimento, telefone, numero_carteirinha) VALUES (?,?,?,?,?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preencher(ps, p);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getLong(1));
            }
            return p;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir paciente", e);
        }
    }

    public List<Paciente> listar() {
        String sql = "SELECT * FROM paciente ORDER BY nome";
        List<Paciente> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pacientes", e);
        }
    }

    public Paciente buscarPorId(long id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente", e);
        }
    }

    public boolean atualizar(Paciente p) {
        String sql = "UPDATE paciente SET nome=?, cpf=?, data_nascimento=?, telefone=?, numero_carteirinha=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            preencher(ps, p);
            ps.setLong(6, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar paciente", e);
        }
    }

    public boolean excluir(long id) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir paciente", e);
        }
    }

    private void preencher(PreparedStatement ps, Paciente p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setString(2, p.getCpf());
        if (p.getDataNascimento() != null) ps.setDate(3, Date.valueOf(p.getDataNascimento()));
        else ps.setNull(3, Types.DATE);
        ps.setString(4, p.getTelefone());
        ps.setString(5, p.getNumeroCarteirinha());
    }

    private Paciente mapear(ResultSet rs) throws SQLException {
        Paciente p = new Paciente();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setCpf(rs.getString("cpf"));
        Date d = rs.getDate("data_nascimento");
        if (d != null) p.setDataNascimento(d.toLocalDate());
        p.setTelefone(rs.getString("telefone"));
        p.setNumeroCarteirinha(rs.getString("numero_carteirinha"));
        return p;
    }
}
