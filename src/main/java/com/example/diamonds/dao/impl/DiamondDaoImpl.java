package com.example.diamonds.dao.impl;

import com.example.diamonds.dao.DiamondDao;
import com.example.diamonds.model.Diamond;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DiamondDaoImpl implements DiamondDao {

    private final JdbcTemplate jdbcTemplate;

    public DiamondDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Diamond> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM diamonds LIMIT 100", new DiamondsRowMapper()
        );
    }

    @Override
    public List<Diamond> getByCarat(float carat) {
        return jdbcTemplate.query(
                "SELECT * FROM diamonds WHERE carat = ? LIMIT 100", new DiamondsRowMapper(),
                carat
        );
    }

    @Override
    public Diamond add(Diamond diamond) {
        jdbcTemplate.update("INSERT INTO diamonds VALUES(?, ?, ?)",
                diamond.getCarat(),
                diamond.getColour(),
                diamond.getPrice());

        return diamond;
    }

    @Override
    public Diamond remove(Diamond diamond) {
        jdbcTemplate.update("DELETE FROM diamonds WHERE carat=?",
                diamond.getCarat());

        return diamond;
    }

    @Override
    public void createTableIfDoesNotExist() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS diamonds (" +
                "carat FLOAT NOT NULL," +
                "color VARCHAR(5)," +
                "price INT" +
                ");");
    }

    static class DiamondsRowMapper implements RowMapper<Diamond> {

        @Override
        public Diamond mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Diamond(
                    rs.getFloat("carat"),
                    rs.getString("color"),
                    rs.getInt("price")
            );
        }
    }
}
