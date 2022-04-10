package cl.tbd.ejemplo2.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.ejemplo2.Models.Manga;
import cl.tbd.ejemplo2.repositories.MangaRepository;


@RestController
public class MangaService{
    private final MangaRepository mangaRepository;

    MangaService(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }


    @GetMapping("/manga")
    public List<Manga> getAllManga(){
        return mangaRepository.getAll();
    }


    @GetMapping("/manga/getName/{nombremanga}")
    public List<Manga> getMangaByNombre(@PathVariable String nombremanga){
        return mangaRepository.showMangaByName(nombremanga);
    }


    @GetMapping("/manga/getId/{id}")
    public List<Manga> getMangaById(@PathVariable long id){
        return mangaRepository.showMangaById(id);
    }


    @GetMapping("/manga/count")
    public String countManga(){
        int total = mangaRepository.countMangas();
        return String.format("Se tienen %s mangas.", total);
    }


    @RequestMapping(value = "/manga/create", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public String createManga(){
        //Manga manga = new Manga("One Piece", "Eiichiro Oda", "Comedia", "Shonen Jump", "Japones", 1, 100, 1000);
        //Manga manga2 = new Manga("Naruto", "Masashi Kishimoto", "Comedia", "Shonen Jump", "Japones", 1, 100, 1000);
        Manga manga3 = new Manga("Bleach", "Tite Kubo", "Comedia", "Shonen Jump", "Japones", 1, 100, 1000);
        mangaRepository.createManga(manga3);
        return String.format("Se ha creado el manga %s.", manga3.getNombreManga());
    }
    

    @RequestMapping(value = "/manga/deleteName/{nombremanga}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteManga(@PathVariable String nombremanga){
        mangaRepository.deleteMangaByName(nombremanga);
        return String.format("Se ha eliminado el manga %s.", nombremanga);
    }


    @RequestMapping(value = "/manga/deleteId/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteManga(@PathVariable long id){
        mangaRepository.deleteMangaById(id);
        return String.format("Se ha eliminado el manga con id: %d.", id);
    }

}
