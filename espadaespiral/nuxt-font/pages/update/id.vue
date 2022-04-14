<template>
    <div class="container">
        <h1>Actualizar Manga por Id</h1>
        <form>
            <div class="form-item">
                <label for="mangaid">Id Manga</label>
                <input type="text" id="mangaid" v-model="newManga.mangaid">
                <h2>Datos a actualizar</h2>
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
                <button type="button" @click="putData" class="main">Actualizar</button>
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

        
        putData:async function(){
            this.message = '';
            const id = this.newManga.mangaid;
            //validaciones de formulario
            //envío de datos del formulario
            try {
                var result = await this.$axios.put(`/manga/updateById/${this.newManga.mangaid}`,this.newManga);
                console.log(result.data)
                let manga = result.data;
                //mensaje de exito
                this.message = `Se actulizo el nuevo Manga con id: ${this.newManga.mangaid}`;
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