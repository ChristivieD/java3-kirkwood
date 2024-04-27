<div class="col-xl-3">
    <!-- Responsive offcanvas body START -->
    <div class="offcanvas-xl offcanvas-end" tabindex="-1" id="offcanvasSidebar">
        <!-- Offcanvas header -->
        <div class="offcanvas-header bg-light">
            <button  type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasSidebar" aria-label="Close"></button>
        </div>
        <!-- Offcanvas body -->
        <div class="offcanvas-body p-3 p-xl-0">
            <div class=" border rounded-3 p-3 w-100" style="background: linear-gradient(45deg, rgba(255,0,0,0.5), rgba(255,0,0,0));" >
                <!-- Dashboard menu -->
                <div class="list-group list-group-dark list-group-borderless">

                    <c:if test="${activeUser.privileges eq 'user'}">
                        <a class="list-group-item" href="${appURL}/user"><i class="fas fa-book-open-reader me-2"></i>User Dashboard</a>
                    </c:if>
                    <c:if test="${activeUser.privileges eq 'premium'}">
                        <a class="list-group-item" href="${appURL}/premium"><i class="fas fa-book-open-reader me-2"></i>Premium Dashboard</a>
                    </c:if>
                    <c:if test="${activeUser.privileges eq 'admin'}">
                        <a class="list-group-item" href="${appURL}/admin"><i class="fas fa-book-open-reader me-2"></i>Admin Dashboard</a>
                    </c:if>

                    <a class="list-group-item" href="${appURL}/editProfile"><i class="fas fa-user-pen me-2"></i>Edit Profile</a>
                    <a class="list-group-item" href="${appURL}/deleteUser"><i class="bi bi-trash fa-fw me-2"></i>Delete Account</a>
                </div>
            </div>
        </div><%--   End Offcanvas body     --%>
    </div><%--   End Offcanvas     --%>
</div><%--   End left 1/4 side bar     --%>