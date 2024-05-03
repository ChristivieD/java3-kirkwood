<%@ include file="/WEB-INF/anime/top.jsp" %>
<main>
    <%@ include file="leftSideBarHeader.jsp" %>
    <div class="container mt-5">
        <div class="row">
            <%@ include file="leftSideBar.jsp" %>
            <div class="col-md-6">
                <div class="card" style="width: 50rem; background: linear-gradient(45deg, rgb(183,0,66), rgba(255,0,0,0));">
                    <div class="card-header">
                        <h5 class="card-title">${pageTitle}</h5>
                    </div>
                    <c:if test="${not empty flashMessageSuccess}">
                        <div class="alert alert-success mb-2">
                                ${flashMessageSuccess}
                        </div>
                    </c:if>
                    <c:if test="${not empty flashMessageWarning}">
                        <div class="alert alert-warning mb-2">
                                ${flashMessageWarning}
                        </div>
                    </c:if>
                    <div class="card-body ">
                        <h2>Delete Anime Confirmation.</h2>
                        <p>Choose an anime from the list below to delete:</p>
                        <form action="${appURL}/deleteAnime" method="post">
                            <div class="form-group">
                                <label for="inputAnimeID">Anime Title:</label>
                                <select id="inputAnimeID" name="inputAnimeID" required>
                                    <option value="">Select an anime</option>
                                    <c:forEach var="allAnime" items="${animes}">
                                        <option value="${allAnime.anime_id}">${allAnime.title}</option>
                                    </c:forEach>
                                </select><br><br>
                                <input type="submit" value="Delete">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="/WEB-INF/anime/bottom.jsp" %>