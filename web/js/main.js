function queryBackend(query){
  var httpGet;

  function retrieveUnifyJSON(){
    httpGet = new XMLHttpRequest();

    httpGet.onreadystatechange = loadJSON;
    httpGet.open('GET', 'http://127.0.0.1:8000/?search='+query);
    httpGet.send();
  }

  function loadJSON(){
    //var queryJSON = JSON.parse(httpGet.responseText);
    var queryJSON = [
    {
        "qualification" : "Applied Science",
        "institution" : "Otago University",
        "description" : " The University of Otago's Applied Science programme combines the excitement of science and technology with the challenges of business. It is an innovative programme for high-achieving students offering an undergraduate honours degree and masters programmes. Applied Science helps students prepare for careers in growth areas like information and communication technology and biotechnology."
    }, { 
        "qualification" : "Clothing and Textile Sciences",
        "institution" : "Otago University",
        "description" : " Clothing and many materials such as textiles and leather meet basic human needs, and are essential to performance, feelings of well-being in both the physical sense (e.g. for protection and warmth) and the social sense (e.g. belonging to a group). Clothing plays an important role in non-verbal communication indicating many personal and social characteristics of the wearer. Clothing and textile production and distribution are significant to the New Zealand and world economy, and clothing and textiles are one of the few product groups subject to control in international trade."
    }, {
        "qualification" : "Computer and Information Science", "institution" : "Otago University", "description" : " Computer and Information Science includes the 100-level papers for both Information Science and Computer Science." }, { "qualification" : "Computer Science", "institution" : "Otago University", "description" : " Computer Science is the study of computers and the work they do. We need a science of computers because, unlike other machines, computers are general purpose; the same machine can perform many different tasks and the same tasks can be done equally well by different computers." }, { "qualification" : "Earth and Ocean Science", "institution" : "Otago University", "description" : " EAOS 111 Earth and Ocean Science, looks at the evolution of continents and oceans; sea-floor spreading, mountain ranges, plate tectonics; oceanic circulation and global cycles; erosion, landslides and sedimentation on land and sea; marine biological systems, evolution of life through the ages; oceans and climate; the Solar System." }, { "qualification" : "Environmental Science", "institution" : "Otago University", "description" : " Environmental Science focuses on understanding how the environment works, so that environmental damage can be minimised, or repaired." }, { "qualification" : "Food Science", "institution" : "Otago University", "description" : " Understanding food, its components, quality and consumer appeal are the ingredients of Food Science. At the University of Otago, Food Science papers aim to prepare people for creative, challenging, diverse and rewarding food industry careers." }, { "qualification" : "Health Sciences", "institution" : "Otago University", "description" : " A wide range of postgraduate courses in specialist areas of Health Sciences is available including a Master of Health Sciences (MHealSc) degree." }];
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