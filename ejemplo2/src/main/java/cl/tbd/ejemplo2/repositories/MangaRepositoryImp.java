package cl.tbd.ejemplo2.repositories;

import cl.tbd.ejemplo2.Models.Manga;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

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
    public void createManga(Manga manga){
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

        } finally {
            conn.close();
        }
    }

    
    @Override 
    public void deleteMangaByName(String nombremanga){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM manga WHERE manga.nombremanga = :nombremanga";

        try{
            conn.createQuery(SQL_DELETE).addParameter("nombremanga", nombremanga).executeUpdate();

        } finally {
            conn.close();
        }
    }
    


    @Override 
    public void deleteMangaById(long id){
        Connection conn = sql2o.open();
        String SQL_DELETE = "DELETE FROM manga WHERE manga.id = :id";

        try{
            conn.createQuery(SQL_DELETE).addParameter("id", id).executeUpdate();

        } finally {
            conn.close();
        }
    }


    /*
    @Override
    public void updateMangaByName(String nombremanga){
        Connection conn = sql2o.open();

        Object manga = conn.createQuery("SELECT * FROM manga WHERE manga.nombremanga = :nombremanga");

        if(sql != null){

            String SQL_UPDATE = "UPDATE manga SET manga.nombremanga = :nombremanga, manga.autormanga = :autor, manga.categoriamanga = :categoria, manga.editorialmanga = :editorial, manga.idiomamanga = :idioma, manga.capitulomanga = :capitulo, manga.numeropaginas = :paginas, manga.preciomanga = :precio WHERE manga.nombremanga = :nombremanga";

            try{
                conn.createQuery(SQL_UPDATE)
                        .addParameter("nombremanga", nombremanga)
                        .addParameter("autor", autormanga)
                        .addParameter("categoria", manga.getCategoriaManga())
                        .addParameter("editorial", manga.getEditorialManga())
                        .addParameter("idioma", manga.getIdiomaManga())
                        .addParameter("capitulo", manga.getCapituloManga())
                        .addParameter("paginas", manga.getNumeroPaginas())
                        .addParameter("precio", manga.getPrecioManga())
                        .executeUpdate();

            } finally {
                conn.close();
            }

        }

    }   */

}