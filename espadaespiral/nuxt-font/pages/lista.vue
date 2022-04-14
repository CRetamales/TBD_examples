<template>
    <div class="container">
    <h1>Todos los mangas</h1>
    <ul class="item-list">
      <li v-for="(item, index) in items" :key="index">
       <!-- <img :src="'https://loremflickr.com/160/120/dog?lock='+i"/>-->
        <!-- {{index}} -  -->
        {{item.nombreManga}} - Precio: {{item.precioManga}} CLP
      </li>
    </ul>
    <div v-if="items.length==0" class="empty-list">
      <em>No se han cargado los datos</em>
    </div>
  </div>
</template>
<script>
export default {
    //Función que contiene los datos del componente
    data(){
        return{
            //Lista de ítems a mostrar
            items:[]
        }
    },
    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get('/manga');
                this.items  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        }
    },
    //Función que se ejecuta al cargar el componente
    created:function(){
        this.getData();
    }
}
</script>
<style>
    .container
    {
        width: 150px;
    }
    .container h1
    {
        color: #fff;
        background: #f33835;
        padding: 10px 20px;
        font-size: 35px;
        text-align: center;
        font-weight: 700;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;

    }

    .container ul
    {
        position: relative;
        background: #fff2;
    }
    .container ul li
    {
        text-align: center;
        list-style: none;
        padding:10px;
        width: 100%;
        background: #fff2;
        box-shadow: 0 5px 25 px rgba(0,0,0.1);
    }
    .container ul li:hover
    {
        transform: scale(1.4);
        z-index:100;
        background: #ff3e25;
        
    }
</style>