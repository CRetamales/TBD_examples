package cl.tbd.ejemplo2.repositories;

import cl.tbd.ejemplo2.models.Manga;
import org.sql2o.Sql2o;
import java.util.List;
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
        try (Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }


    @Override
    public void createManga(){
        Connection conn = sql2o.open();

        final String SQL_INSERT = "INSERT INTO 'manga', ('NombreManga', 'AutorManga', 'CategoriaManga', 'EditorialManga', 'IdiomaManga', 'CapituloManga', 'NumeroPaginas', 'PrecioManga')" + 
                            "VALUES(:nombre, :autor, :categoria, :editorial, :idioma, :capitulo, :paginas, :precio)";

        try{
            Manga manga1 = new Manga("Naruto", "Masashi Kishimoto", "Accion", "Norma", "Español", 10, 40, 14990);

            Object insertedId = conn.createQuery(SQL_INSERT, true)
                    .addParameter("nombre", manga1.getNombreManga())
                    .addParameter("autor", manga1.getAutorManga())
                    .addParameter("categoria", manga1.getCategoriaManga())
                    .addParameter("editorial", manga1.getEditorialManga())
                    .addParameter("idioma", manga1.getIdiomaManga())
                    .addParameter("capitulo", manga1.getCapituloManga())
                    .addParameter("paginas", manga1.getNumeroPaginas())
                    .addParameter("precio", manga1.getPrecioManga())
                    .executeUpdate()
                    .getKey();

            System.out.println("ID Manga 01: " + insertedId);

        } finally {
            conn.close();
        }
    }


    @Override 
    public void deleteManga(){
        Connection conn = sql2o.open();

        try{
            conn.createQuery(SQL_DELETE, true)
                    .addParameter("id", 1)
                    .executeUpdate();

        } finally {
            conn.close();
        }
    }


    @Override
    public void readManga(){
        Connection conn = sql2o.open();

        final String SQL_FIND_BY_ID = "SELECT * FROM 'manga' WHERE id = :id";
        final String SQL_FIND_ALL = "SELECT * FROM 'manga'";

        try{
            List<Manga> MangaList = conn.createQuery(SQL_FIND_ALL)
                                                    .addColumnMapping("id", "id")
                                                    .executeAndFetch(Manga.class);
            for (Manga manga : MangaList) {
                System.out.println(manga);
            }

            Manga foundManga = conn.createQuery(SQL_FIND_BY_ID )
                                               .addColumnMapping("id", "id")
                                               .addParameter("id", 1)
                                               .executeAndFetchFirst(Manga.class);

            System.out.println(foundManga);
        } finally {
            conn.close();
        }
    }



    @Override
    public void updateManga(){
        Connection conn = sql2o.open();

        final String SQL_UPDATE = "UPDATE 'manga' " +
                                                " SET 'NombreManga' = :nombre, " +
                                                " 'AutorManga' = :autor, " +
                                                " 'CategoriaManga' = :categoria, " +
                                                " 'EditorialManga' = :editorial " +
                                                " 'IdiomaManga' = :idioma " +
                                                " 'CapituloManga' = :capitulo " +
                                                " 'NumeroPaginas' = :numero " +
                                                " 'PrecioManga' = :precio " +
                                                " WHERE 'id' = :id";

        try{
            Manga manga1 = new Manga("Naruto", "Masashi Kishimoto", "Accion", "Norma", "Español", 10, 40, 14990);

            conn.createQuery(SQL_INSERT, true)
                    .addParameter("nombre", manga1.getNombreManga())
                    .addParameter("autor", manga1.getAutorManga())
                    .addParameter("categoria", manga1.getCategoriaManga())
                    .addParameter("editorial", manga1.getEditorialManga())
                    .addParameter("idioma", manga1.getIdiomaManga())
                    .addParameter("capitulo", manga1.getCapituloManga())
                    .addParameter("numero", manga1.getNumeroPaginas())
                    .addParameter("precio", manga1.getPrecioManga())
                    .executeUpdate();

        } finally {
            conn.close();
        }
    }

}