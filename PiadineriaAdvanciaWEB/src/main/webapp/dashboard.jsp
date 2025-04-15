<!DOCTYPE html>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.EmployeeEJB"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.PiadinaEJB"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.MeatBaseEJB"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.SaucesEJB"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.OptionalElementsEJB"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.stream.Collectors"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvanciaEJB Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/stylesDash.css">
</head>
<body>
	<header class="d-flex">
		<div class="flex-fill">
			<h1 class="prevent-select">Menu Management - Piadineria Advancia EJB</h1>
			<%
				EmployeeEJB user = (session != null) ? (EmployeeEJB) session.getAttribute("user") : null;
				if(user != null) {
			%>
			<h3 class="prevent-select">
				Welcome, <%= user.getUsername() %>!
			</h3>
			<%
				}
			%>
		</div>
		<form action="logout" method="post" class="align-self-center"><button class="logoutBtn align-self-center" id="logoutBtn">Logout</button></form>
	</header>
	<main>
		<section class="menu-section">
			<h2 class="prevent-select">Menu</h2>
			<div class="table-responsive-xl">
				<table class="menu-table table table-hover">
					<thead>
						<tr>
							<th class="align-middle prevent-select">Name</th>
							<th class="align-middle prevent-select">Dough</th>
							<th class="align-middle prevent-select">Meat Base</th>
							<th class="align-middle prevent-select">Sauces</th>
							<th class="align-middle prevent-select">Optional</th>
							<th class="align-middle prevent-select">Price</th>
							<th class="align-middle prevent-select">Added By</th>
							<th class="align-middle prevent-select">Actions</th>
						</tr>
					</thead>
					<tbody id="menuTableBody">
						<%
							List<PiadinaEJB> piadinas = (List<PiadinaEJB>) request.getAttribute("piadinas");
							if(piadinas != null) {
								for(PiadinaEJB piadinaEJB : piadinas) {
						%>
									<tr>
										<td class="col align-middle" id=""><%= piadinaEJB.getName() %></td>
										<td class="col align-middle"><%= piadinaEJB.getDough().getType() %></td>
										<td class="col align-middle"><%= piadinaEJB.getMeatBase().stream().map(MeatBaseEJB::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle"><%= piadinaEJB.getSauces().stream().map(SaucesEJB::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle"><%= piadinaEJB.getOptionalElements().stream().map(OptionalElementsEJB::getType).collect(Collectors.joining(", ")) %></td>
										<td class="col align-middle text-nowrap"><%= String.format("&euro; %.2f", piadinaEJB.getPrice()) %></td>
										<td class="col align-middle"><%= piadinaEJB.getEmployee().getName() + " " + piadinaEJB.getEmployee().getSurname() %></td>
										<td class="col align-middle">
											<div class="d-flex justify-content-center">
												<button id="removePiadinaBtn" data-name="<%= piadinaEJB.getName() %>" onclick="remove(this)">Remove</button>
											</div>
										</td>
									</tr>
						<%
								}
							} else {
						%>
								<tr>
									<td colspan="8">No piadinas available</td>
								</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="d-flex justify-content-center">
				<a href="addPiadina"><button class="align-middle" id="addPiadinaBtn">Add Piadina</button></a>
			</div>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="resources/js/scriptDash.js"></script>
</body>
</html>