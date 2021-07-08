<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>



<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div id="map" style="width:50%; height: 50vh;"></div>
	<button id="button">버튼</button>
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0Z3OxJ67S97YCiAPlHOZSCZz_tms-sm0&callback=initMap&region=kr"></script>
  <script>
    function initMap() {
      var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
      var map = new google.maps.Map(
        document.getElementById('map'), {
          zoom: 12,
          center: seoul
        });
      
    }
    
    var map;
    var button = document.getElementById('button');
    button.addEventListener('click', changeCenter);

    function initMap() {
      var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
      map = new google.maps.Map( document.getElementById('map'), {
          zoom: 12,
          center: seoul
        });

      new google.maps.Marker({
        position: seoul,
        map: map,
        label: "서울 중심 좌표"
      });
    }
    
    function changeCenter(){
    	  var busan = { lat: 35.1379222, lng: 129.05562775 };
    	  map.panTo(busan);
    	  map.setZoom(14);
    	}
  </script>
  
</div>
</body>
</html>