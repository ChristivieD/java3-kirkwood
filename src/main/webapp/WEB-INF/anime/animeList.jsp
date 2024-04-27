<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container">
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
        <c:when test="${not empty flashMessageDanger}">
            <div class="alert alert-danger mb-2">
                    ${flashMessageDanger}
            </div>
            <c:remove var="flashMessageDanger" scope="session"></c:remove>
        </c:when>
    </c:choose>

    <section class="container my-5">
        <c:forEach items="${animes}" var="anime">
                <c:if test="${anime.status eq 'ongoing' || anime.status eq 'completed'}">
                    <div class="card mb-3">
                        <div class="row g-0">
                            <div class="col-md-4" style="width: 8cm; height: 7cm; overflow: hidden;">
                                <a href="${pageContext.request.contextPath}/details?anime_id=${anime.anime_id}">
                                <img src="${appURL}/images/personal_project/${anime.image}" class="img-fluid rounded-start" style="object-fit: cover; width: 100%; height: 100%;" alt="${anime.title}">
                            </a>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${anime.title}</h5>
                                    <p class="card-text">Description: ${anime.description}</p>
                                    <p class="card-text"><small class="text-muted">Status: ${anime.status}</small></p>
                                    <p class="card-text"><small class="text-muted">Language: ${anime.language}</small></p>
                                    <p class="card-text">
                                        <small class="text-muted">Genre:
                                            <c:forEach items="${genres}" var="genre">
                                                <c:if test="${genre.genre_id eq anime.genre_id}">
                                                    ${genre.genre_name}
                                                </c:if>
                                            </c:forEach>
                                        </small>
                                    </p>
                                    <p class="card-text"><small class="text-muted"> Rating: ${anime.rating}</small></p>
                                        <p class="card-text"><a href="${appURL}/deleteAnime?anime_id=${anime.anime_id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete ${anime.title}?')">Delete</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
        </c:forEach>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>