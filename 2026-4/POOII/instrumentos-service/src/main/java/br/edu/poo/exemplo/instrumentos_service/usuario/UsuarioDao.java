package br.edu.poo.exemplo.instrumentos_service.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario validarSenha(Usuario u) throws Exception {
        if (u.getUsuario() == null || u.getUsuario().trim().isEmpty()) {
            throw new Exception("Nome do usuário vazio");
        }
        if (u.getSenha() == null || u.getSenha().trim().isEmpty()) {
            throw new Exception("Tipo do instrumento vazio");
        }
        String query = "select * from Usuario where usuario = ? and senha = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return getUsuarioRS(rs);
                }
            }
        }
        throw new Exception("Usuário ou senha inválido.");
    }

    private Usuario getUsuarioRS(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        u.setId(rs.getInt("ID"));
        u.setUsuario(rs.getString("usuario"));
        u.setSenha(rs.getString("senha"));
        u.setServer(rs.getString("server"));
        u.setToken(rs.getString("token"));
        return u;
    }

    public Usuario incluir(Usuario m) throws Exception {
        validar(m, true);

        String sqlInsert = "INSERT INTO Usuario (usuario, senha, server, token) " +
                "VALUES (?, ?, ?, ?)";
        String generatedColumns[] = { "ID" };
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert, generatedColumns);) {
            ps.setString(1, m.getUsuario());
            ps.setString(2, m.getSenha());
            ps.setString(3, m.getServer());
            ps.setString(4, Long.toString(System.currentTimeMillis()));

            int result = ps.executeUpdate();
            if (result == 1) {
                ResultSet tableKeys = ps.getGeneratedKeys(); //ID Gerado.
                if (tableKeys.next()) {
                    m.setId(tableKeys.getInt(1));
                }
                System.out.println("Pessoa inserida com sucesso:" + m.getUsuario());
                return m;
            }
            throw new Exception("Erro ao inserir no banco.");
        }
    }



    private void validar(Usuario u, boolean incluir) throws Exception {
        if (u.getUsuario() == null || u.getUsuario().trim().isEmpty()) {
            throw new Exception("Nome do usuário vazio");
        }
        if (u.getSenha() == null || u.getSenha().trim().isEmpty()) {
            throw new Exception("Tipo do instrumento vazio");
        }
        if (incluir) {
            String query = "select usuario from Usuario where usuario = ?";
            try (Connection con = jdbcTemplate.getDataSource().getConnection();
                 PreparedStatement ps = con.prepareStatement(query);) {
                ps.setString(1, u.getUsuario());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new Exception("Nome já cadastrado");
                    }
                }
            }
        }
    }
}
