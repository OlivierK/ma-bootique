/**
 * 
 */
var xhr_object = false;
var position = false;
var position_post = false;

 function envoieRequete(url,id)
{ 	xhr_object = false;
     	position = id;

	/*@cc_on @*/
	/*@if (@_jscript_version >= 5)
	// JScript gives us Conditional compilation, we can cope with old IE versions.
	// and security blocked creation of the objects.
	try {
	xhr_object = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
	try {
	xhr_object = new ActiveXObject("Microsoft.XMLHTTP");
	} catch (E) {
	xhr_object = false;
	}
	}
	@end @*/
	if (!xhr_object && typeof XMLHttpRequest != 'undefined') {
		try {
			xhr_object = new XMLHttpRequest();
		} catch (e) {
			xhr_object = false;
		}
	}

	if (!xhr_object) {
            alert('Abandon :( Impossible de crÃ©er une instance XMLHTTP');
            //return false;
    	}
    	xhr_object.onreadystatechange = insert_content;
	// On ouvre la requete vers la page
	
 	xhr_object.open("GET", url, true);
 	// dans le cas du get
 	
 	xhr_object.send(null);
 	//xhr_object.send('');
}

	function insert_content(){
 		if ( xhr_object.readyState == 4 && xhr_object.status == 200 )
 		{
			// j'affiche dans la DIV  le contenu retourne par le fichier
			
			document.getElementById(position).innerHTML = xhr_object.responseText;
 		}
 	}
 var http_request = false;
 
 function makePOSTRequest(url, id, parameters) {
      http_request = false;
	position_post = id;

      if (window.XMLHttpRequest) { // Mozilla, Safari,...
         http_request = new XMLHttpRequest();
         if (http_request.overrideMimeType) {
         	// set type accordingly to anticipated content type
            http_request.overrideMimeType('text/html');
         }
      } else if (window.ActiveXObject) { // IE
         try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
         } catch (e) {
            try {
               http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
         }
      }
      if (!http_request) {
         alert('Cannot create XMLHTTP instance');
         return false;
      }
      http_request.onreadystatechange = insert_content_post;
	http_request.open('POST', url, true);
      http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      http_request.setRequestHeader("Content-length", parameters.length);
      http_request.setRequestHeader("Connection", "close");
      http_request.send(parameters);
   }

   function insert_content_post() {
      if (http_request.readyState == 4) {
         if (http_request.status == 200) {
            result = http_request.responseText;
            document.getElementById(position_post).innerHTML = unescape(result);
         } else {
            alert('There was a problem with the request.');
         }
      }
   }
   function alertContents_msg() {
      if (http_request.readyState == 4) {
         if (http_request.status == 200) {
            //alert(http_request.responseText);
            result = http_request.responseText;
            document.getElementById('messagepersoContenu').innerHTML = unescape(result);   
         } else {
            alert('There was a problem with the request.');
         }
      }
   }
   function submit_form1(url, id) {
      var poststr = "coffret=" + escape(encodeURI( document.getElementById("coffret").value )) +
                    "&message=" + escape(encodeURI( document.getElementById("msg").value )) +
                    "&mode="+escape(encodeURI("SAVE"));
      makePOSTRequest(url, id, poststr);
   }