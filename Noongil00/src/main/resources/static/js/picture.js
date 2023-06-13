const slidePicture = document.getElementById('threebox-1').getElementsByTagName('img');

const imgURL = [
    'https://cdn.imweb.me/upload/S202207202685e30f16e24/d0812bfa4755e.jpg',
    'https://cdn.imweb.me/upload/S202207202685e30f16e24/8b48c67f8cdf6.jpeg'
];
// 첫번째는 html의 src로 한번 보여주기때문에 2번째부터 시작한다.
let currentIndex = 1;

setInterval(function () {
    slidePicture[0].src = imgURL[currentIndex];
    currentIndex = (currentIndex + 1) % imgURL.length;
    if (currentIndex >= imgURL.length) {
        currentIndex = 0;
    }
}, 3000);
