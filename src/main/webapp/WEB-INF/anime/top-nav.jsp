<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0">
            <a href="${appURL}/anime" class="d-inline-flex link-body-emphasis text-decoration-none">
                <img src="${appURL}/images/personal_project/icon.png" class="nav-logo" style="height: 64px" alt="Anime Logo">
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${appURL}/anime" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="${appURL}/animeList" class="nav-link px-2">List</a></li>
<%--            <li><a href="${appURL}/search" class="nav-link px-2">Search</a></li>--%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Genres
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach items="${genres}" var="genre">
                        <li><a class="dropdown-item" href="${appURL}/search?genre=${genre.genre_id}">${genre.genre_name}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <c:choose>
                <c:when test="${sessionScope.activeUser.privileges eq 'user'}">
                    <li><a href="${appURL}/user" class="nav-link px-2 <c:if test="${pageTitle eq 'User Dashboard'}">link-dark</c:if>">User Dashboard</a></li>
                </c:when>
                <c:when test="${sessionScope.activeUser.privileges eq 'premium'}">
                    <li><a href="${appURL}/premium" class="nav-link px-2 <c:if test="${pageTitle eq 'Premium Dashboard'}">link-dark</c:if>">Premium Dashboard</a></li>
                </c:when>
                <c:when test="${sessionScope.activeUser.privileges eq 'admin'}">
                    <li><a href="${appURL}/admin" class="nav-link px-2 <c:if test="${pageTitle eq 'Admin Dashboard'}">link-dark</c:if>">Admin Dashboard</a></li>
                </c:when>
                <c:when test="${sessionScope.activeUser.privileges eq 'premium'}">
                    <li><a href="${appURL}/comingSoon" class="nav-link px-2">Coming Soon</a></li>
                </c:when>
                <c:when test="${sessionScope.activeUser.privileges eq 'admin'}">
                    <li><a href="${appURL}/deleteAnime" class="nav-link px-2 <c:if test="${pageTitle eq 'Delet an Anime'}">link-dark</c:if>">Delete an Anime </a></li>
                </c:when>
            </c:choose>
        </ul>

        <div class="col-md-3 text-end">
            <c:choose>
                <c:when test="${empty sessionScope.activeUser}">
                    <a href="${appURL}/access" class="btn btn-outline-darkred me-2">Sign In</a>
                    <a href="${appURL}/new-user" class="btn btn-darkred ">Sign Up</a>
                </c:when>
                <c:otherwise>
                    <a href="${appURL}/sign-out" class="btn btn-outline-darkred me-2">Sign Out</a>
                    <a href="${appURL}/editProfile" class="btn btn-darkred">Edit Profile</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>