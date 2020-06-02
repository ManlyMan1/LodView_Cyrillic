<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://www.springframework.org/tags" prefix="sp"%><%@page session="true"%>
<link href="${conf.getStaticResourceURL()}style.css" rel="stylesheet" type="text/css" />
<script>
	document.write('<style type="text/css">');
	document.write('.c2{visibility:hidden}');
	document.write('</style>');
</script>
<meta http-equiv="x-ua-compatible" content="IE=Edge"/>
<script src="${conf.getStaticResourceURL()}vendor/jquery.min.js"></script>
<meta property="og:title" content="${results.getTitle()} &mdash; LodView, giving data a new shape">
<meta property="og:image" content="${conf.getStaticResourceURL()}img/lodview_sharer.png">
<link rel="image_src" href="${conf.getStaticResourceURL()}img/lodview_sharer.png">
<meta name="twitter:title" content="${results.getTitle()} &mdash; LodView, giving data a new shape">
<meta name="twitter:description" content="LodView is a powerful RDF viewer, IRI dereferencer and opensource SPARQL navigator">
<link rel="icon" type="image/png" href="${conf.getStaticResourceURL()}img/favicon.png">
<link href='//fonts.googleapis.com/css?family=Roboto:100,300,500&subset=latin-ext,latin,greek-ext,greek,cyrillic-ext,vietnamese,cyrillic' rel='stylesheet' type='text/css'>
<!-- managing maps  -->
<link rel="stylesheet" href="${conf.getStaticResourceURL()}vendor/leaflet/leaflet.css" />
<script src="${conf.getStaticResourceURL()}vendor/leaflet/leaflet.js"></script>
<link rel="canonical" href="${results.getMainIRI()}" >
<script src="${conf.getStaticResourceURL()}vendor/masonry.pkgd.min.js"></script>
<script src="${conf.getStaticResourceURL()}vendor/modernizr-custom.min.js"></script>
<c:set var="color1" value='${colorPair.replaceAll("-.+","") }' scope="page" />
<c:set var="color2" value='${colorPair.replaceAll(".+-","") }' scope="page" />
<style type="text/css">
hgroup, #linking a span,#audio .audio{
	background-color: ${color1
}

}
header div#abstract, #loadPanel, div#lodCloud .connected div#counterBlock.content
	{
	background-color: ${color2
}

}
#errorPage div#bnodes {
	color: ${color2
}

}
div#loadPanel span.ok img {
	background-color: ${color1
}
}
</style>
<script>
	var isRetina = window.devicePixelRatio > 1;
	var isChrome = /chrom(e|ium)/.test(navigator.userAgent.toLowerCase())
</script>
<c:set var="hasMap" scope="page" value='${results.getLatitude()!=null && !results.getLatitude().equals("") && results.getLongitude()!=null&&!results.getLongitude().equals("")}'></c:set>
<c:set var="hasLod" scope="page" value="${results.getLinking()!=null && results.getLinking().size()>0}"></c:set>
<c:set var="hasImages" scope="page" value="${results.getImages()!=null && results.getImages().size()>0}"></c:set>
<c:set var="hasVideos" scope="page" value="${results.getVideos()!=null && results.getVideos().size()>0}"></c:set>
<c:set var="hasAudios" scope="page" value="${results.getAudios()!=null && results.getAudios().size()>0}"></c:set>
<c:if test="${hasAudios }">	 
	<link rel="stylesheet" href="${conf.getStaticResourceURL()}vendor/jplayercircle/circle.skin/circle.player.css">
	<script type="text/javascript" src="${conf.getStaticResourceURL()}vendor/jplayercircle/js/jquery.transform.js"></script>
	<script type="text/javascript" src="${conf.getStaticResourceURL()}vendor/jplayercircle/js/jquery.grab.js"></script>
	<script type="text/javascript" src="${conf.getStaticResourceURL()}vendor/jplayercircle/js/jquery.jplayer.js"></script>
	<script type="text/javascript" src="${conf.getStaticResourceURL()}vendor/jplayercircle/js/mod.csstransforms.min.js"></script>
	<script type="text/javascript" src="${conf.getStaticResourceURL()}vendor/jplayercircle/js/circle.player.js"></script>
</c:if>	
<script>

var myVar;
function iframeLeave(id)
{
	var delayInMilliseconds = 400;
	let e =document.getElementById(id);
    myVar = setTimeout(function() {e.style.display='none';},delayInMilliseconds);
}

function ChangeOver(x) {
	let e =  document.getElementById("iframe_"+x)
	if(e.style.display == 'none')
	{
		var delayInMilliseconds = 800;
	
	}
	else
	{
		var delayInMilliseconds = 400;
	}
	myVar = setTimeout(function() {



	
	if(e.style.display == 'none') {
          
		  
		  e.style.display = 'block';
		  
		  if(e.offsetWidth<600) 
		  {
			  e.style.display = 'none'; 
		  } 
		  e.height = screen.height;
		  setTimeout(function(){
		  e.scrollIntoView({behavior: "smooth"});
		  },300);
     } else if(e.style.display == 'block') {
          e.style.display = 'none';
     }
	e.src=x;
/*
	var selectedPosX = 0;
    var selectedPosY = 0;
    while (e != null) {
        selectedPosX += theElement.offsetLeft
        selectedPosY += theElement.offsetTop;
        e = e.offsetParent;
    }

    window.scrollTo(selectedPosX,selectedPosY);*/

	 }, delayInMilliseconds);
	
	// if(d.style.toString().indexOf("block") > -1)
	// {

	// }
	// 
	// if(d.style.toString().indexOf("block") > -1)
	// {
	// 	d.style="display: none;";
	// }
	// else
	// {
	// 	d.style="display: block;";
	// }
 	
};
 function ChangeLeave(x) {
	 clearTimeout(myVar);
};
</script>

