package cl.tbd.ejemplo2.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.ejemplo2.repositories.MangaRepository;


@RestController
public class MangaService{
    private final MangaRepository mangaRepository;

    MangaService(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }


    @GetMapping("/manga/count")
    public String countManga(){
        int total = mangaRepository.countMangas();
        return String.format("Se tienen %s mangas.", total);
    }


    @GetMapping("/manga/create")
    public String createManga(){
        mangaRepository.createManga();
        return String.format("CREAR MANGA");
    }


}
