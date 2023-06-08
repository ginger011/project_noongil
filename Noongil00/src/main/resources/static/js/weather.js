var weather = "https://api.openweathermap.org/data/2.5/weather?q=Gwangju&appid=52c56f22bdc07f2997d33564e83efc09&units=metric";
$.ajax({
    url: weather,
    dataType: "json",
    type: "GET",
    success: function (data) {
        // data['weather'][0]['main']  이 Snow일 때 눈 오는 날씨임
        console.log(data['weather'][0]['main']);

        var weatherImg = document.createElement("img");
        weatherImg.src = 'https://openweathermap.org/img/wn/'+data['weather'][0]['icon']+'@2x.png';
        
        var weatherIconElement = document.querySelector(".weather-icon");
        weatherIconElement.innerHTML = "";
        weatherIconElement.appendChild(weatherImg);

        var temperatureElement = document.getElementById("temperature");
        temperatureElement.textContent = data['main']['temp'] + '°C';

        var weatherInfoElement = document.getElementById("weatherInfo");
        weatherInfoElement.textContent = data['weather'][0]['description'] + " ";

        var windElement = document.getElementById("windSpeed");
        windElement.textContent = 'Wind '+ data['wind']['speed'] + 'm/s';
    }
});