<script>
window.onload = function patchDomain(x) {

var inputs = document.getElementsByTagName('iframe');
//console.log('found '+inputs.length+' iframes');

var bnodes = document.getElementsByTagName('a');
for (i in bnodes) {
        if((' ' + bnodes[i].className + ' ').indexOf(' ' + "bnode" + ' ')
                > -1) {
            bnodes[i].href=window.location.href +"#"+ bnodes[i].id;
			//console.log("changed bnode");
        }
    }
bnodes = document.getElementsByTagName('iframe');
for (i in bnodes) {
        if((' ' + bnodes[i].className + ' ').indexOf(' ' + "bnode_iframe" + ' ')
                > -1) {
            bnodes[i].src=window.location.href +"#"+ bnodes[i].id;
		//	console.log("changed bnode");
        }
    }

var As = document.getElementsByTagName('a');

var bs = document.getElementsByTagName('input');
console.log('found '+inputs.length+' buttons');
    var domain = document.location.host;
    //console.log(domain);
for(var i = 0; i < inputs.length; i++) 
{
if (typeof inputs[i].id !== 'undefined')
    if(inputs[i].id.toLowerCase().indexOf('|domain|')>-1) 
    {
     //   console.log('replace iframe')
        inputs[i].id = inputs[i].id.replace("|domain|", domain);
    }
}


for(var i = 0; i < As.length; i++) 
{
    /*if(As[i].href.toLowerCase().indexOf('|domain|')>-1)
	{
		As[i].href = As[i].href.replace("|domain|", domain);
	}*/
	
        if (typeof As[i].name !== 'undefined')
	if(As[i].name.toLowerCase().indexOf('|domain|')>-1)
	{
        As[i].name = As[i].name.replace("|domain|", domain);
	}
	/*if (As[i].id.toLowerCase().indexOf('|domain|')>-1) 
    {
		As[i].id = As[i].id.replace("|domain|", domain);	
    }*/
}

for(var i = 0; i <bs.length; i++) 
    {
        if (typeof bs[i].name !== 'undefined')
    if(bs[i].name.toLowerCase().indexOf('|domain|')>-1) 
    {
       // if(/Android|webOS|iPhone|iPad|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent))
    {
//console.log('replace a')
        bs[i].name = bs[i].name.replace("|domain|", domain);
 
    }


/*else
{
        bs[i].style.display = 'none';        
}*/
    }

    }
inputs = document.getElementsByTagName('iframe');
for(var i = 0; i < inputs.length; i++) 
{
	
if (inputs[i].id.indexOf('iframe_bnode')>-1)
    {
	//	console.log('bnode+'+inputs[i].id+'+'+inputs[i].src);
		//if(inputs[i].src.indexOf('|domain|')>-1) 
    {
        
        inputs[i].src = inputs[i].src.replace("%7Cdomain%7C", domain);
    }}
}


bnodes = document.getElementsByTagName('a');
for(var i = 0; i < bnodes.length; i++)
{
	if(bnodes[i].id.indexOf('t_')>-1)
	{
	console.log(bnodes[i].id);
	var divNodes = document.getElementsByTagName('div');

	for(var j = 0;j < divNodes.length; j++)
	{
		if(typeof divNodes[j].id !== 'undefined')
		{
			console.log(divNodes[j].id);
			if(divNodes[j].id==bnodes[i].id)
			{
			var dupNode = divNodes[j].cloneNode(true);
			bnodes[i].parentNode.appendChild(dupNode);
			break;
			}
		}
	}
	/*
	var input = document.getElementsByTagName('a');
	for(var j = 0; j< input.length; j++) 
	{
		if(input[j].href.indexOf('#'+bnodes[i].id)>-1)
		{
			var index=0;
 			var siblings =Array.from(input[j].parentNode.parentNode.childNodes);
			console.log(input[j].id);
			console.log(siblings.length);
			for (var j in siblings)
				{
						var sibArray = Array.from(siblings[j].childNodes);
						{
							console.log("childLength_"+sibArray.length);
						
						if(sibArray[0] !== undefined)
						{
							console.log(index);
							if(sibArray[0].hasOwnProperty('id'))
								{
									console.log(index);
									if(sibArray[0].id==input[j].id)
										{
											console.log(index);
											break;
										}
									else
										++index;
								}
						}
						}
					
				}
			
			var d=document.createElement('div');
			for( var k=0;k<3;k++)
			{
				sibArray = Array.from(input[j].parentNode.parentNode.childNodes);
				d.appendChild(sibArray[index+k].cloneNode(true));
			}
			bnodes[i].appendChild(d);


			
			var dupNode = input[j].parentNode.parentNode.cloneNode(true);
			console.log(input[j].parentNode.parentNode.className);
			bnodes[i].appendChild(dupNode);

			break;
		}
	}
*/
	}
}


//console.log(type);

};


</script>
