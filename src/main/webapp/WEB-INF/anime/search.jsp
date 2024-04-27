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
            <li><a href="${appURL}/comingSoon" class="nav-link px-2">Coming Soon</a></li>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    <li><a href="${appURL}/Search" class="nav-link px-2">Search</a></li>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="#">${anime.genre}</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
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
                    <a href="${appURL}/editProfile" class="btn btn-darkred">Edit Profile</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>
</div>

<div class="container mt-5">
    <h2>Search</h2>
    <form action="${pageContext.request.contextPath}/search" method="GET">
        <div class="mb-3">
            <label for="searchInput" class="form-label">Search Anime:</label>
            <input type="text" class="form-control" id="searchInput" name="search" placeholder="Enter keywords">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
</div>

<div class="container mt-5">
    <!-- Display search results here -->
    <c:if test="${not empty animeSearch}">
        <h3>Search Results:</h3>
        <ul>
            <c:forEach items="${animeSearch}" var="anime">
                <li>
                    <h4>${anime.title}</h4>
                    <p><strong>Description:</strong> ${anime.description}</p>
                    <!-- Add more details as needed -->
                </li>
            </c:forEach>
        </ul>
    </c:if>
</div>