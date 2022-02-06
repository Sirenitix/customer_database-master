<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <form:form method="post" modelAttribute="todo">
        <form:hidden path="id" />

        <fieldset class="form-group">
            <form:label path="fullName">ФИО</form:label>
            <form:input path="fullName" type="tetx" class="form-control"
                        readonly="true" />
            <form:errors path="fullName" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="iin">ИИН</form:label>
            <form:input path="iin" type="number" class="form-control"
                        readonly="true" />
            <form:errors path="iin" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="passport">Пасспорт</form:label>
            <form:input path="passport" type="text" class="form-control"
                        readonly="true" />
            <form:errors path="passport" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="date">Дата</form:label>
            <form:input path="date" type="date" class="form-control"
                        readonly="true" />
            <form:errors path="date" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="disc">Скидка</form:label>
            <form:input path="disc" type="text" class="form-control"
                        readonly="true" />
            <form:errors path="disc" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="add_inf">Дополнительная информация</form:label>
            <form:input path="add_inf" type="text" class="form-control"
                        readonly="true" />
            <form:errors path="add_inf" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="address">Адрес</form:label>
            <form:input path="address" type="text" class="form-control"
                        readonly="true" />
            <form:errors path="address" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="phoneNumber">Номер телефона</form:label> <%--Description--%>
            <form:input path="phoneNumber" type="number" class="form-control"
                        readonly="true" />
            <form:errors path="phoneNumber" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="prop">Реквизиты</form:label> <%--Description--%>
            <form:input path="prop" type="text" class="form-control"
                        readonly="true" />
            <form:errors path="prop" cssClass="text-warning" />
        </fieldset>

        <a type="button" class="btn btn-primary" href="/list-todos">Назад к списку</a>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>