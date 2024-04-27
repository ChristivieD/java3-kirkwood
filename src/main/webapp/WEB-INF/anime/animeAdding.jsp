<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <div class="card" style="width: 50rem; background: linear-gradient(45deg, rgb(183,0,66), rgba(255,0,0,0));">
                    <div class="card-header">
                        <h5 class="card-title">${pageTitle}</h5>
                    </div>
                    <div class="card-body ">
                        <c:if test="${not empty flashMessageSuccess}">
                            <div class="alert alert-success">
                                    ${flashMessageSuccess}
                            </div>
                            <c:remove var="flashMessageSuccess"></c:remove>
                        </c:if>
                        <c:if test="${not empty flashMessageWarning}">
                            <div class="alert alert-success">
                                    ${flashMessageWarning}
                            </div>
                            <c:remove var="flashMessageWarning"></c:remove>
                        </c:if>
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
                                            <img src="C:\Users\lised\Documents\Java_III" id="output" width="200" />
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
                                                <input type="text" class="form-control" id="inputGenre" name="inputGenre">
                                            </div>
                                            <!-- Anime Description -->
                                            <div class="col-md-12">
                                                <label for="inputDescription" class="form-label">Description</label>
                                                <input type="text" class="form-control" id="inputDescription" name="inputDescription">
                                            </div>
                                            <!-- Anime Status -->
                                            <div class="col-md-6">
                                                <label for="inputStatus" class="form-label">Status</label>
                                                <input type="text" class="form-control" id="inputStatus" name="inputStatus">
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
