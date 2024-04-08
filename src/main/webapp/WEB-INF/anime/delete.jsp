<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container">
    <jsp:include page="leftSideBarHeader.jsp"> </jsp:include>
    <!-- =======================
    Page content START -->
    <section class="pt-0">
        <div class="container">
            <div class="row">

                <jsp:include page="leftSideBar.jsp"></jsp:include>

                <!-- Main content START -->
                <div class="col-xl-9">
                    <!-- Title and select START -->
                    <div class="card border bg-transparent rounded-3 mb-0">
                        <!-- Card header -->
                        <div class="card-header bg-transparent border-bottom">
                            <h3 class="card-header-title mb-0">Delete Account</h3>
                        </div>
                        <!-- Card body -->
                        <div class="card-body">
                            <h6>If you delete your account, you will lose your all data.</h6>
                            <form method="POST" action="${appURL}/delete">
                                <%--Email--%>
                                <div class="form-outline mb-4">
                                    <label for="inputEmail" class="form-label" >Enter your email address to confirm account deletion</label>
                                    <div class="input-group input-group-lg">
                                        <input type="email" class="form-control form-control-lg <c:if test="${not empty results.emailError}">is-invalid</c:if>"  id="inputEmail"  name="inputEmail" value="${results.email}"/>
                                        <c:if test="${not empty results.emailError}">
                                            <div class="invalid-feedback">
                                                    ${results.emailError}
                                            </div>
                                        </c:if>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-danger mb-0">Delete my account</button>
                            </form>
                        </div>
                    </div>
                    <!-- Title and select END -->
                </div>
                <!-- Main content END -->
            </div><!-- Row END -->
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>