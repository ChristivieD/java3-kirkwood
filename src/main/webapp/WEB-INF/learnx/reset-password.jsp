<%@include file="top.jsp"%>
<main class="container">
    <section class="p-0 d-flex align-items-center position-relative overflow-hidden">
        <div class="container-fluid">
            <div class="row">
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
                            <form action="${appURL}/reset-password" method="post">
                                <!-- Email -->
                                <div class="mb-4">
                                    <label for="inputEmail1" class="form-label">Email address *</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-envelope-fill"></i></span>
                                        <input type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="E-mail" id="inputEmail1" name="inputEmail1"  value="${results.email}">
                                    </div>
                                </div>

                                <!-- Button -->
                                <div class="align-items-center mt-0">
                                    <div class="d-grid">
                                        <button class="btn btn-orange mb-0" type="submit">Submit</button>
                                    </div>
                                </div>
                            </form>
                            <!-- Form END -->

                            <!-- Sign in link -->
                            <div class="mt-4 text-center">
                                <span><a href="${appURL}/signin">Back to sign in</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</main>
<%@include file="bottom.jsp"%>