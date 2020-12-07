<!-- establacer URI para trabajar con JSTL, libreria core -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Mantenimiento de Sistemas</title>
</head>
<body>
       
<jsp:include page="Cabecera.jsp" />

<div class="container">&nbsp;<br>&nbsp;<br>&nbsp;<br>
<h4>Bienvenido Sr(a): ${sessionScope.objUsuario.nombreCompleto}</h4>                
</div>
  

<div class="container" >
 <div class="col-md-12" align="center"> 

 </div>
</div>    		
</body>
</html>