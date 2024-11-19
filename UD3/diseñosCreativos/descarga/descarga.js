let counter = -1;
let timer = document.getElementById("timer");
let counterHeading = document.getElementById("counter");
let heading = document.getElementById("h1");

document.getElementById("buttonStart").addEventListener("click", function () {
  timer.classList.remove("hidden");
  counterHeading.classList.remove("hidden");
  heading.classList.add("hidden");

  counter++;
  console.log(counter);
  counterHeading.innerHTML = `${counter}/10`;

  // Get the button
  const button = document.getElementById("buttonStart");

  const maxWidth = window.innerWidth - button.offsetWidth;
  const maxHeight = window.innerHeight - button.offsetHeight;
  const randomX = Math.random() * maxWidth;
  const randomY = Math.random() * maxHeight;

  button.style.position = "absolute";
  button.style.left = `${randomX}px`;
  button.style.top = `${randomY}px`;

  if (!button.dataset.timerStarted) {
    button.dataset.timerStarted = true;

    let countDownDate = new Date().getTime() + 10 * 1000;

    let x = setInterval(function () {
      let now = new Date().getTime();
      let distance = countDownDate - now;

      let seconds = Math.floor(distance / 1000);

      document.getElementById("timer").innerHTML = seconds + "s ";

      if (seconds <= 3) {
        timer.classList.add("warning");
      } else {
        timer.classList.remove("warning");
      }

      // Timer finishes
      if (distance < 0) {
        clearInterval(x);

        if (counter < 10) {
          document.getElementById("timer").innerHTML = "Descarga fallida";
        } else {
          document.getElementById("timer").innerHTML = "Descargando...";
        }
        button.disabled = true;
        button.style.opacity = "0.5";
        timer.classList.remove("warning");
      }

      const header = document.querySelector("header");

      if (seconds <= 5) {
        if (seconds % 2 === 0) {
          header.classList.add("blink-red");
          header.classList.remove("blink-yellow");
        } else {
          header.classList.add("blink-yellow");
          header.classList.remove("blink-red");
        }
      } else {
        header.classList.remove("blink-red", "blink-yellow");
      }
    }, 1000);
  }
});
