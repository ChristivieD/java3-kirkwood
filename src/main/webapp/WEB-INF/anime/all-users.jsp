<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <div class="container">
        <h1>All user</h1>
        <p> There are ${users.size() == 1 ? "is" : "are"} &nbsp${users.size()} user${users.size() != 1 ? "s" : ""}</p>
        <div class="row">
            <div class="col-lg-8">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Email</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>
                                    <a href="${appURL}/editUser?user_id=${user.user_id}" class="btn btn-primary">Edit</a>
                                    <a href="${appURL}/deleteUser?id=${user.user_id}" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>