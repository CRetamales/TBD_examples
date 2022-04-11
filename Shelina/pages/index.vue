<template>
  <div class="grid-container">
    <div class="item1">
      <Logo />
    </div> <!-- item1 -->
    <div class="item2">
      <link href='https://fonts.googleapis.com/css?family=Vibur:400' rel='stylesheet' type='text/css'>
      <h1 class="title neon flicker">
        Espada Espiral
      </h1>
      <div><p><br></p></div>
      <div class="links">
        <a
          href="https://nuxtjs.org/"
          target="_blank"
          rel="noopener noreferrer"
          class="button--green"
        >
          Documentation
        </a>
        <a
          href="https://github.com/nuxt/nuxt.js"
          target="_blank"
          rel="noopener noreferrer"
          class="button--grey"
        >
          GitHub
        </a>
      </div>
    </div> <!-- item2 -->
  </div> <!-- container -->
</template>

<script>

export default {}
</script>

<style>
.container {
  margin: 0 auto;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family:
    "Vibur";
  display:grid;
  font-weight:0px;
  font-size: 100px;
  color: #ffffff;
  letter-spacing: 1px;
  padding-top: 10%
}

.subtitle {
  font-weight: 100px;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}

.neon {
  color: #fff;
  animation: flicker 1.5s infinite alternate;
  text-shadow:
    0 0 7px #fff,
      0 0 10px #fff,
      0 0 21px #fff,
      0 0 42px #ff0000,
      0 0 82px #ff0000,
      0 0 92px #ff0000,
      0 0 102px #ff0000,
      0 0 151px #ff0000;
}


.grid-container {
  display: grid;
  grid-template-columns: auto auto auto auto;
  grid-gap: 10px;
  padding: 10px;
}

.grid-container > div {
  text-align: center;
  padding: 20px 0;
  font-size: 30px;
}

.item1 {
  grid-column: 1 / span 1;
}

.flicker-slow{
  animation: flicker 3s linear infinite;
}

.flicker-fast{
  animation: flicker 1s linear infinite;
}

@keyframes flicker {
    
  0%, 18%, 22%, 25%, 53%, 57%, 100% {

      text-shadow:
      0 0 7px #fff,
      0 0 10px #fff,
      0 0 21px #fff,
      0 0 42px #ff0000,
      0 0 82px #ff0000,
      0 0 92px #ff0000,
      0 0 102px #ff0000,
      0 0 151px #ff0000;
  
  }
  
  20%, 24%, 55% {        
      text-shadow: none;
  }    
}

</style>
