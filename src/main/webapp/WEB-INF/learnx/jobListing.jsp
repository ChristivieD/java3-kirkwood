<%@include file="top.jsp"%>
<main>
    <div class="container">
        <!--   loop start here -->
        <c:forEach items="${jobListings}" var="jobListing">
            <div class="row border border-dark my-4 ">
                <div class="col-md-6 text-md-start d-flex flex-column " >
                    <div class="mt-2">
                        <strong>${jobListing.department_name}</strong>
                        <span class="badge bg-success">Badge</span>
                        <span class="badge bg-warning text-dark">Badge</span>
                    </div>
                    <h4 class="my-2">${jobListing.department_name}</h4>
                    <div class="mb-2">
                        <span class="me-2">${jobListing.description}</span>
                        <span class="me-2">${jobListing.feature}</span>
                        <span class="me-2">${jobListing.position}</span>
                        <span class="me-2">${jobListing.posted_at}</span>
                        <span class="me-2">${jobListing.contract}</span>
                        <span>${jobListing.location}</span>
                    </div>
                </div>
                <div class="col-md-6 text-md-end d-flex justify-content-md-end align-items-md-center">
                    <div class="mb-2">
                        <span class="badge rounded-pill bg-info text-dark">Tag</span>
                        <span class="ms-2 badge rounded-pill bg-secondary">Tag</span>
                        <span class="ms-2 badge rounded-pill bg-dark">Tag</span>
                    </div>
                    <a href="${appURL}/application?job_id=${jobListing.job_id}" class="btn btn-primary">Apply</a>
                </div>
            </div>
        </c:forEach>
    </div>
</main>
<%@include file="bottom.jsp"%>