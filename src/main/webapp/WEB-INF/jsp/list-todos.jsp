<%@ page language="java" pageEncoding="UTF-8"%>
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
			<b>Поиск по имени:</b>

		<label>
			<form:input path="fullName" type="text"/>
		</label>

			<button class="btn btn-primary" type="submit">Поиск</button>

			<a type="button" class="btn btn-primary" href="/list-todos">Очистить</a>
		</form:form>

		<form:form action="/sort-todo" method="post" modelAttribute="todo">
			<b>Отсортировать  колонне:</b>
			<label>
				<form:select path="prop">
					<form:option  value="fullName">ФИО</form:option>
					<form:option  value="iin">ИИН</form:option>
					<form:option  value="passport">Пасспорт</form:option>
					<form:option  value="cr_date">Дата</form:option>
					<form:option  value="disc">Скидка</form:option>
					<form:option  value="address">Адрес</form:option>
					<form:option  value="phoneNumber">Номер телефона</form:option>
					<form:option  value="prop">Реквизиты</form:option>
				</form:select>
			</label>
			<button class="btn btn-primary"
					type="submit">Отсортировать</button>
		</form:form>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ФИО</th>
					<th>ИИН</th>
					<th>Пасспорт</th>
					<th>Дата</th>
					<th>Скидка</th>
					<th>Адрес</th>
					<th>Номер телефона</th>
					<th>Реквизиты</th>
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
							href="/update-todo?id=${todo.id}">Изменить</a></td>
						<td><a type="button" class="btn btn-success"
							   href="/show-todo?id=${todo.id}">Детали</a></td>
						<td><a type="button" class="btn btn-danger"
							href="/delete-todo?id=${todo.id}">Удалить</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-info"
			   href="/add-todo">Добавить</a>

		</div>
	</div>
<%@ include file="common/footer.jspf" %>
