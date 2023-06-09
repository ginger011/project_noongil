const slidePicture = document.getElementById('threebox-1').getElementsByTagName('img');

const imgURL = [
    'https://cdn.imweb.me/upload/S202207202685e30f16e24/d0812bfa4755e.jpg',
    'https://cdn.imweb.me/upload/S202207202685e30f16e24/8b48c67f8cdf6.jpeg'
];

let currentIndex = 0;

setInterval(function () {
    slidePicture[0].src = imgURL[currentIndex];
    currentIndex = (currentIndex + 1) % imgURL.length;
    if (currentIndex >= imgURL.length) {
        currentIndex = 0;
    }
}, 3000);
