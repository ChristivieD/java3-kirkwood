<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <div class="card" style="width: 50rem; background: linear-gradient(45deg, rgb(183,0,66), rgba(255,0,0,0));">
                    <div class="card-header">
                        <h5 class="card-title">${pageTitle}</h5>
                    </div>
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
                    <div class="card-body ">
                        <form action="${appURL}/animeAdding" method="post" style="width: 35rem;">
                            <div class="row">
                                <div class="col-md-4 border-right">
                                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                        <div class="profile-pic">
                                            <label class="-label" for="inputImage">
                                                <span class="glyphicon glyphicon-camera"></span>
                                                <span>Add an anime</span>
                                            </label>
                                            <input id="inputImage" name="inputImage" type="file" onchange="loadFile(event)"/>
                                            <img src="${appURL}/images/personal_project/${anime.image}" id="output" width="200" />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="p-3 py-5">
                                        <div class="row mt-2">
                                            <!-- Anime Title -->
                                            <div class="col-md-12">
                                                <label for="inputTitle" class="form-label">Anime Title</label>
                                                <input type="text" class="form-control" id="inputTitle" name="inputTitle">
                                            </div>
                                            <!-- Anime Genre -->
                                            <div class="col-md-6">
                                                <label for="inputGenre" class="form-label">Genre</label>
                                                <select class="form-control" name="inputGenre" id="inputGenre">
                                                    <option value="1" >1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <c:forEach var="genre" items="${genreList}">
                                                        <option value="${genre.genre_id}">${genre.genre_name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <!-- Anime Description -->
                                            <div class="col-md-12">
                                                <label for="inputDescription" class="form-label">Description</label>
                                                <input type="text" class="form-control" id="inputDescription" name="inputDescription">
                                            </div>
                                            <!-- Anime Status -->
                                            <div class="col-md-6">
                                                <label for="inputStatus" class="form-label">Status</label>
                                                <select class="form-control" name="inputStatus" id="inputStatus">
                                                    <option value="ongoing" >ongoing</option>
                                                    <option value="completed">completed</option>
                                                    <option value="upcoming">upcoming</option>
                                                </select>
                                                <c:forEach var="anime" items="${anime}">
                                                    <option value="${anime.status}"></option>

                                                </c:forEach>
                                            </div>
                                            <!-- Anime Date -->
                                            <div class="col-md-6">
                                                <label for="inputDate" class="form-label">Date</label>
                                                <input type="text" class="form-control" id="inputDate" name="inputDate">
                                            </div>
                                            <!-- Anime Language -->
                                            <div class="col-md-6">
                                                <label for="inputLanguage" class="form-label">Language</label>
                                                <input type="text" class="form-control" id="inputLanguage" name="inputLanguage">
                                            </div>
                                            <!-- Anime Rating -->
                                            <div class="col-md-6">
                                                <label for="inputRating" class="form-label">Rating</label>
                                                <input type="text" class="form-control" id="inputRating" name="inputRating">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-5 text-right">
                                <button class="btn btn-primary profile-button" type="submit">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
