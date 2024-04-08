<div class="container">
    <div class="row mb-4">
        <div class="col-12">
            <hr class="d-xl-none">
            <div class="col-12 col-xl-3 d-flex justify-content-end align-items-center">
                <button class="btn btn-primary d-xl-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
            <hr>
            <div class="card">
                <div class="card-body">
                    <h1 class="card-title"> ${fn:escapeXml(activeUser.userName)}</h1>
                    <ul class="list-inline">
                        <li class="list-inline-item"><i class="fas fa-star"></i>Member since 2015</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
