package cl.tbd.espadaespiral.repositories;

import java.util.List;

import cl.tbd.espadaespiral.models.Manga;

public interface MangaRepository  {

    // supongo que aqui iran las menciones a las funciones del CRUD

    public int countMangas();
    public int newId();
    public List<Manga> getAll();
    public List<Manga> showMangaByName(String nombremanga);
    public List<Manga> showMangaById(long id);
    public Manga createManga(Manga manga);
    //public void deleteMangaByName(String nombremanga);
    public void deleteMangaById(long id);
    //public void updateMangaByName(Manga manga);
    public void updateMangaById(Manga manga);
}