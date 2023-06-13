const slidePicture = document.getElementById('threebox-1').getElementsByTagName('img');

const imgURL = [
    './img/점자블록사진.png',
    './img/지팡이사진.png'
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
