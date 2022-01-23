<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<style>
		b {
			font-size: 20px
		}
		table {
			/*background-color: white;*/
			border-radius: 4px;
		}


	</style>

	<div class="container">
		<form:form action="/search-todo" method="post" modelAttribute="todo">
			<b>Search by name:</b>

		<label>
			<form:input path="fullName" type="text"/>
		</label>

			<button class="btn btn-primary" type="submit">search</button>

			<a type="button" class="btn btn-primary" href="/list-todos">clear</a>
		</form:form>

		<form:form action="/sort-todo" method="post" modelAttribute="todo">
			<b>Sort by column:</b>
			<label>
				<form:select path="prop">
					<form:option  value="fullName">Full Name</form:option>
					<form:option  value="iin">IIN</form:option>
					<form:option  value="passport">Passport</form:option>
					<form:option  value="cr_date">Creation Date</form:option>
					<form:option  value="disc">Discount</form:option>
					<form:option  value="address">Address</form:option>
					<form:option  value="phoneNumber">Phone Number</form:option>
					<form:option  value="prop">Props</form:option>
				</form:select>
			</label>
			<button class="btn btn-primary"
					type="submit">Sort</button>
		</form:form>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>Full name</th>
					<th>IIN</th>
					<th>Passport</th>
					<th>Creation Date</th>
					<th>Discount</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Props</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody class="radius" >
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.fullName}</td>
						<td>${todo.iin}</td>
						<td>${todo.passport}</td>
						<td>${todo.date}</td>
						<td>${todo.disc}</td>
						<td>${todo.address}</td>
						<td>${todo.phoneNumber}</td>
						<td>${todo.prop}</td>
						<td><a type="button" class="btn btn-info"
							href="/update-todo?id=${todo.id}">Edit</a></td>
						<td><a type="button" class="btn btn-success"
							   href="/show-todo?id=${todo.id}">Detalis</a></td>
						<td><a type="button" class="btn btn-danger"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-info"
			   href="/add-todo">Add new Client</a>

		</div>
	</div>
<%@ include file="common/footer.jspf" %>
