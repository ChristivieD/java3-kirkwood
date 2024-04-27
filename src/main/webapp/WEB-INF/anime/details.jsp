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
        <div class="row">
            <div class="col-md-6">
                <div class="card mb-3">
                    <div class="row g-0">
                        <div class="col-md-4" style="overflow: hidden;">
                            <img src="${appURL}/images/personal_project/${anime.image}" class="img-fluid rounded-start" style="object-fit: cover; width: 100%; height: 100%;" alt="${anime.title}">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${anime.title}</h5>
                                <p class="card-text">Description: ${anime.description}</p>
                                <p class="card-text">Release Date: ${anime.release_date}</p>
                                <p class="card-text">Status: ${anime.status}</p>
                                <p class="card-text">Language: ${anime.language}</p>
                                <p class="card-text">Genre: ${anime.genre_id}</p>
                                <p class="card-text">Rating: ${anime.rating}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <h4>Reviews</h4>
                <div class="list-group">
                    <c:forEach items="${reviews}" var="review">
                        <div class="list-group-item">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">User ID: ${review.getUserName()}</h5>
                                <small>Rating: ${review.rating}</small>
                            </div>
                            <p class="mb-1">Review: ${review.text}</p>
                            <small class="text-muted">Posted at: ${review.posted_at}</small>
                        </div>
                    </c:forEach>
                    <c:if test="${empty reviews}">
                        <div class="alert alert-info" role="alert">
                            No reviews available.
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>