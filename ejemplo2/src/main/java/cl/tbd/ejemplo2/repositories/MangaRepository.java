package cl.tbd.ejemplo2.repositories

public interface MangaRepository {

    // supongo que aqui iran las menciones a las funciones del CRUD

    public int countMangas();
    public void createManga();
    public void deleteManga();
    public void readManga();
    public void updateManga();
}