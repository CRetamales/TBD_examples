package cl.tbd.ejemplo2;

import java.sql.*;

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
			Connection con = base.open();
			System.out.println("si funciona");
			String sql = "SELECT count(table1.*) AS cantidad FROM (SELECT film.film_id AS ide, rental.rental_date AS fecha FROM film INNER JOIN inventory ON film.film_id = inventory.film_id INNER JOIN rental ON inventory.inventory_id = rental.inventory_id INNER JOIN customer ON customer.customer_id = rental.customer_id WHERE customer.customer_id = 481 ORDER BY rental.rental_date DESC) table1 INNER JOIN film_category ON film_category.film_id = table1.ide INNER JOIN category ON category.category_id = film_category.category_id GROUP BY category.name;";
			int cantidad = con.createQuery(sql).executeScalar(Integer.class);
			System.out.println("El numero de peliculas es: " + cantidad);
		}
		catch(Sql2oException e){
			System.out.println("no funciona");
		}
		
	}

}
