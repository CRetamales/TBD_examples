package cl.tbd.ejemplo2.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
  @Bean
  public static Sql2o sql2o(){
    //Esto se debe cambiar acorde a la base de datos y las credenciales
        return new Sql2o("jdbc:postgresql://localhost:5432/prueba", "postgres","contra");
  }
}