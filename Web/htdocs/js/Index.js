let slideActual = 0;

function cambiarSlide(n) {
    const slides = document.querySelectorAll('.slide');

    slides[slideActual].classList.remove('active');

    slideActual += n;

    if (slideActual >= slides.length) {
        slideActual = 0;
    }
    if (slideActual < 0) {
        slideActual = slides.length - 1;
    }

    slides[slideActual].classList.add('active');
}