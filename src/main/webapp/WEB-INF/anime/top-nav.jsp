<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0">
            <a href="${appURL}/anime" class="d-inline-flex link-body-emphasis text-decoration-none">
                <img src="${appURL}/images/personal_project/icon.png" class="nav-logo" style="height: 64px" alt="Anime Logo">
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="${appURL}" class="nav-link px-2 link-secondary">Home</a></li>

            <li><a href="${appURL}/List" class="nav-link px-2">List</a></li>
            <li><a href="${appURL}/New" class="nav-link px-2">New</a></li>
            <li><a href="${appURL}/Coming soon" class="nav-link px-2">Coming Soon</a></li>
            <li><a href="${appURL}/Search" class="nav-link px-2">Search</a></li>
        </ul>

        <div class="col-md-3 text-end">
            <c:choose>
                <c:when test="${empty sessionScope.activeUser}">
                    <a href="${appURL}/access" class="btn btn-outline-darkred me-2">Sign In</a>
                    <a href="${appURL}/new-user" class="btn btn-darkred ">Sign Up</a>
                </c:when>
                <c:otherwise>
                    <a href="${appURL}/sign-out" class="btn btn-outline-darkred me-2">Sign Out</a>
                    <a href="${appURL}/edit-profile" class="btn btn-darkred">Edit Profile</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>