package br.edu.unifaj.cc.aula04_jdbc_service.repository;
import br.edu.unifaj.cc.aula04_jdbc_service.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class PessoaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Pessoa inserir(Pessoa p) throws Exception {

        String sqlInsert = "insert into Pessoa(nome, endereco, telefone)" + "values (?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection()){

            // con.close();
            return p;
        }
    }
}
