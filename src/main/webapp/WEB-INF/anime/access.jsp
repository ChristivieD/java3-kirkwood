<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="vh-100 d-flex justify-content-center align-items-center">
    <section class="p-0 d-flex align-items-center justify-content-center position-relative overflow-hidden" style="border-radius: 1rem; background: linear-gradient(135deg,#007bff,#ff4500, #ffffff);  width: 70%;">
        <div class="container py-5">
            <div class="row ">
                <div class="col-md-6 col-sm-12 text-black">
                    <div class="col-12 col-lg-8 m-auto">
                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                        <span class="h1 fw-bold mb-0">Welcome to View Anime!!</span>
                    </div>
                    <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
                        <c:choose>
                            <c:when test="${not empty results.loginError}">
                                <p class="alert alert-danger">
                                        ${results.loginError}
                                </p>
                            </c:when>
                            <c:when test="${not empty flashMessageWarning}">
                                <p class="alert alert-warning">
                                        ${flashMessageWarning}
                                </p>
                                <c:remove var="flashMessageWarning" scope="session"></c:remove>
                            </c:when>
                            <c:otherwise>
                                <p class="lead mb-4">Please sign in to your account.</p>
                            </c:otherwise>
                        </c:choose>
                        <%-- Form Start--%>
                        <form action="${appURL}/access" method="post" style="width: 23rem;">
                            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign in</h3>
                            <!-- Email -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="inputEmail">Email address</label>
                                <div class="input-group input-group-lg">
                                    <input type="email" id="inputEmail" class="form-control form-control-lg" name="inputEmail" value="${results.email}"/>
                                </div>
                            </div>
                            <!-- Password -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="inputPassword1">Password</label>
                                <div class="input-group input-group-lg">
                                    <input type="password" id="inputPassword1" class="form-control form-control-lg" name="inputPassword1"  value="${results.password1}"/>
                                </div>
                            </div>
                            <!-- Check box -->
                            <div class="mb-4">
                                <div class="form-check">
                                    <input type="checkbox" class="form-check-input" id="checkbox-1" name="checkbox-1" value="yes" <c:if test="${results.remember eq 'yes'}">checked</c:if>>
                                    <label class="form-check-label" for="checkbox-1">Remember me for 7 days</label>
                                </div>
                            </div>
                            <!-- Button -->
                            <div class="pt-1 mb-4">
                                <button class="btn btn-darkred btn-lg btn-block" type="submit">Sign In</button>
                            </div>
                            <input type="hidden" name="redirect" value="${redirect}">
                        </form>

                    </div>
                    <!-- Form END -->

                    <!-- Sign in link -->
                    <div class="mt-4 text-center">
                        <span>Forgot your password? <a href="${appURL}/password-reset">Reset it here</a></span>
                    </div>
                </div>
                <div class="col-md-6 col-lg-5 d-flex align-items-center justify-content-center">
                    <img src="${appURL}/images/personal_project/test.webp"
                         alt="Login image" class="img-fluid" style="max-width: 300px; height: auto; object-position: left;">
                </div>
            </div>
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>