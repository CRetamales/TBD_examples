<template>
    <div class="container">
        <h1>Agregar un Manga</h1>
        <form>
            <div class="form-item">
                <label for="nombreManga">Nombre Manga</label>
                <input type="text" id="nombreManga" v-model="newManga.nombreManga">
                <label for="autorManga">Autor</label>
                <input type="text" id="autorManga" v-model="newManga.autor">
                <label for="categoriaManga">Categoria</label>
                <input type="text" id="categoriaManga" v-model="newManga.categoriaManga">
                <label for="editorialManga">Editorial</label>
                <input type="text" id="editorialManga" v-model="newManga.editorialManga">
                <label for="idiomaManga">Idioma</label>
                <input type="text" id="idiomaManga" v-model="newManga.idiomaManga">
                <label for="capituloManga">Capitulo</label>
                <input type="text" id="capituloManga" v-model="newManga.capituloManga">
                <label for="numeropaginas">Hojas</label>
                <input type="text" id="numeropaginas" v-model="newManga.numeroPaginas">
                <label for="precioManga">Precio</label>
                <input type="text" id="precioManga" v-model="newManga.precioManga">
            </div>
            <div>
                <button type="button" @click="send" class="main">Crear</button>
            </div>
            <div class="info">
                <h2>Objeto</h2>
                <code>{{newManga}}</code>
                <p class="message">
                    {{message}}
                </p>
            </div>
        </form>

    </div>
</template>
<script>
function checkNulls(obj){
    console.log("b");
    console.log(obj);
    for (var c in obj){
        if (obj[c] != null && obj[c] != ""){
            return true;
        }
    }
    return false;
}
export default {
    data(){
        return{
            message:'',
            newManga:{}
        }
    },
    methods:{
        send:async function(){
            this.message = '';
            //validaciones de formulario
            //envío de datos del formulario
            try {
                var result = await this.$axios.post('/manga/create',this.newManga);
                console.log(result.data)
                let manga = result.data;
                //mensaje de exito
                this.message = `Se creó un nuevo Manga con id: ${manga.mangaid - 1}`;
                this.newManga = {};
            } catch (error) {
                //mensaje de error
                console.log('error', error)
                this.message = 'Ocurrió un error'
            }
        }
    }
}
</script>
<style>
code{
    padding: .5rem 1rem;
    color:white;
    background:#444;
    font-size: 1rem;
    width: 100%;
    display:inline-block;
}
p.message{
    border:solid 1px rgba(0,0,0,0.25);
    padding: .5rem 1rem;
    font-weight: bold;
}
</style>