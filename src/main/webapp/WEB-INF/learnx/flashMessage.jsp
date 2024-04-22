<c:choose>
    <c:when test="${not empty flashMessageSuccess}">
        <div class="alert alert-success mb-2">
                ${flashMessageSuccess}
        </div>
        <c:remove var="fashMessageSuccess" scope="session"></c:remove>
    </c:when>
    <c:when test="${not empty flashMessageWarning}">
        <div class="alert alert-warning mb-2">
                ${flashMessageWarning}
        </div>
        <c:remove var="flashMessageWarning" scope="session"></c:remove>
    </c:when>
    <c:when test="${not empty flashMessageDanger}">
        <div class="alert alert-danger mb-2">
                ${flashMessageDanger}
        </div>
        <c:remove var="flashMessageDanger" scope="session"></c:remove>
    </c:when>
</c:choose>