<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <%@include file="leftSideBarHeader.jsp"%>
    <div class="container mt-5">
        <div class="row">
            <%@include file="leftSideBar.jsp"%>
            <div class="col-md-6">
                <div class="card" style="border-radius: 15px; background-color: papayawhip;">
                    <div class="card-header ">
                        <h3 class="card-title">User Dashboard</h3>
                    </div>
                    <div class="card-body">
                        <c:choose>
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
                        </c:choose>
                        <p>Welcome, ${activeUser.getUsername()}!</p>
                        <div class="table-responsive border-0">
                            <table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 rounded-start"> User Dashboard</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <div class="d-flex align-items-center">
                                            <div class="mb-0 ms-2">
                                                <h6><a href="${appURL}/animeList">Watch List</a></h6>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>