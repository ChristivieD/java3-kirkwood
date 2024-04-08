<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="vh-100 d-flex justify-content-center align-items-center">
    <section class="p-0 d-flex align-items-center justify-content-center position-relative overflow-hidden" style="border-radius: 1rem; background: linear-gradient(135deg,#007bff,#ff4500, #ffffff);  width: 70%;">
        <div class="container py-5">
            <div class="row ">
                <div class="col-12 col-lg-8 m-auto">
                    <div class="row my-5">
                        <div class="col-sm-10 col-xl-8 m-auto">
                            <h2>${pageTitle}</h2>

                            <c:choose>
                                <c:when test="${not empty results.passwordResetMsg}">
                                    <p class="alert alert-warning">
                                            ${results.passwordResetMsg}
                                    </p>
                                </c:when>
                                <c:otherwise>
                                    <p class="lead mb-4">Enter your email address</p>
                                </c:otherwise>
                            </c:choose>

                            <!-- Form START -->
                            <form action="${appURL}/password-reset" method="post">
                                <!-- Email -->
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="inputEmail">Email address</label>
                                    <div class="input-group input-group-lg">
                                        <input type="email" id="inputEmail" class="form-control form-control-lg" name="inputEmail" value="${results.email}"/>
                                    </div>
                                </div>

                                <!-- Button -->
                                <div class="align-items-center mt-0">
                                    <button class="btn btn-darkred btn-lg btn-block" type="submit">Submit</button>
                                </div>
                            </form>
                            <!-- Form END -->

                            <!-- Sign in link -->
                            <div class="mt-4 text-center">
                                <span><a href="${appURL}/access">Back to sign in</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>