function balidatu() {
    const emailInput = document.getElementById("emaila").value;
    const passwordInput = document.getElementById("pasahitza").value;

    const garbiMsg = document.getElementById("garbi");
    const erroreaMsg = document.getElementById("errorea");

    garbiMsg.classList.add("ezkutuan");
    erroreaMsg.classList.add("ezkutuan");

    if (emailInput === "IndiUsurbil@admin.com" && passwordInput === "Admin") {
        garbiMsg.classList.remove("ezkutuan");
    } else {
        erroreaMsg.classList.remove("ezkutuan");
    }
}
