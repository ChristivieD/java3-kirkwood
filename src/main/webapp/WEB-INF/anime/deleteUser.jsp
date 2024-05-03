<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <%@include file="leftSideBarHeader.jsp"%>
    <div class="container mt-5">
        <div class="row">
            <%@include file="leftSideBar.jsp"%>
            <div class="col-md-6">
                <div class="card" style="width: 50rem; background: linear-gradient(45deg, rgb(183,0,66), rgba(255,0,0,0));">
                    <div class="card-header">
                        <h5 class="card-title">${pageTitle}</h5>
                    </div>
                    <c:when test="${not empty flashMessageSuccess}">
                        <div class="alert alert-success mb-2">
                                ${flashMessageSuccess}
                        </div>
                        <c:remove var="flashMessageSuccess" scope="session"></c:remove>
                    </c:when>
                    <c:when test="${not empty flashMessageWarning}">
                        <div class="alert alert-warning mb-2">
                                ${flashMessageWarning}
                        </div>
                        <c:remove var="flashMessageWarning" scope="session"></c:remove>
                    </c:when>
                    <div class="card-body ">
                        <h6>If you delete this account, you will lose  all associated data.</h6>
                        <form action="${appURL}/deleteUser?user_id=${user.user_id}" method="post">
                            <input type="hidden" name="inputUser" value="${user_id}">
                            <p>Are you sure you want to delete this user?</p>
                            <button type="submit" class="btn btn-danger">Delete</button>
                            <a href="${appURL}/users" class="btn btn-secondary">Cancel</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
