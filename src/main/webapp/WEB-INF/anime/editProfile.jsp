<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <%@include file="leftSideBar.jsp"%>
    <div class=" container">
        <div class="row">
            <%@include file="leftSideBar.jsp"%>
            <div class="col-xl-9">
                <div class="card border rounded-3">
                    <div class="card-header border-bottom">
                        <h3 class="card-header-title">${pageTitle}</h3>
                    </div>
                    <div class="card-body">
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

                        <form action="${appURL}/edit-profile" method="POST">
                            <div class="row g-4">
                                <!-- User Name -->
                                <div class="col-md-6">
                                    <label for="userNameInput" class="form-label">User Name</label>
                                    <input type="text" class="form-control" id="userNameInput" name="userNameInput" value="${fn:escapeXml(activeUser.userName)}">
                                    <c:if test="${not empty results.userNameError}"><div class="invalid-feedback">${results.userNameError}
                                    </div>
                                    </c:if>
                                </div>
                                <!-- select menu-->
                                <div class="col-md-6">
                                    <label for="languageInput" class="form-label">Language</label>
                                    <select name="languageInput" id="languageInput" class="form-select is-invalid <c:if test="${not empty results.languageError}"></c:if>">
                                        <option value="en-US" ${activeUser.language eq 'en-US' ? 'selected' : ''}>English</option>
                                        <option value="fr-FR" ${activeUser.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                        <option value="es-ES"${activeUser.language eq 'es-ES' ? 'selected' : ''}>Spanish</option>
                                    </select>
                                    <c:if test="${not empty results.languageError}">
                                        <div class="invalid-feedback">${results.languageError}
                                        </div>
                                    </c:if>
                                </div>
                                <!-- time zone menu-->
                                <div class="col-md-6">
                                    <label for="timeZoneInput" class="form-label">Time Zone</label>
                                    <select name="timeZoneInput" id="timeZoneInput" class="form-select">
                                    </select>
                                </div>
                                <!-- Save button -->
                                <div class="d-sm-flex justify-content-end">
                                    <button type="submit" class="btn btn-primary mb-0">Save changes</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>