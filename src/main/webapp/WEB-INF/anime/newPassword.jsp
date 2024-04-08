<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container">
    <section class="p-0 d-flex align-items-center position-relative overflow-hidden" style="border-radius: 1rem; background-color: #9A616D;">
        <div class="container py-5">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-8 m-auto">
                    <div class="card" style="border-radius: 1rem 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <h2>${pageTitle}</h2>
                                <div class="card-body p-4 p-lg-5 text-black">
                                    <!-- Form START -->
                                    <form action="${appURL}/newPassword" method="post">
                                        <div class="d-flex align-items-center mb-3 pb-1">
                                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                            <span class="h1 fw-bold mb-0">View Anime</span>
                                        </div>
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Create a new password.</h5>
                                        <%--Password--%>
                                        <div class="form-outline mb-4">
                                            <label for="inputPassword1" class="form-label" >Password</label>
                                            <div class="input-group input-group-lg">
                                                <input type="password" id="inputPassword1" class="form-control form-control-lg <c:if test="${not empty results.password1Error}">is-invalid</c:if>" name="inputPassword1"  value="${results.password1}"/>
                                                <c:if test="${not empty results.password1Error}">
                                                    <div class="invalid-feedback">
                                                            ${results.password1Error}
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <%--confirm password--%>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="inputPassword2">Confirm Password</label>
                                            <div class="input-group input-group-lg">
                                                <input type="password" id="inputPassword2" class="form-control form-control-lg <c:if test="${not empty results.password2Error}">is-invalid</c:if>" name="inputPassword2"  value="${results.password2}"/>
                                                <c:if test="${not empty results.password2Error}">
                                                    <div class="invalid-feedback">
                                                            ${results.password2Error}
                                                    </div>
                                                </c:if></div>
                                        </div>
                                        <%--Button--%>
                                        <div class="pt-1 mb-4">
                                            <button class="btn btn-darkred" type="submit">Sign up</button>
                                        </div>
                                    </form>
                                    <%--Form End--%>
                                    <%-- Sign in link --%>
                                    <div class="mt-4 text-center">
                                        <span>Already have an account? <a href="${appURL}/login">Log in here</a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
