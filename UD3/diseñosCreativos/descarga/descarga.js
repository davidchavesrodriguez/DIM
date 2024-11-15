document.getElementById("buttonStart").addEventListener("click", function () {
  // Obtener el botón
  const button = document.getElementById("buttonStart");

  // Obtener las dimensiones de la ventana del navegador
  const maxWidth = window.innerWidth - button.offsetWidth; // Resta el ancho del botón
  const maxHeight = window.innerHeight - button.offsetHeight; // Resta la altura del botón

  // Generar posiciones aleatorias dentro de las dimensiones de la ventana
  const randomX = Math.random() * maxWidth;
  const randomY = Math.random() * maxHeight;

  // Mover el botón a las posiciones aleatorias
  button.style.left = `${randomX}px`;
  button.style.top = `${randomY}px`;
});
