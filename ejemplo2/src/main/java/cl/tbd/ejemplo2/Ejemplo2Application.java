package cl.tbd.ejemplo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import cl.tbd.ejemplo2.repositories.DatabaseContext;

@SpringBootApplication
public class Ejemplo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo2Application.class, args);
		Sql2o base = DatabaseContext.sql2o();
		try{
			Connection conn = base.open();
			System.out.println("si funciona");

        }
		catch(Sql2oException e){
			System.out.println("no funciona");
		}
		
	}

}
