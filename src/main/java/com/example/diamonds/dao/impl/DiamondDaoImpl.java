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
        jdbcTemplate.update("INSERT INTO diamonds VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                diamond.getCarat(),
                diamond.getCut(),
                diamond.getColour(),
                diamond.getClarity(),
                diamond.getDepth(),
                diamond.getTable(),
                diamond.getPrice(),
                diamond.getX(),
                diamond.getY(),
                diamond.getZ());

        return diamond;
    }

    @Override
    public Diamond remove(Diamond diamond) {
        jdbcTemplate.update("DELETE FROM diamonds WHERE carat=? AND x=? AND y=? AND z=?",
                diamond.getCarat(),
                diamond.getX(),
                diamond.getY(),
                diamond.getZ());

        return diamond;
    }

    @Override
    public void createTableIfDoesNotExist() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS diamonds (" +
                "carat FLOAT NOT NULL," +
                "cut VARCHAR(64)," +
                "color VARCHAR(5)," +
                "clarity VARCHAR(64)," +
                "depth FLOAT," +
                "\"table\" INT," +
                "price INT," +
                "x FLOAT," +
                "y FLOAT," +
                "z FLOAT" +
                ");");
    }

    static class DiamondsRowMapper implements RowMapper<Diamond> {

        @Override
        public Diamond mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Diamond(
                    rs.getFloat("carat"),
                    rs.getString("cut"),
                    rs.getString("color"),
                    rs.getString("clarity"),
                    rs.getFloat("depth"),
                    rs.getInt("table"),
                    rs.getInt("price"),
                    rs.getFloat("x"),
                    rs.getFloat("y"),
                    rs.getFloat("z")
            );
        }
    }
}
