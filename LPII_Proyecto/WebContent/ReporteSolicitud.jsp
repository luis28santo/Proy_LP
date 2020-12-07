<!-- establacer URI para trabajar con JSTL, libreria core -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />


<title>Reporte Solicitud</title>
</head>
<body>
	<jsp:include page="Cabecera.jsp" />
	<div class="container bg-success"
		style="margin-top: 8%; margin-bottom: 3%; width: 80%">
		<c:if test="${requestScope.mensaje != null}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<strong>Mensaje : </strong>${requestScope.mensaje}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>


		<h1 align="center">Listado de Supervisores</h1>
		<!-- Button trigger modal -->
		<form accept-charset="UTF-8" action="SolicitudCrud">
			<input type="hidden" name="ACCION" value="LISTAR"> <input
				type="hidden" name="LISTA" value="">
			<button type="submit" class="btn btn-primary"
				style="margin-top: 15px; margin-bottom: 15px; width: 200px">Listar</button>
		</form>
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Código</th>
					<th>Area Encargada</th>
					<th>Fecha Emi.</th>
					<th>Descripcion</th>
					<th>Aplicacion</th>
					<th>Estado</th>
					<th>Analista</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.SOLICITUD}" var="row">
					<tr>
						<td>${ row.codigo }</td>
						<td>${ row.area }</td>
						<td>${ row.fechaEmi }</td>
						<td>${ row.descripcion }</td>
						<td>${ row.app }</td>
						<td>${ row.estado }</td>
						<td>${ row.usuario }</td>
						<td class="" style="width: 150px">
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#exampleModal" id="btnEditar">Editar</button>
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#modalEliminar" id="btnEliminar">Eliminar</button>
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
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistra" action="ServletDocente?accion=REGISTRAR" method="post" data-toggle="validator" role="form">
				  <input type="text" name="codigo" id="idCodigo">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Nombres</label>
				    <input type="text" class="form-control" name="nombres" id="idNombres">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Apellidos</label>
				    <input type="text" class="form-control" name="apellidos" id="idApellidos">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Edad</label>
				    <input type="text" class="form-control" name="edad" id="idEdad">
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
		<div class="modal fade" id="modalEliminar" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Eliminar Solicitud</h5>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="SolicitudCrud?ACCION=ELIMINAR" method="post">
							<input type="text" name=codigo id="idCodi">
							<h5>Seguro de eliminar registro???</h5>
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Si</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">No</button>
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
		});

		//asignar evento click al botón btnEliminar
		$(document).on("click", "#btnEliminar", function() {
			var cod;
			cod = $(this).parents("tr").find("td")[0].innerHTML;
			$("#idCodi").val(cod);
		})
		//asignar evento click al botón btnEditar
		//$(document).on("click", "#btnEditar", function() {

		//})
	</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#idRegistra')
									.bootstrapValidator(
											{
												fields : {
													nombres : {
														validators : {
															notEmpty : {
																message : 'Campo nombres es obligatorio'
															},
															regexp : {
																regexp : /^[a-zA-Z\s\ñ\Ñ\á\é]{3,15}$/,
																message : 'Campo nombres solo letras min 3 hasta max 15 letras'
															}
														}
													},
													apellidos : {
														validators : {
															notEmpty : {
																message : 'Campo apellidos es obligatorio'
															},
															regexp : {
																regexp : /^[a-zA-Z\s\ñ\Ñ\á\é]{3,25}$/,
																message : 'Campo apellidos solo letras min 3 hasta max 25 letras'
															}
														}
													},
													edad : {
														validators : {
															notEmpty : {
																message : 'Campo edad es obligatorio'
															},
															digits : {
																message : 'Campo edad solo digitos'
															},
															regexp : {
																regexp : /^(\d\d)$/,
																message : 'Campo edad max 99'
															}
														}
													}

												}
											});

						});
	</script>
</body>
</html>