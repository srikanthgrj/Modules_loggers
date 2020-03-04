<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<body>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Racing Time</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./Aftersignin.jsp">Racers Home</a>
			</div>
			<ul class="nav navbar-nav">
			<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">welcome ${signinemail }</a>
			</div>


			</ul>
			<ul class="nav navbar-nav navbar-right">
				
				<li><a href="./index.jsp"><span class="glyphicon "></span>
						logout</a></li>
			</ul>
		</div>
	</nav>
	

	<div class="container">
  <h2>Select ur race</h2>
  
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
      <h5>1 ON 1</h5>
        <a href="1-1race.jpg" target="_blank">
          <img src="1-1race.jpg" alt="Lights" style="width:100%">
          
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
      <h5>4 IN A ROW</h5>
        <a href="4on4is4.jpg" target="_blank">
          <img src="4on4is4.jpg" alt="Nature" style="width:85%">
          
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
      <h5>LAP RACE</h5>
        <a href="laprace.jpg" target="_blank">
          <img src="laprace.jpg" alt="Fjords" style="width:100%">
          
        </a>
      </div>
    </div>
  </div>
</div>
	

</body>
</html>
