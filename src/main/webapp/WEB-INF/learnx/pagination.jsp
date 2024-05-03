<%--                    Start Pagination--%>

<nav aria-label="pagination-nav">
    <ul class="pagination">
        <li class="page-item <c:if test="${page eq 1}">disabled</c:if>">
            <a class="page-link" <c:if test="${page ne 1}">href="${appURL}/courses?page=${page - 1}"</c:if> <c:if test="${page eq 1}">tabindex="-1" aria-disabled="true"</c:if>>Previous</a>
        </li>

        <c:forEach var="i" begin="${beginPage}" end="${endPage}">
            <li class="page-item <c:if test="${page eq i}">active</c:if>">
                <a class="page-link" href="${appURL}/courses?page=${i}">${i}</a>
            </li>
        </c:forEach>

        <li class="page-item <c:if test="${page eq totalPages}">disabled</c:if>">
            <a class="page-link" <c:if test="${page ne totalPages}">href="${appURL}/courses?page=${page + 1}"</c:if> <c:if test="${page eq totalPages}">tabindex="-1" aria-disabled="true"</c:if>>Next</a>
        </li>
    </ul>
</nav>

<%--                    Stop Pagination--%>