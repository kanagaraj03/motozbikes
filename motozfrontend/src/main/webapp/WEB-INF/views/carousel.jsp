<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
<style>
<h2 class= "color:grey">trendy bikes <w3-center"></h2>
</style>
<body>
<div class="w3-content w3-section" style="max-width:2000px">
  <img class="mySlides" src="resources/images/11.jpg" style="width:100%">
 <img class="mySlides" src="resources/images/Kawasaki+Ninja+ZX-10R+11.jpg" style="width:100%">
<img class="mySlides" src="resources/images/2.jpg" style="width:100%">
<img class="mySlides" src="resources/images/1.jpg" style="width:100%">
<img class="mySlides" src="resources/images/2014-Ducati-Monster-1200-still-18.jpg" style="width:100%">
<img class="mySlides" src="resources/images/755218.jpg" style="width:100%">
<img class="mySlides" src="resources/images/ducati-xdiavel-827_827x510_71447853440.jpg" style="width:100%">

</div>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 3000); // Change image every 2 seconds
}
</script>
</body>
