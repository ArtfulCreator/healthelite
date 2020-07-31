window.onload=function() {

  // get tab container
  var container = document.getElementById("tabContainer");
    // set current tab
    var navitem = container.querySelector(".tabs ul li");
    
    var ident = navitem.id.split("_")[1];
    
    //this adds click event to tabs
    var tabs = container.querySelectorAll(".tabs ul li");


    for (var i = 0; i < tabs.length; i++) {
      tabs[i].onclick=displayPage;
      if(tabs[i].getAttribute("value") == "active") {
    	  ident=i+1;
    	  navitem = tabs[i];
      }

    }
    

    var pages = container.querySelectorAll(".tabpage");
    
    //if any tab comes back from server as active leave that alone.
    for (var i = 0; i < pages.length; i++) {
      if(i != ident-1) {	
    	  pages[i].style.display="none";
      }
    }
    
    
    navitem.parentNode.setAttribute("data-current",ident);
    //set current tab with class of activetabheader
    navitem.setAttribute("class","tabActiveHeader");



}

// on click of one of tabs
function displayPage() {
  var current = this.parentNode.getAttribute("data-current");
  //remove class of activetabheader and hide old contents
  document.getElementById("tabHeader_" + current).removeAttribute("class");
  document.getElementById("tabpage_" + current).style.display="none";

  var ident = this.id.split("_")[1];
  //add class of activetabheader to new active tab and show contents
  this.setAttribute("class","tabActiveHeader");
  document.getElementById("tabpage_" + ident).style.display="block";
  this.parentNode.setAttribute("data-current",ident);
}