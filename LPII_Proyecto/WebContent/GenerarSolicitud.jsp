<!-- establacer URI para trabajar con JSTL, libreria core -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

<title>Generar Licencia</title>
</head>
<body>
	<jsp:include page="Cabecera.jsp" />
			<c:if test="${requestScope.MENSAJE != null}">
				<div class="alert alert-warning alert-dismissible fade show" style="background: red"
					role="alert">
					<strong>Mensaje : </strong>${requestScope.MENSAJE}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
	<div class="container bg-success" style="margin-top: 8%; width: 50%">
		<h1 align="center">Generar Solicitud</h1>
		<!-- Button trigger modal -->
		<form id="idRegistra" action="SolicitudCrud" method="post"
			data-toggle="validator" role="form">
			<input type="hidden" name="ACCION" value="INSERTAR">
			<div class="form-group col">
				<label>Aplicacion</label> <select name="apli" id="aplic"
					class="form-control">
					<option selected value="">SELECCIONE[]</option>
					<option value="Mascotas Latinas">Mascotas Latinas</option>
					<option value="Hospital La Muerte">Hospital La Muerte</option>
					<option value="Banco El Grillo">Banco El Grillo</option>
					<option value="Sistema Envio de Facturas">Sistema Envio de
						Facturas</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Descripcion</label>
				<textarea class="form-control" name="descripcion" id="descrip"></textarea>
			</div>
			<div class="form-group col">
				<label>Area</label> <select name="area" id="areaa"
					class="form-control">
					<option selected value="">SELECCIONE[]</option>
					<option value="Tecnica">Tecnica</option>
					<option value="Ofi. General">Ofi. General</option>
					<option value="Marketing">Marketing</option>
				</select>
			</div>
			<div class="form-group col">
				<label>Fecha de Emision</label> <input type="date"
					class="form-control" name="fecha" id="fechaa">
			</div>
			<button type="submit" class="btn btn-primary"
				style="margin: 0px 0px 10px 34%; width: 200px">Enviar</button>
		</form>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#idRegistra')
									.bootstrapValidator(
											{
												fields : {
													apli : {
														validators : {
															notEmpty : {
																message : 'Campo aplicacion es obligatorio'
															}
														}
													},
													descripcion : {
														validators : {
															notEmpty : {
																message : 'Campo descripcion es obligatorio'
															},
															regexp : {
																regexp : /^[a-zA-Z\s\ñ\Ñ\á\é]{3,150}$/,
																message : 'Campo descripcion solo letras min 3 hasta max 150 letras'
															}
														}
													},
													area : {
														validators : {
															notEmpty : {
																message : 'Campo area es obligatorio'
															}
														}
													},
													fecha : {
														validators : {
															notEmpty : {
																message : 'Campo fecha es obligatorio'
															}
														}
													}

												}
											});
						});
	</script>
</body>
</html>