<!-- establacer URI para trabajar con JSTL, libreria core -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />

<style type="text/css">
	.help-block {
	  		color: red;
	}
	
	.form-group.has-error .form-control-label {
	  color: red;
	}
	
	.form-group.has-error .form-control {
	  border: 1px solid red;
	  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
	}

</style>
</head>
<body>
	<jsp:include page="Cabecera.jsp" />
	<div class="container" style="margin-top: 6%; width: 90%">
		<c:if test="${requestScope.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>Mensaje : </strong>${requestScope.MENSAJE}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		</c:if>
	
	
	 	<h1 class="font-weight-bold m-3" align="center" style="margin-bottom: 15px">LISTADO ANALISTA</h1>
	 	<!-- Button trigger modal -->
		<button id="btnNuevoEmpleado" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="margin-bottom: 18px">
		  <i class="fas fa-save"></i>  Nuevo Analista
		</button>
		<table id="example" class="table table-striped table-bordered mb-2" style="width:100%">
	        <thead>
	            <tr class="bg-dark text-danger">
	                <th>Código</th>
		            <th>Nombres</th>
		            <th>Apellidos</th>
		            <th>DNI</th>
	                <th>N° Hijos</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	       		<c:forEach items="${requestScope.empleados}" var="row">
		            <tr>
		                <td>${row.codigo}</td>
		                <td>${row.nombre}</td>
		                <td>${row.apellido}</td>
		                <td>${row.dni}</td>
		                <td>${row.hijos}</td>
		                <td class="text-center">
		                	<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModal" id="btnEditar"><i class="fas fa-edit"></i>  Editar</button>
		                	<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modalEliminar" id="btnEliminar"><i class="fas fa-trash-alt"></i>  Eliminar</button>
		                </td>  
		            </tr>
				</c:forEach>
	        </tbody>
    	</table>		
		
	
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title text-danger" id="exampleModalLabel">FORMULARIO</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistra" action="ServletEmpleado?accion=GRABAR" method="post" data-toggle="validator" role="form">
				  <input type="text" name="codigo" id="idCodigo" readonly>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Nombres</label>
				    <input type="text" class="form-control" name="nombres" id="idNombres">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Apellidos</label>
				    <input type="text" class="form-control" name="apellidos" id="idApellidos">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">DNI</label>
				    <input type="text" class="form-control" name="dni" id="idDni">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">N° Hijos</label>
				    <input type="text" class="form-control" name="hijos" id="idHijos">
				  </div>
				  <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Registrar</button>
			      </div>	
				</form>
		      </div>
		    </div>
		  </div>
		</div>
	 	
	 
	 
	 <!-- modal para confirmar eliminación -->
	 <div class="modal fade" id="modalEliminar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Eliminar Empleado</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form action="ServletEmpleado?accion=ELIMINAR" method="post">
	        	<input type="text" name="codigo" id="idCod" readonly>
	        	<h5>Seguro de eliminar registro???</h5>
	        	 <div class="modal-footer">
			        <button type="submit" class="btn btn-primary">Si</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>			        
			     </div>
	        </form>
	      </div>
	     
	    </div>
	  </div>
	</div>
	 
	 
	 
	 
	 
	 
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#example').DataTable();
		} );
	
	//asignar evento click al botón btnEliminar
	$(document).on("click","#btnEliminar",function(){
		var cod;
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		$("#idCod").val(cod);
	})
	//asignar evento click al botón btnEditar
	$(document).on("click","#btnEditar",function(){
		var cod,nom,ape,dni,hij;
		cod=$(this).parents("tr").find("td")[0].innerHTML;
		nom=$(this).parents("tr").find("td")[1].innerHTML;
		ape=$(this).parents("tr").find("td")[2].innerHTML;
		dni=$(this).parents("tr").find("td")[3].innerHTML;
		hij=$(this).parents("tr").find("td")[4].innerHTML;
		$("#idCodigo").val(cod);
		$("#idNombres").val(nom);
		$("#idApellidos").val(ape);
		$("#idDni").val(dni);
		$("#idHijos").val(hij);
	})
	//asignar evento click al botón btnNuevoEmpleado
	$(document).on("click","#btnNuevoEmpleado",function(){
		$("#idCodigo").val("0");
		$("#idNombres").val("");
		$("#idApellidos").val("");
		$("#idDni").val("");
		$("#idHijos").val("");
	})
		
	
	
		
	</script>
	<script type="text/javascript">    
    $(document).ready(function(){     
        $('#idRegistra').bootstrapValidator({      
        	 fields:{
        		 nombres:{
        			 	validators:{
        			 		notEmpty:{
        			 			message:'Campo nombres es obligatorio'	
        			 		},
        			 		regexp:{
        			 			regexp:/^[a-zA-Z\s\ñ\Ñ\á\é]{3,30}$/,
        			 			message:'Campo nombres solo letras min 3 hasta max 30 letras'
        			 		}
        			 	}
        		 },
        		 apellidos:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo apellidos es obligatorio'	
     			 		},
     			 		regexp:{
    			 			regexp:/^[a-zA-Z\s\ñ\Ñ\á\é]{3,30}$/,
    			 			message:'Campo apellidos solo letras min 3 hasta max 30 letras'
    			 		}
     			 	}
     		 	 },     		    
     		 	dni:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo dni es obligatorio'	
     			 		},
     			 		digits:{
     			 			message:'Campo dni solo digitos'
     			 		},
     			 		regexp:{
    			 			regexp:/^(\d{8})$/,
    			 			message:'Campo dni es de 8 caracteres'
    			 		}
     			 	}
     		 	 },  		    
     		 	hijos:{
     			 	validators:{
     			 		notEmpty:{
     			 			message:'Campo hijos es obligatorio'	
     			 		},
     			 		digits:{
     			 			message:'Campo hijos solo digitos'
     			 		},
     			 		regexp:{
    			 			regexp:/^[0-9]$/,
    			 			message:'Campo hijos min 0 - max 9'
    			 		}
     			 	}
     		 	 }
     		 	 
        	 }
        });   
			
    });    
</script>
	
	
	
	
</body>
</html>