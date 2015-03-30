package votingsystem;

import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ASHU on 02-03-2015.
 */

@ComponentScan(basePackages = {"votingsystem"})
@EnableAutoConfiguration
@EnableMongoRepositories
public class ApplicationConf extends AbstractMongoConfiguration {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationConf.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return  "cmpe273";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient("localhost",27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "config.beans";
    }

    @Bean
    MongoMappingContext springDataMongoMappingContext() {
        return new MongoMappingContext();
    }
}
