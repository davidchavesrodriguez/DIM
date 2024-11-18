let counter = -1;
let timer = document.getElementById("timer");

document.getElementById("buttonStart").addEventListener("click", function () {
  timer.style.classList.remove = "hidden";
  counter++;
  console.log(counter);

  // Obtener el botón
  const button = document.getElementById("buttonStart");

  // Hacer que el botón se mueva aleatoriamente
  const maxWidth = window.innerWidth - button.offsetWidth; // Resta el ancho del botón
  const maxHeight = window.innerHeight - button.offsetHeight; // Resta la altura del botón
  const randomX = Math.random() * maxWidth;
  const randomY = Math.random() * maxHeight;

  button.style.position = "absolute"; // Asegúrate de que el botón sea movible
  button.style.left = `${randomX}px`;
  button.style.top = `${randomY}px`;

  // Iniciar el temporizador si no ha comenzado
  if (!button.dataset.timerStarted) {
    button.dataset.timerStarted = true; // Marcamos que el temporizador ha comenzado

    // Configurar la duración del temporizador (10 segundos)
    let countDownDate = new Date().getTime() + 10 * 1000;

    let x = setInterval(function () {
      let now = new Date().getTime();
      let distance = countDownDate - now;

      let seconds = Math.floor(distance / 1000);

      document.getElementById("timer").innerHTML = seconds + "s ";

      // Timer finishes
      if (distance < 0) {
        clearInterval(x);
        if (counter < 10) {
          document.getElementById("timer").innerHTML = "Descarga fallida";
        } else {
          document.getElementById("timer").innerHTML = "Descargando archivo...";
        }
        button.disabled = true; // Deshabilitar el botón cuando el tiempo acaba
        button.style.opacity = "0.5";
      }
    }, 1000);
  }
});
