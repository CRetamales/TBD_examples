package cl.tbd.espadaespiral.repositories;

import cl.tbd.espadaespiral.models.Manga;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;

@Repository
public class MangaRepositoryImp implements MangaRepository {
    
    @Autowired
    private Sql2o sql2o;

    // aqui van las funciones del CRUD como tal
    
    @Override
    public int countMangas(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM manga";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
            return total;
        }
    }


    @Override
    public int newId(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM manga";
        try (Connection conn = sql2o.open()) {
            id = conn.createQuery(sql).executeScalar(Integer.class);
            return id+1;
        }
    }


    @Override
    public List<Manga> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM manga ORDER BY manga.nombremanga ASC")
                    .executeAndFetch(Manga.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    @Override
    public List<Manga> showMangaByName(String nombremanga) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM manga WHERE manga.nombremanga = :nombremanga")
                    .addParameter("nombremanga", nombremanga)
                    .executeAndFetch(Manga.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    

    @Override
    public List<Manga> showMangaById(long id){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM manga WHERE manga.id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Manga.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    

    @Override
    public Manga createManga(Manga manga){
        Connection conn = sql2o.open();
        String SQL_INSERT = "INSERT INTO manga(nombremanga, autormanga, categoriamanga, editorialmanga, idiomamanga, capitulomanga, numeropaginas, preciomanga)" + 
                            "VALUES(:nombre, :autor, :categoria, :editorial, :idioma, :capitulo, :paginas, :precio)";

        try{
            conn.createQuery(SQL_INSERT, true)
                    .addParameter("nombre", manga.getNombreManga())
                    .addParameter("autor", manga.getAutorManga())
                    .addParameter("categoria", manga.getCategoriaManga())
                    .addParameter("editorial", manga.getEditorialManga())
                    .addParameter("idioma", manga.getIdiomaManga())
                    .addParameter("capitulo", manga.getCapituloManga())
                    .addParameter("paginas", manga.getNumeroPaginas())
                    .addParameter("precio", manga.getPrecioManga())
                    .executeUpdate();

            manga.setMangaid(newId());
            return manga;

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo crear el manga\n");
            return null;
        }
    }

    /*
    @Override 
    public void deleteMangaByName(String nombremanga){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM manga WHERE manga.nombremanga = :nombremanga";
        try{
            nombremanga = nombremanga.substring(0, nombremanga.length()-1);
            conn.createQuery(SQL_DELETE).addParameter("nombremanga", nombremanga).executeUpdate();
            System.out.println(nombremanga);

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el manga\n");
        }
    }*/
    


    @Override 
    public void deleteMangaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM manga WHERE manga.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo borrar el manga\n");
        }
    }

/*
    @Override
    public void updateMangaByName(Manga manga){

        String SQL_UPDATE = "UPDATE manga SET nombremanga = :nombremanga, autormanga = :autor, categoriamanga = :categoria, editorialmanga = :editorial, idiomamanga = :idioma, capitulomanga = :capitulo, numeropaginas = :paginas, preciomanga = :precio, id = :id WHERE nombremanga = :nombremanga";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombremanga", manga.getNombreManga())
                    .addParameter("autor", manga.getAutorManga())
                    .addParameter("categoria", manga.getCategoriaManga())
                    .addParameter("editorial", manga.getEditorialManga())
                    .addParameter("idioma", manga.getIdiomaManga())
                    .addParameter("capitulo", manga.getCapituloManga())
                    .addParameter("paginas", manga.getNumeroPaginas())
                    .addParameter("precio", manga.getPrecioManga())
                    .addParameter("id", manga.getMangaid())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el manga\n");
        }
    }  */


    @Override
    public void updateMangaById(Manga manga){

        String SQL_UPDATE = "UPDATE manga SET nombremanga = :nombremanga, autormanga = :autor, categoriamanga = :categoria, editorialmanga = :editorial, idiomamanga = :idioma, capitulomanga = :capitulo, numeropaginas = :paginas, preciomanga = :precio, id = :id WHERE id = :id";
        
        System.out.println("llega acá");
        try(Connection conn = sql2o.open()) {
            conn.createQuery(SQL_UPDATE)
                    .addParameter("nombremanga", manga.getNombreManga())
                    .addParameter("autor", manga.getAutorManga())
                    .addParameter("categoria", manga.getCategoriaManga())
                    .addParameter("editorial", manga.getEditorialManga())
                    .addParameter("idioma", manga.getIdiomaManga())
                    .addParameter("capitulo", manga.getCapituloManga())
                    .addParameter("paginas", manga.getNumeroPaginas())
                    .addParameter("precio", manga.getPrecioManga())
                    .addParameter("id", manga.getMangaid())
                    .executeUpdate();

        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage() + "No se pudo actualizar el manga\n");
        }
    }
}