<%--
  Created by IntelliJ IDEA.
  User: suleev
  Date: 2/5/2022
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <form:form method="post" modelAttribute="user">


        <fieldset class="form-group">
            <form:label path="login">Логин</form:label>
            <form:input path="login" type="text" class="form-control"
                        required="required" />
            <form:errors path="login" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="password">Пароль</form:label>
            <form:input path="password" type="text" class="form-control"
                        required="required" />
            <form:errors path="password" cssClass="text-warning" />
        </fieldset>

        <fieldset class="form-group">
            <form:label path="passwordChecker">Введите пароль еще раз для проверки</form:label>
            <form:input path="passwordChecker" type="text" class="form-control"
                        required="required" />
            <form:errors path="passwordChecker" cssClass="text-warning" />
        </fieldset>

        <button type="submit" class="btn btn-success">Добавить</button>

        <c:if test="${not empty error}">
            <f:verbatim><br /></f:verbatim>
             ${error}
        </c:if>

    </form:form>

</div>
<%@ include file="common/footer.jspf" %>