package cl.tbd.modelos;


public class Manga {
    //ATRIBUTOS DE LA ENTIDAD MANGA 
    // id, nombre del manga, autor del manga, capitulo del manga,
    // categoria del manga, editorial del manga, idioma del manga,
    // numero de paginas y precio del manga
    private long id;
    private String NombreManga;
    private String AutorManga;
    private String CategoriaManga;
    private String EditorialManga;
    private String IdiomaManga;
    private int CapituloManga;
    private int NumeroPaginas;
    private int PrecioManga;


    public Manga(String nombre, String autor, String categoria, String editorial, String idioma, int capitulo, int numeroPaginas, int precio){
        this.NombreManga = nombre;
        this.AutorManga = autor;
        this.CategoriaManga = categoria;
        this.EditorialManga = editorial;
        this.IdiomaManga = idioma;
        this.CapituloManga = capitulo;
        this.NumeroPaginas = numeroPaginas;
        this.PrecioManga = precio;
    }
    //aqui empiezan los setters y getters, cierto?
    //GET ID MANGA
    public long getMangaid(){  
        return id;  
    }  
    //SET ID MANGA
    public void setMangaid(int id){  
        this.id = id;  
    }
    //GET NOMBRE MANGA
    public String getNombreManga(){  
        return NombreManga;  
    }
    //SET ID NOMBRE DE MANGA
    public void setNombreManga(String nombreManga){  
        this.NombreManga = nombreManga;  
    }  
    //GET NOMBRE AUTOR
    public String getAutorManga(){  
        return AutorManga;  
    } 
    //SET AUTOR MANGA
    public void setAutor(String autorManga){  
        this.AutorManga = autorManga;  
    }
    //GET CATEGORIA MANGA
    public String getCategoriaManga() {
        return CategoriaManga;
    }
    // SET CATEGORIA MANGA
    public void setCategoriaManga(String categoriaManga){
        this.CategoriaManga = categoriaManga;
    }
    //GET EDITORIAL MANGA
    public String getEditorialManga(){
        return EditorialManga;
    }
    //SET EDITORIAL MANGA
    public void setEditorialManga(String editorialManga){
        this.EditorialManga = editorialManga;
    }
    //GET IDIOMA MANGA
    public String getIdiomaManga(){
        return IdiomaManga;
    }
    //SET IDIOMA MANGA
    public void setIdiomaManga(String idiomaManga){
        this.IdiomaManga = idiomaManga;
    }
    //GET CAPITULO MANGA  
    public int getCapituloManga(){  
        return CapituloManga;  
    }
    //SET CAPITULO MANGA
    public void setCapituloManga(int capituloManga){  
        this.CapituloManga = capituloManga;
    }
    //GET NUMERO DE PAGINAS MANGA
    public int getNumeroPaginas(){
        return NumeroPaginas;
    }
    //SET NUMERO DE PAGINAS MANGA
    public void setNumeroPaginas(int numeroPaginas){
        this.NumeroPaginas = numeroPaginas;
    }
    //GET PRECIO MANGA
    public int getPrecioManga(){
        return PrecioManga;
    }
    //SET PRECIO MANGA
    public void setPrecioManga(int precioManga){  
        this.PrecioManga = precioManga;  
    } 
}
