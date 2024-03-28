<%@include file="top.jsp"%>
<main>
    <%@include file="left-side-bar-header.jsp"%>
    <div class="container">
        <div class="row">
            <%@include file="left-side-bar.jsp"%>

            <div class="col-xl-9">
                <div class="card border rounded-3">
                    <div class="card-header border-bottom">
                        <h3 class="card-header-title">${pageTitle}</h3>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty flashMessageSuccess}">
                            <div class="alert alert-success">
                                ${fashMessageSuccess}
                            </div>
                            <c:remove var="fashMessageSuccess"></c:remove>
                        </c:if>
                        <c:if test="${not empty flashMessageWarning}">
                            <div class="alert alert-success">
                                ${fashMessageWarning}
                            </div>
                            <c:remove var="fashMessageWarning"></c:remove>
                        </c:if>
                        <form action="${appURL}/edit-profile" method="POST">
                            <div class="row g-4">
                                <!-- First Name -->
                                <div class="col-md-6">
                                    <label for="firstNameInput" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="firstNameInput" name="firstNameInput" value="${fn:escapeXml(activeUser.firstName)}">
                                    <c:if test="${not empty results.firstNameError}"><div class="invalid-feedback">${results.firstNameError}
                                    </div>
                                    </c:if>
                                </div>
                                <!-- Last Name -->
                                <div class="col-md-6">
                                    <label for="lastNameInput" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lastNameInput" name="lastNameInput" value="${fn:escapeXml(activeUser.lastName)}">
                                    <c:if test="${not empty results.lastNameError}">
                                        <div class="invalid-feedback">${results.lastNameError}
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
                                    <c:if test="${not empty results.languageError }">
                                        <div class="invalid-feedback">${results.languageError}
                                        </div>
                                    </c:if>
                                </div>
                                <!-- time zone menu-->
                                <div class="col-md-6">
                                    <label for="timeZoneInput" class="form-label">TIme Zone</label>
                                    <select name="timeZoneInput" id="timeZoneInput" class="form-select">
                                        <option value="en-US" ${activeUser.language eq 'en-US' ? 'selected' : ''}>English</option>
                                        <option value="fr-FR" ${activeUser.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                        <option value="es-ES"${activeUser.language eq 'es-ES' ? 'selected' : ''}>Spanish</option>
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
<%@include file="bottom.jsp"%>
