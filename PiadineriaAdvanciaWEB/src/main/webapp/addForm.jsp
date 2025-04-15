<!DOCTYPE html>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.domain.model.classes.EmployeeEJB"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.DoughEntity"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.MeatBaseEntity"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.SaucesEntity"%>
<%@ page import="com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.classes.OptionalElementsEntity"%>
<%@ page import="java.util.Set"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PiadineriaAdvanciaEJB AddPiadina</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/stylesAdd.css">
</head>
<body>
	<header class="d-flex align-items-center">
		<a href="dashboard"><button id="backDashBtn">Back</button></a>
		<div class="flex-fill">
			<h1 class="mb-0 prevent-select">Add a New Piadina</h1>
		</div>
	</header>
	<main>
		<form id="add" action="add" method="post">
			<label for="name">Name:</label>
			<input class="textBox" type="text" id="name" name="name" placeholder="name" onclick="hideErrorName()">
			<p class="errorName">A name must be specified.</p>
			<label>Dough:</label>
			<div class="chips-container" id="doughContainer">
			<%
				Set<DoughEntity> doughs = (Set<DoughEntity>) request.getAttribute("doughs");
			 	if(doughs != null) {
					for(DoughEntity doughEJB : doughs) {
			%>
						<div class="chip" onclick="toggleChipSelection('doughEJB', this, 1)" data-id="<%= doughEJB.getId() %>" data-price="<%= doughEJB.getPrice() %>">
					        <span class="chip-label prevent-select"><%= doughEJB.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorDough">A doughEJB must be selected.</p>
			<label>Meat Base (max 2):</label>
			<div class="chips-container" id="meatBaseContainer">
			<%
				Set<MeatBaseEntity> mBases = (Set<MeatBaseEntity>) request.getAttribute("mBases");
				if(mBases != null) {
					for(MeatBaseEntity mBase : mBases) {
			%>
						<div class="chip" onclick="toggleChipSelection('meatBaseEJB', this, 2)" data-id="<%= mBase.getId() %>" data-price="<%= mBase.getPrice() %>">
					        <span class="chip-label prevent-select"><%= mBase.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorMeatBase">At least one meat base must be selected.</p>
			<label>Sauces (max 2):</label>
			<div class="chips-container" id="saucesContainer">
			<%
				Set<SaucesEntity> saucesEJB = (Set<SaucesEntity>) request.getAttribute("saucesEJB");
				if(saucesEJB != null) {
					for(SaucesEntity sauce : saucesEJB) {
			%>
						<div class="chip" onclick="toggleChipSelection('saucesEJB', this, 2)" data-id="<%= sauce.getId() %>" data-price="<%= sauce.getPrice() %>">
					        <span class="chip-label prevent-select"><%= sauce.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorSauces">At least one sauce must be selected.</p>
			<label>Optional Elements (max 3):</label>
			<div class="chips-container" id="optionalElementsContainer">
			<%
				Set<OptionalElementsEntity> oElements = (Set<OptionalElementsEntity>) request.getAttribute("oElements");
				if(oElements != null) {
					for(OptionalElementsEntity oElement : oElements) {
			%>
						<div class="chip" onclick="toggleChipSelection('optionalElementsEJB', this, 3)" data-id="<%= oElement.getId() %>" data-price="<%= oElement.getPrice() %>">
					        <span class="chip-label prevent-select"><%= oElement.getType() %></span>
					    </div>
			<%
					}
				}
			%>
			</div>
			<p class="errorOptionalElements">At least one optional element must be selected.</p>
			<label>Price:</label>
			<div class="mb-3">
				<span id="price">0.00</span><span> &euro;</span>
			</div>
			<label for="addedBy">Added By:</label>
			<%
				EmployeeEJB user = (session != null) ? (EmployeeEJB) session.getAttribute("user") : null;
				if(user != null) {
			%>
					<span id="user"><%= user.getUsername() %></span>
			<%
				}
			%>
			<button class="mt-3" type="button" id="addbtn" onclick="submitAjax()">Add Piadina</button>
		</form>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
	<script src="resources/js/scriptAdd.js"></script>
</body>
</html>