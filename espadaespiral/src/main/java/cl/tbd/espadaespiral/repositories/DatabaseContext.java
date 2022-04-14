package cl.tbd.espadaespiral.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

@Configuration
public class DatabaseContext {
  @Bean
  public static Sql2o sql2o(){
    //Carlos,Bastian,Felipe,Carla,Estefania,Sora
    String[] usuarios = new String[] {"postgres", "postgres", "postgres","postgres","postgres","postgress","postgres"};
    String[] contraseñas = new String[] {"default", "2701", "Fcii01000110","contra4","3144","contra6","abcdef1234"};
    int i;

    //Esto se debe cambiar acorde a la base de datos y las credenciales
    for(i=0;i<7;i++){

      try{
        Sql2o base = new Sql2o("jdbc:postgresql://localhost:5432/MangaDB",usuarios[i],contraseñas[i]);
        Connection conn = base.open();
        return base;

      }
      catch(Sql2oException e){
        if(i>=7){
          System.out.println("Por favor enciende la base de datos o valida tus credenciales");
        }
      }
    }
    System.out.println("Por favor enciende la base de datos o valida tus credenciales!");
    return null;
  }
}