package cl.tbd.ejemplo2.services

@RestController

public class MangaService{
    private final MangaRepository mangaRepository;

    MangaService(MangaRepository mangarepository){
        this.mangaRepository = mangaRepository
    }


    @GetMapping("/manga/count")
    public String countManga(){
        int total = mangaRepository.countManga();
        return String.format("Se tienen %s mangas.", total);
    }


    @GetMapping("/manga/create")
    public void createManga(){
        mangaRepository.createManga();
        return String.format("CREAR MANGA");
    }


}
