<template>
  <div class="wrapper">
    <header>
      <nav><!-- Enlaces de navegación-->
        <ul>
          <li>
            <a href="/lista">Mangas</a>
          </li>
          <li>
            <a href="/nuevo">Nuevo</a>
          </li>
          <li>
            <a href="/lista-componente">Lista Comp.</a>
          </li>
          <li>
            <a href="/nosotros">Nosotros</a>
          </li>
        </ul>
      </nav>
    </header>
      <Nuxt /><!-- Contenidos de las páginas-->
    <footer><!-- contenido del footer -->
      Ejemplo TBD
    </footer>
  </div>
</template>

<style>
html {
  font-family:
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
  font-size: 16px;
  word-spacing: 1px;
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
  color: white;
}

*,
*::before,
*::after {
  box-sizing: border-box;
  margin: 0;
}

.button--green {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #23cda6;
  color: #2bba99;
  text-decoration: none;
  padding: 10px 30px;
}

.button--green:hover {
  color: #fff;
  background-color: #00ffc3;
}

.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #0852a1;
  color: #0e6cd1;
  text-decoration: none;
  padding: 10px 30px;
  margin-left: 15px;
}

.button--grey:hover {
  color: #fff;
  background-color: #0e6cd1;
}
</style>
