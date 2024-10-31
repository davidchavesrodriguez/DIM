// Función para cargar el menú desde el archivo JSON
async function loadMenu() {
  try {
    const response = await fetch("menu.json");
    if (!response.ok) {
      throw new Error("Network response was not ok");
    }

    const data = await response.json();
    const menuContainer = document.getElementById("menu");

    // Sección de Aperitivos
    const appetizersSection = document.createElement("div");
    appetizersSection.classList.add("menu-section", "menu-appetizers");
    const appetizersHeader = document.createElement("h1");
    appetizersHeader.innerText = "Aperitivos";
    appetizersSection.appendChild(appetizersHeader);

    data.menu.appetizers.forEach((item) => {
      const appetizerDiv = document.createElement("div");
      appetizerDiv.classList.add("product", "appetizer");
      appetizerDiv.innerHTML = `
            <h2>${item.name}</h2>
            <img src="${item.image}" alt="${item.name}" />
            <p>${item.description}</p>
            <p class="price">$${item.price.toFixed(2)}</p>
          `;
      appetizersSection.appendChild(appetizerDiv);
    });
    menuContainer.appendChild(appetizersSection);

    // Sección de Platos Principales
    const mainSection = document.createElement("div");
    mainSection.classList.add("menu-section", "menu-main");
    const mainHeader = document.createElement("h1");
    mainHeader.innerText = "Platos Principales";
    mainSection.appendChild(mainHeader);

    data.menu.main.forEach((item) => {
      const mainDiv = document.createElement("div");
      mainDiv.classList.add("product", "main");
      mainDiv.innerHTML = `
            <h2>${item.name}</h2>
            <img src="${item.image}" alt="${item.name}" />
            <p>${item.description}</p>
            <p class="price">$${item.price.toFixed(2)}</p>
          `;
      mainSection.appendChild(mainDiv);
    });
    menuContainer.appendChild(mainSection);

    // Sección de Postres
    const dessertsSection = document.createElement("div");
    dessertsSection.classList.add("menu-section", "menu-desserts");
    const dessertsHeader = document.createElement("h1");
    dessertsHeader.innerText = "Postres";
    dessertsSection.appendChild(dessertsHeader);

    data.menu.desserts.forEach((item) => {
      const dessertDiv = document.createElement("div");
      dessertDiv.classList.add("product", "dessert");
      dessertDiv.innerHTML = `
            <h2>${item.name}</h2>
            <img src="${item.image}" alt="${item.name}" />
            <p>${item.description}</p>
            <p class="price">$${item.price.toFixed(2)}</p>
          `;
      dessertsSection.appendChild(dessertDiv);
    });
    menuContainer.appendChild(dessertsSection);
  } catch (error) {
    console.error("Error al cargar el menú:", error);
    const menuContainer = document.getElementById("menu");
    menuContainer.innerHTML = "<p>Hubo un error al cargar el menú.</p>";
  }
}

loadMenu();
