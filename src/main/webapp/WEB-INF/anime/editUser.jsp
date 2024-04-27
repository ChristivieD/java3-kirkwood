<%@include file="/WEB-INF/anime/top.jsp"%>
<section class="vh-100 justify-content-center" style="background-color: #f4f5f7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-md-6">
                <div class="card" style="border-radius: .5rem; width: 45rem">
                    <form action="${appURL}/editUser?user_id=${user.user_id}" method="POST">
                        <!-- User Information Card -->
                        <div class="card mb-3" style="border-radius: .5rem;">
                            <!-- Card Content -->
                        </div>
                    <div class="row g-0">
                        <div class="col-md-4 gradient-custom text-center text-white"
                             style="border-top-left-radius: .5rem; width: 45rem; border-bottom-left-radius: .5rem; background: linear-gradient(45deg, #FF69B4, #FF6347, #FFFFFF)">
                            <img src="${appURL}/images/personal_project/${user.picture}"
                                 alt="${user.picture}" class="img-fluid my-5" style="width: 80px;" />
                            <h5>${user.username}</h5>
                            <i class="far fa-edit mb-5"></i>
                        </div>
                        <div class="col-md-8">
                            <div class="card-body p-4">
                                <h4>Edit User</h4>
                                <hr class="mt-0 mb-4">
                                <div class="row pt-1">
                                    <div class="col-6 mb-3">
                                        <label for="userNameInput">Username:</label>
                                        <input type="text" id="userNameInput" name="userNameInput" value="${user.username}">
                                        <c:if test="${not empty results.userNameError}">
                                            <span style="color: red;">${results.userNameError}</span>
                                        </c:if>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <label for="emailInput">Email:</label>
                                        <input type="email" id="emailInput" name="emailInput" value="${user.email}">
                                        <c:if test="${not empty results.emailError}">
                                            <span style="color: red;">${results.emailError}</span>
                                        </c:if>
                                    </div>
                                    <div class="col-6 mb-3">
                                        <label for="languageInput" class="form-label">Language</label>
                                        <select name="languageInput" id="languageInput" class="form-select <c:if test="${not empty results.languageError}">is-invalid</c:if>">
                                            <option value="en-US" ${user.language eq 'en-US' ? 'selected' : ''}>English</option>
                                            <option value="fr-FR" ${user.language eq 'fr-FR' ? 'selected' : ''}>French</option>
                                            <option value="es-MX" ${user.language eq 'es-MX' ? 'selected' : ''}>Spanish</option>
                                        </select>
                                        <c:if test="${not empty results.languageError}">
                                            <div class="invalid-feedback">
                                                    ${results.languageError}
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="statusInput" class="form-label">Status</label>
                                        <select name="statusInput" id="statusInput" class="form-select <c:if test="${not empty results.statusError}">is-invalid</c:if>">
                                            <option value="inactive" ${user.status eq 'inactive' ? 'selected' : ''}>Inactive</option>
                                            <option value="active" ${user.status eq 'active' ? 'selected' : ''}>Active</option>
                                            <option value="locked" ${user.status eq 'locked' ? 'selected' : ''}>Locked</option>
                                        </select>
                                        <c:if test="${not empty results.statusError}">
                                            <div class="invalid-feedback">
                                                    ${results.statusError}
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="privilegesInput">Privileges:</label>
                                        <select name="privilegesInput" id="privilegesInput">
                                            <option value="user" ${user.privileges eq 'user' ? 'selected' : ''}>User</option>
                                            <option value="premium" ${user.privileges eq 'premium' ? 'selected' : ''}>Premium User</option>
                                            <option value="admin" ${user.privileges eq 'admin' ? 'selected' : ''}>Admin</option>
                                        </select>
                                        <c:if test="${not empty results.privilegesError}">
                                            <span style="color: red;">${results.privilegesError}</span>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-end">
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </div>
                                <div class="d-flex justify-content-start">
                                    <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                                    <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                                    <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
