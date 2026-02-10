function menua() {
    const menu = document.getElementById('menu-hamburguesa');
    const icon = document.getElementById('menu-toggle');
    if (menu.style.display === 'flex' || menu.style.display === 'block') {
        menu.style.display = 'none';
        icon.innerText = 'menu';
    } else {
        menu.style.display = 'flex';
        icon.innerText = 'X';
    }
}
