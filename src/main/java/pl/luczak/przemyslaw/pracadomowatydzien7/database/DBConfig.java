package pl.luczak.przemyslaw.pracadomowatydzien7.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private final DataSource dataSource;

    @Autowired
    public DBConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void initData() {
//        String sql = "CREATE TABLE Cars (car_id int, mark varchar(255), model varchar(255), color varchar(255), year varchar(255), PRIMARY KEY (car_id))";
//        getTemplate().update(sql);
//    }

}
