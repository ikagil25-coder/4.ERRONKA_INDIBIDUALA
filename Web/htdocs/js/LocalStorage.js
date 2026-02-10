const produktuEdukiontzia = document.getElementById("produktu-zerrenda");
const saskiaGakoa = "saskia-artikuluak";

/** Produktu guztiak erakusten ditu orrian */
function produktuakErakutsi() {
    produktuEdukiontzia.innerHTML = "";
    produktuak.forEach((p) => {
        const txartela = document.createElement("div");
        txartela.classList = "produktu-txartela";
        txartela.innerHTML = `
            <img src="${p.irudia}" alt="${p.izena}">
            <h3>${p.izena}</h3>
            <span>${p.prezioa}€</span>
            <button class="gehitu">Saskira gehitu</button>`
            ;
        produktuEdukiontzia.appendChild(txartela);

        txartela.querySelector(".gehitu").addEventListener("click", () => {
            saskiariGehitu(p);
        });
    });
}

/** Produktu bat saskiari gehitzen du */
function saskiariGehitu(p) {
    let saskia = JSON.parse(localStorage.getItem(saskiaGakoa)) || [];
    const index = saskia.findIndex(artikulua => artikulua.id === p.id);

    if (index === -1) {
        saskia.push({ ...p, kantitatea: 1 });
    } else {
        saskia[index].kantitatea++;
    }

    localStorage.setItem(saskiaGakoa, JSON.stringify(saskia));
    console.log(`${p.izena} saskira gehitu da.`);
}
produktuakErakutsi();
