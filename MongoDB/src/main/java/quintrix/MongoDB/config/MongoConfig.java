package quintrix.MongoDB.config;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.web.client.RestTemplate;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    // TODO Auto-generated method stub
    return "quintrix";
  }

  @Bean
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/quintrix");
    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder().applyConnectionString(connectionString).build();

    return MongoClients.create(mongoClientSettings);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder.setConnectTimeout(Duration.ofMillis(5000))
        .setReadTimeout(Duration.ofMillis(5000)).build();
  }


}
