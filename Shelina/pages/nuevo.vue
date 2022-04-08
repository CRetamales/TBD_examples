<template>
    <div class="container">
        <h1>Agregar un Manga</h1>
        <form>
            <div class="form-item">
                <label for="title">Titulo</label>
                <input type="text" id="title" v-model="newManga.title">
                <label for="author">Autor</label>
                <input type="text" id="author" v-model="newManga.author">
                <label for="chapter">Capitulo</label>
                <input type="text" id="chapter" v-model="newManga.chapter">
                <label for="category">Categorias</label>
                <input type="text" id="category" v-model="newManga.category"> <!-- cambiar aqui por algun seleccionador multiple -->
                <label for="edit">Editorial</label>
                <input type="text" id="edit" v-model="newManga.edit">
                <label for="leng">Idioma</label>
                <input type="text" id="leng" v-model="newManga.leng">
                <label for="pages">Hojas</label>
                <input type="text" id="pages" v-model="newManga.pages">
                <label for="price">Precio</label>
                <input type="text" id="price" v-model="newManga.price">
            </div>
            <div>
                <button type="button" @click="send" class="main">Imprimir</button>
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
            console.log("a");
            //validaciones de formulario
            if (checkNulls(this.newManga)){
                print("A");
                this.message = 'Debe completar todos los campos.';
                return false
            }
            //envío de datos del formulario
            console.log("a");
            try {
                var result = await this.$axios.post('/mangas', this.newManga);
                let manga = result.data;
                //mensaje de exito 
                this.message = `Se creó un nuevo perro con id: ${manga.id}`;
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