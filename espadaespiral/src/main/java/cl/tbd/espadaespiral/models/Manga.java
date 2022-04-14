package cl.tbd.espadaespiral.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Manga {
    //ATRIBUTOS DE LA ENTIDAD MANGA 
    // id, nombre del manga, autor del manga, capitulo del manga,
    // categoria del manga, editorial del manga, idioma del manga,
    // numero de paginas y precio del manga
    private long id;
    private String nombremanga;
    private String autormanga;
    private String categoriamanga;
    private String editorialmanga;
    private String idiomamanga;
    private int capitulomanga;
    private int numeropaginas;
    private int preciomanga;

    //CONSTRUCTOR MANGA

    public Manga (long id, String nombre, String autor, String categoria, String editorial, String idioma, int capitulo, int numeroPaginas, int precio){
        this.id = id;
        this.nombremanga = nombre;
        this.autormanga = autor;
        this.categoriamanga = categoria;
        this.editorialmanga = editorial;
        this.idiomamanga = idioma;
        this.capitulomanga = capitulo;
        this.numeropaginas = numeroPaginas;
        this.preciomanga = precio;
    }

    //GET ID MANGA
    public long getMangaid(){  
        return id;  
    }  
    //SET ID MANGA
    public void setMangaid(long id){  
        this.id = id;  
    }
    //GET NOMBRE MANGA
    public String getNombreManga(){  
        return nombremanga;  
    }
    //SET ID NOMBRE DE MANGA
    public void setNombreManga(String nombreManga){  
        this.nombremanga = nombreManga;  
    }  
    //GET NOMBRE AUTOR
    public String getAutorManga(){  
        return autormanga;  
    } 
    //SET AUTOR MANGA
    public void setAutor(String autorManga){  
        this.autormanga = autorManga;  
    }
    //GET CATEGORIA MANGA
    public String getCategoriaManga() {
        return categoriamanga;
    }
    // SET CATEGORIA MANGA
    public void setCategoriaManga(String categoriaManga){
        this.categoriamanga = categoriaManga;
    }
    //GET EDITORIAL MANGA
    public String getEditorialManga(){
        return editorialmanga;
    }
    //SET EDITORIAL MANGA
    public void setEditorialManga(String editorialManga){
        this.editorialmanga = editorialManga;
    }
    //GET IDIOMA MANGA
    public String getIdiomaManga(){
        return idiomamanga;
    }
    //SET IDIOMA MANGA
    public void setIdiomaManga(String idiomaManga){
        this.idiomamanga = idiomaManga;
    }
    //GET CAPITULO MANGA  
    public int getCapituloManga(){  
        return capitulomanga;  
    }
    //SET CAPITULO MANGA
    public void setCapituloManga(int capituloManga){  
        this.capitulomanga = capituloManga;
    }
    //GET NUMERO DE PAGINAS MANGA
    public int getNumeroPaginas(){
        return numeropaginas;
    }
    //SET NUMERO DE PAGINAS MANGA
    public void setNumeroPaginas(int numeroPaginas){
        this.numeropaginas = numeroPaginas;
    }
    //GET PRECIO MANGA
    public int getPrecioManga(){
        return preciomanga;
    }
    //SET PRECIO MANGA
    public void setPrecioManga(int precioManga){  
        this.preciomanga = precioManga;  
    } 
}