package cl.tbd.espadaespiral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import cl.tbd.espadaespiral.repositories.DatabaseContext;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

@SpringBootApplication
public class EspadaespiralApplication {

	public static void main(String[] args) {
		SpringApplication.run(EspadaespiralApplication.class, args);
		Sql2o base = DatabaseContext.sql2o();
		try{
			Connection con = base.open();
			System.out.println("si funciona");
		}
		catch(Sql2oException e){
			System.out.println("no funciona");
		}	
	}

}
