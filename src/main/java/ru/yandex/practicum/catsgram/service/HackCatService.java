package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class HackCatService {
    public static final String JDBC_URL = "jdbc:postgresql://127.0.0.1:5432/cats";
    public static final String JDBC_USERNAME = "kitty";
    public static final String JDBC_DRIVER = "org.postgresql.Driver";

    public void tryPassword(String jdbsPassword) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USERNAME);
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setPassword(jdbsPassword);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("SELECT 1;");
    }

    public void doHackNow() {
        List<String> catWordList = Arrays.asList("meow", "purr", "purrrrrr", "zzz");
        for (String wordCat : catWordList) {
            try {
                tryPassword(wordCat);
            } catch (Exception e) {
                log.info("Пароль " + wordCat + " не подходит.");
            }
        }
    }
}
