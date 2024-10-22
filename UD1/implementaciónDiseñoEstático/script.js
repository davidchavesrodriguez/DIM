let detailButtons = document.getElementsByClassName("details-button");

for (const button of detailButtons) {
  button.addEventListener("click", function () {
    window.location.href = "product.html";
  });
}
