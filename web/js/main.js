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

  for(var i = 0; i < results.length; i++){
    var qual = results[i].qualification;
    var inst = results[i].institution;
	var desc = results[i].description;

    uniResults.innerHTML += '<div class="card">'+
                                  '<h4>'+qual+'</h4>'+
								  '<h4>'+inst+'</h4>'+
								  '<p>'+desc+'</p>'+
								  ' <a class="btn btn-default" target="_blank">Visit</a> ' +
                                  
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