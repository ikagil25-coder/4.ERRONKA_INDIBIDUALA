let produktuak = [];

const kategoriaMap = {
    "guztiak": "guztiak",
    "prakak": "1",
    "kamisetak": "2",
    "alkandorak": "3",
    "sudaderak": "4",
    "jakak": "5"
};

fetch("./produktuak.json")
    .then(res => res.json())
    .then(data => {
        produktuak = data;
        produktuakErakutsi(produktuak);
    });

function produktuakErakutsi(zerrenda) {
    const lista = document.getElementById("lista");
    lista.innerHTML = "";
    zerrenda.forEach(p => {
        lista.innerHTML += `
            <div class="produktua">
                <img src="${p.image}" alt="${p.title}">
                <h3>${p.title}</h3>
                <p>${p.price}€</p>
            </div>
        `;
    });
}

function filtratu(kategoria) {
    if (kategoria === "guztiak") {
        produktuakErakutsi(produktuak);
    } else {
        const benetakoKat = kategoriaMap[kategoria] || kategoria;
        const iragaziak = produktuak.filter(p => p.category === benetakoKat);
        produktuakErakutsi(iragaziak);
    }
}
