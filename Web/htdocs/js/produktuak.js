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
    })
    .catch(err => console.error("Errorea kargatzerakoan:", err));

function produktuakErakutsi(zerrenda) {
    const lista = document.getElementById("lista");
    if (!lista) return;
    lista.innerHTML = "";
    zerrenda.forEach(p => {
        // Usamos exactamente tu estructura HTML original para que tu CSS funcione
        lista.innerHTML += `
            <div class="produktu-txartela">
                <img src="${p.image}" alt="${p.title}">
                <h3>${p.title}</h3>
                <p>${p.price}€</p>
                <button onclick="erosi(${p.id})">Erosi</button>
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

function erosi(id) {
    const p = produktuak.find(prod => prod.id === id);
    if (!p) return;

    const saskiaGakoa = "saskia-artikuluak";
    let saskia = JSON.parse(localStorage.getItem(saskiaGakoa)) || [];
    const index = saskia.findIndex(artikulua => artikulua.id === p.id);

    if (index === -1) {
        saskia.push({ ...p, kantitatea: 1 });
    } else {
        saskia[index].kantitatea++;
    }

    localStorage.setItem(saskiaGakoa, JSON.stringify(saskia));
    alert(`${p.title} saskira gehitu da!`);
}
