var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(loadBoard["blockXcoordinate"],
			loadBoard["blockYCoordinate"]), // 지도의 중심좌표
		level: 4
		// 지도의 확대 레벨
	};

var map = new kakao.maps.Map(mapContainer, mapOption);

var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	imageOption = {
		offset: new kakao.maps.Point(27, 69)
	}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
	imageOption)
var markerPosition = new kakao.maps.LatLng(
	loadBoard["blockXcoordinate"], loadBoard["blockYCoordinate"]); // 마커가 표시될 위치입니다
console.log("마커포지션" + markerPosition.toString())
// 마커정보를 불러와 갯수를 추출

var result2 = [];
const result = Object.values(loadBoard)
const resultLength = Object.keys(loadBoard).length;
for (let i = 0; i < resultLength; i++) {
	result2[i] = result[i];

}

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
	position: markerPosition,
	image: markerImage
	// 마커이미지 설정 
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

loadBoard();

var boardData;

function loadBoard() {
	$.ajax({
		url: "api/board/",
		type: "get",
		dataType: "json",
		success: function (data) {
			// console.log(data);
			boardData = data;
			var mapContainer = document.getElementById('map');
			var mapOption = {
				center: new kakao.maps.LatLng(data[0].blockXCoordinate, data[0].blockYCoordinate),
				level: 4
			};
			map = new kakao.maps.Map(mapContainer, mapOption);

			for (var i = 0; i < data.length; i++) {
				var markerPosition = new kakao.maps.LatLng(data[i].blockXCoordinate, data[i].blockYCoordinate);
				var marker = new kakao.maps.Marker({
					map: map,
					position: markerPosition,
					title: data[i].title,
					image: markerImage
				});

				var content = '<div class="customoverlay">' +
  '  <a href="javascript:custom(\'' + boardData[i].blockPlace + '\')">' +
  '    <span class="title">' + boardData[i].blockPlace + '</span>' +
  '  </a>' +
  '</div>';





				var customOverlay = new kakao.maps.CustomOverlay({
					position: markerPosition,
					content: content,
					yAnchor: 1
				});
				customOverlay.setMap(map);
			}
		},
		error: function () {
			alert("실패!");
		}
	});
}

function custom(name) {
	console.log('json',boardData);
	console.log(name);
	var result = '<div style="background-color: gray">';
	// 해당 점자블록의 이름
	result += '<span>' + name + '</span>';
	// 열선 스위치
	result += '<div class="form-check form-switch">';
	result += '<input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" checked>';
	result += '<label class="form-check-label" for="flexSwitchCheckChecked">열선</label>';
	result += '</div>';
	result += '</div>';
	console.log(result);

	var parentElement = document.body;
	parentElement.innerHTML += result;
}
