function queryBackend(query){
  var httpGet;

  function retrieveUnifyJSON(){
    httpGet = new XMLHttpRequest();

    httpGet.onreadystatechange = loadJSON;
    httpGet.open('GET', 'http://127.0.0.1:8000/?search='+query);
    httpGet.send();
  }

  function loadJSON(){
    var queryJSON = JSON.parse(httpGet.responseText);
    renderResults(queryJSON);
  }

  retrieveUnifyJSON();
}

function renderResults(results){
  console.log(results);

  var uniResults = document.getElementById('results');

  uniResults.innerHTML = '';

  for(var i = 0; i < 3; i++){
    var qual = results[i].qualification;
    var inst = results[i].institution;
	var cost = results[i].cost;
	var len = results[i].length;
	
    uniResults.innerHTML += '<div class="card">'+
                                  '<h4>'+inst+'</h4>'+
								  '<img src="./assets/33.png" alt="33" style="width:40px;height:40px;">'+

								  '<h4>'+qual+'</h4>'+
								  '<div><img src="./assets/clock.png" alt="33" style="width:40px;height:40px;">'+
								  '<h4>'+len+' months</h4></div>'+
								  '<img src="./assets/dollar-black-circle-icon-28.png" alt="33" style="width:25px;height:25px;">'+
								  '<h4>$'+cost+'</h4>'+
								  '<img src="./assets/university-of-otago-kiwizone-header.jpg" alt="33" style="width:200px;height:60px;">'+
								  '<a class="btn btn-default" target="_blank">Visit</a> ' +
                                  
                                  '</div>';
  }
}

function getParameterByName(name, url) {
  if (!url) url = window.location.href;
  name = name.replace(/[\[\]]/g, "\\$&");
  var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
      results = regex.exec(url);
  if (!results) return null;
  if (!results[2]) return '';
  return decodeURIComponent(results[2].replace(/\+/g, " "));
}