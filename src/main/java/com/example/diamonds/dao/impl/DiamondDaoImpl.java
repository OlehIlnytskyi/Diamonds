package com.example.diamonds.dao.impl;

import com.example.diamonds.dao.DiamondDao;
import com.example.diamonds.model.Diamond;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
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
    public List<Diamond> getSortedBy(String sortedBy, String dir) {
        //Тут зробили по іншому, тому що автозаповнення можливе тільки для параметрів а не для ключових слів

        return jdbcTemplate.query(
                "SELECT * FROM diamonds ORDER BY " + sortedBy + " " + dir + " LIMIT 100", new DiamondsRowMapper()
        );
    }

    @Override
    public Diamond add(Diamond diamond) {
        jdbcTemplate.update("INSERT INTO diamonds VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                diamond.carat(),
                diamond.cut(),
                diamond.colour(),
                diamond.clarity(),
                diamond.depth(),
                diamond.table(),
                diamond.price(),
                diamond.x(),
                diamond.y(),
                diamond.z());

        return diamond;
    }

    @Override
    public Diamond remove(Diamond diamond) {
        jdbcTemplate.update("DELETE FROM diamonds WHERE carat=? AND x=? AND y=? AND z=?",
                diamond.carat(),
                diamond.x(),
                diamond.y(),
                diamond.z());

        return diamond;
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
