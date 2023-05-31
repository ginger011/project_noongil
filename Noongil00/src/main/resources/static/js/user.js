var settingsLinks = document.getElementsByClassName('settings-link');

for (var i = 0; i < settingsLinks.length; i++) {
    settingsLinks[i].addEventListener('click', function (event) {
        event.preventDefault(); // 기본 링크 동작을 중단합니다.

        var tr = this.closest('tr');
        var tds = tr.querySelectorAll('td');

        var userInfo = {
            userID: '',
            userName: '',
            userBirth: '',
            userTel: '',
            userAddress: ''
        };

        for (var j = 0; j < tds.length; j++) {
            var td = tds[j];
            var span = td.querySelector('span');

            if (j === 0) {
                userInfo.userID = span.textContent;
            } else if (j === 1) {
                userInfo.userName = span.textContent;
            } else if (j === 2) {
                userInfo.userBirth = span.textContent;
            } else if (j === 3) {
                userInfo.userTel = span.textContent;
            } else if (j === 4) {
                userInfo.userAddress = span.textContent;
            }
        }

        var row = tr.parentNode.children;
        var index = Array.prototype.indexOf.call(row, tr);
        var settingsIndex = index + 1;

        console.log('선택한 settings의 인덱스는 ' + settingsIndex + '입니다.');
        console.log(userInfo);

        var loginDiv = document.querySelector('.change');
        var inputElements = loginDiv.getElementsByTagName('input');

        if (inputElements.length === 4) {
            inputElements[0].value = userInfo.userName;
            inputElements[1].value = userInfo.userBirth;
            inputElements[2].value = userInfo.userTel;
            inputElements[3].value = userInfo.userAddress;
        }

        loginDiv.style.display = 'block';
    });
}

document.querySelector('.change button:last-child').addEventListener('click', function (event) {
    var loginDiv = document.querySelector('.change');
    loginDiv.style.display = 'none';
});
