<%@include file="top.jsp"%>
<main>
    <div class="container">
        <section class="container my-5">
            <form action="${appURL}/application" method="get">
                <div class="container">
                    <div class="card">
                        <forEach items="${jobListings}" var="jobListing">
                            <div class="card-body">
                                <h5 class="card-title">${jobListing.department_name}</h5>
                                <p class="card-text">${jobListing.description}</p>
                                <form action="${appURL}/application" method="post">
                                    <input type="hidden" name="jobId" value="${jobListing.job_id}">
                                    <div class="form-group">
                                        <label for="firstName">First Name</label>
                                        <input type="text" class="form-control" id="firstName" name="firstName" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last Name</label>
                                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail">Email</label>
                                        <input type="text" class="form-control" id="inputEmail" name="inputEmail" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Apply</button>
                                </form>
                            </div>
                    </div>
                        </forEach>
                </div>
            </form>
        </section>
    </div>
</main>



