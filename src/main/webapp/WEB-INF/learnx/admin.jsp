<%@include file="top.jsp"%>
<main>
    <%@include file="left-side-bar-header.jsp"%>
    <div class="container mt-5">
        <div class="row">
            <%@include file="left-side-bar.jsp"%>
            <div class="col-md-6">
                <div class="col-xl-9">
                    <div class="card bg-transparent border rounded-3">
                        <!-- Card header START -->
                        <div class="card-header bg-transparent border-bottom">
                            <h3 class="mb-0">Admin Dashboard</h3>
                        </div>
                        <!-- Card header END -->
                        <%@include file="flashMessage.jsp"%>
                        <!-- Card body START -->
                        <form action="${appURL}/application?job_id=${jobListing.job_id}" method="get"></form>
                        <div class="card-body">
                            <div class="table-responsive border-0">
                                <table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                                    <thead>
                                    <tr>
                                        <th scope="col" class="border-0 rounded-start"> Admin Dashboard</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <forEach items="$">
                                        <tr>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <div class="mb-0 ms-2">
                                                        <h6><a href="${appURL}/all-users">See All Users</a></h6>
                                                        <h6><a href="${appURL}/application?job_id=${jobListing.job_id}">List of job</a></h6>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr></forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div><%-- End right col --%>
                    </div><%-- End row --%>
                </div><%-- End container --%>
            </div>
</main>
<%@include file="bottom.jsp"%>