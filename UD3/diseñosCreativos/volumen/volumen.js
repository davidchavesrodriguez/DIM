// Botón de inicio
let botonStart = document.getElementById("buttonStart");
// Contedor para o xogo
let gameContainer = document.getElementById("gameContainer");

// Variables globais do xogo
let vidaMonstro, vidaXogador, contadorEspecial, rendicion;
let arrayRexistro = [];

// Escuchar o evento do botón de inicio
botonStart.addEventListener("click", iniciarXogo);

// Función para iniciar o xogo
function iniciarXogo() {
  // Inicializar variables
  vidaMonstro = 100;
  vidaXogador = 100;
  contadorEspecial = 3;
  rendicion = false;

  // Crear o HTML do xogo
  gameContainer.innerHTML = `
    <main id="healtBarSection">
      <section id="monster" class="container">
        <h2>Monstro</h2>
        <div class="healthbar">
          <div class="healthbar__value" id="barraVidaMonstro">100%</div>
        </div>
      </section>
      <section id="player" class="container">
        <h2>Vostede</h2>
        <div class="healthbar">
          <div class="healthbar__value" id="barraVidaXogador">100%</div>
        </div>
      </section>
    </main>
    <section id="controls">
      <button id="ataque">ATAQUE</button>
      <button id="especial">ATAQUE ESPECIAL</button>
      <button id="curacion">CURACIÓN</button>
      <button id="renderse">RENDERSE</button>
    </section>
    <section id="log" class="container">
      <h2>Rexistro da batalla</h2>
      <ul></ul>
    </section>
    <section class="container" id="finalSection" style="display: none;">
      <h2 id="resultadoFinal"></h2>
      <button id="reinicio">Novo volumen</button>
    </section>
  `;

  // Ocultar o botón de inicio
  botonStart.style.display = "none";

  // Asignar eventos aos botóns
  document.getElementById("ataque").addEventListener("click", ataque);
  document.getElementById("especial").addEventListener("click", especial);
  document.getElementById("curacion").addEventListener("click", curacion);
  document.getElementById("renderse").addEventListener("click", renderse);
  document.getElementById("reinicio").addEventListener("click", reinicio);
}

// Funcións do xogo
function normalizarValor(valor) {
  if (valor < 0) return 0;
  if (valor > 100) return 100;
  return valor;
}

function actualizarBarras() {
  vidaMonstro = normalizarValor(vidaMonstro);
  vidaXogador = normalizarValor(vidaXogador);

  document.getElementById("barraVidaMonstro").style.width = `${vidaMonstro}%`;
  document.getElementById("barraVidaMonstro").textContent = `${vidaMonstro}%`;
  document.getElementById("barraVidaXogador").style.width = `${vidaXogador}%`;
  document.getElementById("barraVidaXogador").textContent = `${vidaXogador}%`;
}

function rexistrarMovimiento(playerMsg, monsterMsg) {
  arrayRexistro.push(`<li class="log--player">${playerMsg}</li>`);
  arrayRexistro.push(`<li class="log--monster">${monsterMsg}</li>`);

  let logAtaques = document.querySelector("#log ul");
  logAtaques.innerHTML = arrayRexistro.slice(-6).reverse().join("");
}

function ataque() {
  let danoMonstro = getRandomIntInclusive(5, 12);
  let danoXogador = getRandomIntInclusive(8, 15);
  vidaMonstro -= danoMonstro;
  vidaXogador -= danoXogador;

  rexistrarMovimiento(
    `Vostede atacou o monstro con ${danoMonstro}`,
    `O monstro atacoulle con ${danoXogador}`
  );

  actualizarBarras();
  finalizarTurno();
}

function especial() {
  if (contadorEspecial % 3 === 0) {
    let danoMonstro = getRandomIntInclusive(10, 25);
    let danoXogador = getRandomIntInclusive(8, 15);
    vidaMonstro -= danoMonstro;
    vidaXogador -= danoXogador;

    rexistrarMovimiento(
      `Ataque especial! Dano ao monstro: ${danoMonstro}`,
      `Contraataque do monstro: ${danoXogador}`
    );

    actualizarBarras();
    document.getElementById("especial").classList.add("disabled");
    finalizarTurno();
  } else {
    document.getElementById("especial").classList.add("disabled");
  }
}

function curacion() {
  let recuperacion = getRandomIntInclusive(8, 20);
  let danoXogador = getRandomIntInclusive(8, 15);
  vidaXogador += recuperacion - danoXogador;
  if (vidaXogador > 100) vidaXogador = 100;

  rexistrarMovimiento(
    `Recuperouse ${recuperacion} puntos de vida`,
    `O monstro atacoulle con ${danoXogador}`
  );

  actualizarBarras();
  finalizarTurno();
}

function renderse() {
  rendicion = true;
  vidaXogador = 0;
  finalizarXogo("Perdiches!");
}

function finalizarTurno() {
  if (vidaMonstro <= 0 && vidaXogador <= 0) finalizarXogo("Empate!");
  else if (vidaMonstro <= 0) finalizarXogo("Ganaches!");
  else if (vidaXogador <= 0) finalizarXogo("Perdiches!");

  actualizarBarras();
  contadorEspecial++;
  if (contadorEspecial % 3 === 0) {
    document.getElementById("especial").classList.remove("disabled");
  }
}

function finalizarXogo(mensaje) {
  document.getElementById("controls").remove();
  document.getElementById("log").remove();

  const finalSection = document.getElementById("finalSection");
  finalSection.style.display = "block";
  document.getElementById("resultadoFinal").textContent = mensaje;

  const volumen = vidaXogador > 0 ? vidaXogador : 0;
  const mensajeVolumen = document.createElement("h1");
  mensajeVolumen.id = "mensajeVolumen";
  mensajeVolumen.textContent =
    volumen > 0
      ? `O novo volumen será de ${volumen}, a túa vida restante`
      : "Perdeches, non podes ter volumen";

  finalSection.appendChild(mensajeVolumen);
}

function reinicio() {
  location.reload();
}

function getRandomIntInclusive(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}
