<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Plantas</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Planta</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir essa planta?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterPlanta.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->
            <!-- Barra superior com os menus de navegação -->
			<c:import url="Menu.jsp"/>
            <!-- Container Principal -->
            <div id="main" class="container">
              <div class="col-md-12">
                            <h2 class="text-center">Minhas Plantas 🌼</h2> 
                        </div>
                        
                <form action="listar_plantas.do" method="post">
                    <div class="top" "class="row " style="margin:0 auto; ">
                        <div class="col-md-6" style="margin-left: 140px">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Plantas (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="acao" value="buscar">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="CriarPlanta.jsp" class="btn btn-info pull-right h2">Adicionar Nova Planta</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row  center-block" style="width:70%; ">
	
                    <div class="table-responsive col-md-12 ">
                        <table class="table table-striped table-hover" cellspacing="0" cellpadding="0" style="margin-top: 20px; ">
                            <thead>
                                <tr class="info">
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="planta" items="${lista }">
                                       <tr class="table-info">
                                            <td>
                                               ${planta.id }
                                            </td>
                                            <td>
                                                ${planta.nome }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterPlanta.do?acao=Visualizar&id=${planta.id }">Ver detalhes</a>
                                                <a class="btn btn-warning btn-xs" href="ManterPlanta.do?acao=Editar&id=${planta.id }">Editar</a>
                                                <button id="btn${planta.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-planta="${planta.id }">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

               
                </c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('planta');
                    $("#id_excluir").val(recipient);
                });
            </script>
        </body>

        </html>
