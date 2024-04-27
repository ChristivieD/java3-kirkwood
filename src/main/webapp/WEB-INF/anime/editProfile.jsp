<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <%@include file="leftSideBarHeader.jsp"%>
    <div class="container mt-5">
        <div class="row">
            <%@include file="leftSideBar.jsp"%>
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
                        <form action="${appURL}/editProfile" method="post">
                            <div class="row">
                                <div class="col-md-4 border-right">
                                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                        <div class="profile-pic">
                                            <label class="-label" for="file">
                                                <span class="glyphicon glyphicon-camera"></span>
                                                <span>Change Image</span>
                                            </label>
                                            <input id="file" type="file" onchange="loadFile(event)"/>
                                            <img src="${appURL}/images/personal_project/john.jpeg" id="output" width="200" />
                                        </div>
                                        <span class="font-weight-bold">${activeUser.username}</span>
                                        <span class="text-black-50">${activeUser.email}</span>
                                        <span>United States</span>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="p-3 py-5">
                                        <div class="row mt-2">
                                            <!-- User Name -->
                                            <div class="col-md-6">
                                                <label for="usernameInput" class="form-label">User Name</label>
                                                <input type="text" class="form-control" id="usernameInput" name="usernameInput" value="${fn:escapeXml(activeUser.username)}">
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <!-- Select Language -->
                                            <div class="col-md-6">
                                                <label for="languageInput" class="form-label">Language</label>
                                                <select name="languageInput" id="languageInput" class="form-select <c:if test="${not empty results.languageError}">is-invalid</c:if>">
                                                    <option value="en-US" ${activeUser.language eq 'en-US' ? 'selected' : ''}>English</option>
                                                    <option value="fr-FR" ${activeUser.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                                    <option value="es-ES" ${activeUser.language eq 'es-ES' ? 'selected' : ''}>Spanish</option>
                                                </select>
                                                <c:if test="${not empty results.languageError}">
                                                    <div class="invalid-feedback">${results.languageError}</div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="row mt-3">
                                            <!-- Time Zone -->
                                            <div class="col-md-6">
                                                <label for="timeZoneInput" class="form-label">Time Zone</label>
                                                <select name="timeZoneInput" id="timeZoneInput" class="form-select">
                                                    <!-- Populate time zones dynamically -->
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-5 text-right">
                                <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
