loadBoard();

var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png'; // 마커이미지의 주소입니다    
var imageSize = new kakao.maps.Size(64, 69); // 마커이미지의 크기입니다
var imageOption = {
	offset: new kakao.maps.Point(27, 69) // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
};

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);

// Json데이터가 담기는 boardData
var boardData;
// 여러개의 overlay를 담는 배열
var customOverlay = [];
// 여러개의 마커를 담는 배열
var marker = [];

function loadBoard() {
	$.ajax({
		url: "api/board/",
		type: "get",
		dataType: "json",
		success: function (data) {
			boardData = data;

			var mapContainer = document.getElementById('map');
			var mapOption = {
				center: new kakao.maps.LatLng(data[0].blockXCoordinate, data[0].blockYCoordinate),
				level: 5
			};
			map = new kakao.maps.Map(mapContainer, mapOption);

			for (var i = 0; i < data.length; i++) {
				console.log(data[i]);
				var markerPosition = new kakao.maps.LatLng(data[i].blockXCoordinate, data[i].blockYCoordinate);
				marker[i] = new kakao.maps.Marker({
					map: map,
					position: markerPosition,
					title: data[i].title,
					image: markerImage
				});

				var content = '<div class="customoverlay">' +
					'  <a href="javascript:custom(\'' + i + '\')">' +
					'    <span class="title">' + data[i].blockPlace + '</span>' +
					'  </a>' +
					'<p>' + data[i].blockID + '</p>' +
					'<p>' + data[i].blockAddress + '</p>' +
					'<div class="form-check form-switch">' +
					'<input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked' + i + '" checked>' +
					'<label class="form-check-label" for="flexSwitchCheckChecked' + i + '">열선</label>' +
					'</div>' +
					'</div>';

				customOverlay[i] = new kakao.maps.CustomOverlay({
					position: markerPosition,
					content: content,
					yAnchor: 1
				});
				customOverlay[i].setMap(map);

				// 스위치 버튼 요소 가져오기
				var switchElement = document.getElementById('flexSwitchCheckChecked' + i);

				// 스위치 버튼 변경 이벤트 리스너 추가
				if (switchElement) {
					switchElement.addEventListener('change', (function (index) {
						return function () {
							if (this.checked) {
								// 스위치가 켜진 상태일 때의 동작
								console.log('스위치 ' + index + '가 켜짐');
								// 여기에 해당 스위치가 켜졌을 때 수행할 기능 추가
								// 예: switchOnFunction(index);
							} else {
								// 스위치가 꺼진 상태일 때의 동작
								console.log('스위치 ' + index + '가 꺼짐');
								// 여기에 해당 스위치가 꺼졌을 때 수행할 기능 추가
								// 예: switchOffFunction(index);
							}
						}
					})(i));
				}

				kakao.maps.event.addListener(marker[i], 'click', (function (markerIndex) {
					return function () {
						toggleOverlay(markerIndex);
					};
				})(i));
			}
		},
		error: function () {
			alert("실패!");
		}
	});
}

function custom(num) {
	customOverlay[num].setMap(null);
}

function toggleOverlay(markerIndex) {
	if (customOverlay[markerIndex].getMap()) {
		customOverlay[markerIndex].setMap(null);
	} else {
		customOverlay[markerIndex].setMap(map);
	}
}

