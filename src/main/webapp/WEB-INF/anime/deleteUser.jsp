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
                        <h6>If you delete your account, you will lose your all data.</h6>
                        <form action="${appURL}/delete" method="post">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="p-3 py-5">
                                        <div class="row mt-3">
                                            <!-- Email -->
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="inputEmail">Enter your email to confirm account deletion</label>
                                                <div class="input-group input-group-lg">
                                                    <input type="email" id="inputEmail" class="form-control <c:if test="${not empty results.emailError}">is-invalid</c:if>" name="inputEmail" value="${results.email}"/>
                                                    <c:if test="${not empty results.emailError }"><div class="invalid-feedback">${results.emailError}</div></c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-5 text-right">
                                <button class="btn btn-danger mb-0" type="submit">Delete my account</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
