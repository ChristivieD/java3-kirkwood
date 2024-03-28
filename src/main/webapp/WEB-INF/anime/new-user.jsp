<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container">
    <section class="p-0 d-flex align-items-center position-relative overflow-hidden" style="border-radius: 1rem; background-color: #9A616D;">
        <div class="container py-5">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-8 m-auto">
                    <div class="card" style="border-radius: 1rem 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-5 d-flex align-items-center justify-content-center" >
                                <img src="${appURL}/images/personal_project/chris.jpg"
                                     alt="login form" class="img-fluid" style="border-radius: 1rem 1rem;  max-width: 100%; height:auto; " />
                            </div>
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">
                                    <!-- Form START -->
                                    <form action="${appURL}/new-user" method="post">
                                        <div class="d-flex align-items-center mb-3 pb-1">
                                            <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                            <span class="h1 fw-bold mb-0">View Anime</span>
                                        </div>
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign in to your account</h5>
                                        <%--Email--%>
                                        <div class="form-outline mb-4">
                                            <label for="inputEmail" class="form-label" >Email address</label>
                                            <div class="input-group input-group-lg">
                                                <input type="email" class="form-control form-control-lg <c:if test="${not empty results.emailError}">is-invalid</c:if>"  id="inputEmail"  name="inputEmail" value="${results.email}"/>
                                                <c:if test="${not empty results.emailError}">
                                                    <div class="invalid-feedback">
                                                            ${results.emailError}
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
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
                                        <%--confirm assword--%>
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
                                        <!-- Check box -->
                                        <div class="mb-4">
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input <c:if test="${not empty results.agreeError}">is-invalid</c:if>" id="checkbox-1" name="checkbox-1" value="agree" <c:if test="${results.agree eq 'true'}">checked</c:if>>
                                                <label class="form-check-label" for="checkbox-1">By signing up, you agree to the <a href="${appURL}/terms">terms and conditions</a></label>
                                                <c:if test="${not empty results.agreeError}">
                                                    <div class="invalid-feedback">
                                                            ${results.agreeError}
                                                    </div>
                                                </c:if>
                                            </div>
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
