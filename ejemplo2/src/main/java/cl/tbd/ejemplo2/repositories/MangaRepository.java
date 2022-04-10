package cl.tbd.ejemplo2.repositories;

import java.util.List;

import cl.tbd.ejemplo2.Models.Manga;

public interface MangaRepository  {

    // supongo que aqui iran las menciones a las funciones del CRUD

    public int countMangas();
    public List<Manga> getAll();
    public List<Manga> showMangaByName(String nombremanga);
    public List<Manga> showMangaById(long id);
    public void createManga(Manga manga);
    public void deleteMangaByName(String nombremanga);
    public void deleteMangaById(long id);

    //public void updateMangaByName(String nombremanga);
    //public void updateMangaById();
}