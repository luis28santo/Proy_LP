<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container">
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
          data-target=".navbar-collapse">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
      </div>

      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-left">
          <li><a href="Home.jsp">Home</a></li>
        </ul>

        <ul class="nav navbar-nav">
          <li class="dropdown"><a href="#" class="dropdown-toggle"
            data-toggle="dropdown">Mantenimiento<b class="caret"></b>
          </a>
            <ul class="dropdown-menu">
              <li><a href="GenerarSolicitud.jsp">Generar Solicitud</a></li>
              <li><a href="ReporteSolicitud.jsp">Reporte Solicitud</a></li>
              
            </ul></li>
        </ul>


        <ul class="nav navbar-nav">
          <li class="dropdown"><a href="#" class="dropdown-toggle"
            data-toggle="dropdown"> Analistas<b class="caret"></b>
          </a>
            <ul class="dropdown-menu">
              <li><a href="AnalistaCRUD.jsp">CRUD Analista</a></li>
            </ul></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="logout">Salir</a></li>
        </ul>

      </div>
    </div>
  </div>
</div>