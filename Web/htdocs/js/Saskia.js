const saskiEdukiontzia = document.getElementById("cart-container");
const kopuruElementua = document.getElementById("kantitatea");
const prezioElementua = document.getElementById("prezioa");
const saskiaHutsikMezua = document.getElementById("saskia-hutsa");
const guztiraEdukiontzia = document.getElementById("totalak");

const saskiaGakoa = "saskia-artikuluak";

function saskikoTxartelakSortu() {
    saskiEdukiontzia.innerHTML = "";
    const produktuak = JSON.parse(localStorage.getItem(saskiaGakoa));

    if (produktuak && produktuak.length > 0) {
        produktuak.forEach((p) => {
            const txartela = document.createElement("div");
            txartela.classList = "produktu-txartela";
            txartela.innerHTML = `
                <img src="${p.image}">
                <div class="produktu-info">
                    <div class="info-row">
                        <span class="label">Prezioa</span>
                        <span class="balioa">${p.price}€</span>
                    </div>
                    <div class="info-row">
                        <span class="label">Kantitatea</span>
                        <div class="kantitate-hautatzailea">
                            <button class="minus">-</button>
                            <span class="kopuru">${p.kantitatea}</span>
                            <button class="plus">+</button>
                        </div>
                    </div>
                </div>`;
            saskiEdukiontzia.appendChild(txartela);

            txartela.querySelector(".minus").addEventListener("click", () => {
                saskitikKendu(p);
                saskikoTxartelakSortu();
            });

            txartela.querySelector(".plus").addEventListener("click", () => {
                saskiariGehitu(p);
                saskikoTxartelakSortu();
            });
        });
    }
    egoeraEgiaztatu();
    guztiraEguneratu();
}

function guztiraEguneratu() {
    const produktuak = JSON.parse(localStorage.getItem(saskiaGakoa));
    let kopurua = 0;
    let prezioa = 0;
    if (produktuak) {
        produktuak.forEach(p => {
            kopurua += p.kantitatea;
            prezioa += p.price * p.kantitatea;
        });
    }
    if (kopuruElementua) kopuruElementua.innerText = kopurua;
    if (prezioElementua) prezioElementua.innerText = prezioa.toFixed(2);
}

function egoeraEgiaztatu() {
    const produktuak = JSON.parse(localStorage.getItem(saskiaGakoa));
    const badagoZerbait = produktuak && produktuak.length > 0;
    saskiaHutsikMezua.classList.toggle("ezkutuan", badagoZerbait);
    guztiraEdukiontzia.classList.toggle("ezkutuan", !badagoZerbait);
}

function saskiariGehitu(p) {
    let saskia = JSON.parse(localStorage.getItem(saskiaGakoa)) || [];
    const index = saskia.findIndex(artikulua => artikulua.id === p.id);
    if (index === -1) {
        saskia.push({ ...p, kantitatea: 1 });
    } else {
        saskia[index].kantitatea++;
    }
    localStorage.setItem(saskiaGakoa, JSON.stringify(saskia));
}

function saskitikKendu(p) {
    let saskia = JSON.parse(localStorage.getItem(saskiaGakoa));
    const index = saskia.findIndex(artikulua => artikulua.id === p.id);
    if (saskia[index].kantitatea > 1) {
        saskia[index].kantitatea--;
    } else {
        saskia.splice(index, 1);
    }
    localStorage.setItem(saskiaGakoa, JSON.stringify(saskia));
}

document.getElementById("reiniciar").addEventListener("click", () => {
    localStorage.removeItem(saskiaGakoa);
    saskikoTxartelakSortu();
});

document.getElementById("erosi").addEventListener("click", () => {
    alert("Erosketa egin duzu! Eskerrik asko!");
    localStorage.removeItem(saskiaGakoa);
    saskikoTxartelakSortu();
});

saskikoTxartelakSortu();
