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
	var cost = " "+results[i].cost;
	var len = " "+results[i].length;
	var url = results[i].url;
	
	var otago = '<img src="./assets/university-of-otago-kiwizone-header.jpg" alt="33" style="width:200px;height:80px;">';
	var yoobee = '<img src="./assets/1950863_1_Listing_v2.jpg" alt="33" style="width:200px;height:80px;">';
	
	var img; 
	var loc;
	if(inst === "Yoobee Polytech"){
		img = yoobee;
		loc = 'Wellington';
	}
	else{
		img = otago;
		loc = 'Otago';
	}
	
    uniResults.innerHTML += '<div class="card">'+
                                  '<h4>'+inst+'</h4>'+
								  '<img src="./assets/33.png" alt="33" style="width:40px;height:40px;">'+
								  '<h5'+loc+'</h5>'+
								  '<h5>'+qual+'</h5>'+
								  '<div class="info"><img src="./assets/clock.png" alt="33" class="info-img" >'+
								  '<h4 class="info-length">'+len+' months</h4></div>'+
								  '<div class="info"><img src="./assets/dollar-black-circle-icon-28.png" alt="33" class="info-img" >'+
								  '<h4 class="info-length">$'+cost+'</h4></div>'+
								  img+
								  '<a href="'+url+'" class="btn btn-default" target="_blank">Visit</a> ' +
                                  
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