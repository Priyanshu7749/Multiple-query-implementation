package org.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:queries.properties")
public class SQLQueryLoader {
    private final Environment env;

    public SQLQueryLoader(Environment env) {
        this.env = env;
    }

    public String getQuery(String key) {
        return env.getProperty(key);
    }
}