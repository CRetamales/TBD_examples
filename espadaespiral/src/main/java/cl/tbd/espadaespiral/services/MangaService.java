package cl.tbd.espadaespiral.services;

import java.util.List;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.tbd.espadaespiral.models.Manga;
import cl.tbd.espadaespiral.repositories.MangaRepository;


@RestController
public class MangaService{
    private final MangaRepository mangaRepository;

    MangaService(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }

    @GetMapping("/manga")
    public List<Manga> getAllManga(){
        System.out.println(mangaRepository.getAll());
        return mangaRepository.getAll();
    }


    @GetMapping("/manga/getByName/{nombremanga}")
    public List<Manga> getMangaByNombre(@PathVariable String nombremanga){
        return mangaRepository.showMangaByName(nombremanga);
    }


    @GetMapping("/manga/getById/{id}")
    public List<Manga> getMangaById(@PathVariable long id){
        return mangaRepository.showMangaById(id);
    }


    @GetMapping("/manga/count")
    public String countManga(){
        int total = mangaRepository.countMangas();
        return String.format("Se tienen %s mangas.", total);
    }


    @PostMapping("/manga/create")
    @ResponseBody
    public Manga createManga(@RequestBody Manga manga){
        Manga newManga = mangaRepository.createManga(manga);
        return newManga;
    }
    
    /*
    @PostMapping("/manga/deleteByName")
    @ResponseBody
    public String deleteManga(@RequestBody String nombreManga){
        mangaRepository.deleteMangaByName(nombreManga);
        return nombreManga;
    }*/


    @RequestMapping(value = "/manga/deleteById/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE})
    public void deleteManga(@PathVariable long id){
        mangaRepository.deleteMangaById(id);
    }


    /*
    @RequestMapping(value = "/manga/updateByName/{nombremanga}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public void updateManga(@RequestBody Manga manga){
        mangaRepository.updateMangaByName(manga);
    }*/


    @RequestMapping(value = "/manga/updateById/{id}", produces = "application/json", method = {RequestMethod.PUT})
    public void updateManga(@RequestBody Manga manga){
        mangaRepository.updateMangaById(manga);
    }

}
