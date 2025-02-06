package org.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SQLQueryLoader sqlQueryLoader;

    public UserRepository(JdbcTemplate jdbcTemplate, SQLQueryLoader sqlQueryLoader) {
        this.jdbcTemplate = jdbcTemplate;
        this.sqlQueryLoader = sqlQueryLoader;
    }

    public List<Map<String, Object>> getActiveUsers() {
        String query = sqlQueryLoader.getQuery("user.getAll");
        return jdbcTemplate.queryForList(query);
    }

    public Map<String, Object> getUserById(int id) {
        String query = sqlQueryLoader.getQuery("user.getById");
        return jdbcTemplate.queryForMap(query, id);
    }

}
