const saskiaGakoa = "saskia-artikuluak";
let produktuGuztiak = [];

/** Produktu guztiak erakusten ditu orrian */
async function loadDoc() {
    let response = await fetch("https://fakestoreapi.com/products");
    produktuGuztiak = await response.json();

    let lista = document.getElementById("lista");
    produktuGuztiak.forEach(produktu => {
        lista.innerHTML += `
            <div>
                <h3>${produktu.title}</h3>
                <img src="${produktu.image}" width="100">
                <p>${produktu.price}€</p>
                <button onclick="erosi(${produktu.id})">Erosi</button>
            </div>
            <hr>
        `;
    });
}

loadDoc();

/** Produktu bat erosten du (ID bidez bilatu eta saskira gehitu) */
function erosi(id) {
    const produktua = produktuGuztiak.find(p => p.id === id);
    if (produktua) {
        saskiariGehitu(produktua);
    }
}

/** Produktu bat saskiari gehitzen du */
function saskiariGehitu(p) {
    let saskia = JSON.parse(localStorage.getItem(saskiaGakoa)) || [];
    const index = saskia.findIndex(produktu => produktu.id === p.id);

    if (index === -1) {
        saskia.push({ ...p, kantitatea: 1 });
    } else {
        saskia[index].kantitatea++;
    }

    localStorage.setItem(saskiaGakoa, JSON.stringify(saskia));
    console.log(`${p.title} saskira gehitu da.`);
}
