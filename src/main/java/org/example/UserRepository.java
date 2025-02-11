package org.example;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@PropertySource("classpath:queries.properties")
public class UserRepository {

    @Resource
    public Environment environment;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getActiveUsers() {
        String query = environment.getProperty("user.getAll");
        return jdbcTemplate.queryForList(query);
    }

    public Map<String, Object> getUserById(int id) {
        String query = environment.getProperty("user.getById");
        return jdbcTemplate.queryForMap(query, id);
    }

}
