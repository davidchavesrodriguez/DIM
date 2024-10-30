let contentFrame = document.getElementById("contentFrame");
let logo = document.getElementById("logo");
let linkCarta = document.getElementById("linkCarta");
let linkConocenos = document.getElementById("linkConocenos");
let linkContacto = document.getElementById("linkContacto");

logo.addEventListener("click", () => {
  contentFrame.src = "principal.html";
});

linkCarta.addEventListener("click", () => {
  contentFrame.src = "carta.html";
});

linkConocenos.addEventListener("click", () => {
  contentFrame.src = "conocenos.html";
});

linkContacto.addEventListener("click", () => {
  contentFrame.src = "contacto.html";
});
