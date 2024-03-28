<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container">
    <c:choose>
        <c:when test="${not empty flashMessageSuccess}">
            <div class="alert alert-success mb-2">
                    ${flashMessageSuccess}
            </div>
            <c:remove var="fashMessageSuccess" scope="session"></c:remove>
        </c:when>
        <c:when test="${not empty flashMessageWarning}">
            <div class="alert alert-warning mb-2">
                    ${flashMessageWarning}
            </div>
            <c:remove var="flashMessageWarning" scope="session"></c:remove>
        </c:when>
        <c:when test="${not empty flashMessageDanger}">
            <div class="alert alert-danger mb-2">
                    ${flashMessageDanger}
            </div>
            <c:remove var="flashMessageDanger" scope="session"></c:remove>
        </c:when>
    </c:choose>

    <div class="row row-cols-1 row-cols-md-3 gx-4 gy-4">
        <div class="col" style="width: 20rem ">
            <div class="card" style="width: 18rem " >
                <img src="${appURL}/images/personal_project/action.jpg" class="card-img-top" alt="Jujutsu">
                <div class="card-body">
                    <h5 class="card-title">Jujutsu Kaisen</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 20rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/kimetsu.jpg" class="card-img-top" alt="kimetsu">
                <div class="card-body">
                    <h5 class="card-title">Kimetsu no yaiba</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
        <div class="col"style="width: 20rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/solo.jpg" class="card-img-top" alt="solo">
                <div class="card-body">
                    <h5 class="card-title">Solo Leveling</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 20rem ">
            <div class="card">
                <img src="${appURL}/images/personal_project/romance.jpg" style="height: 450px" alt="love">
                <div class="card-body">
                        <h5 class="card-title">Love and Rivalery</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/comedy.jpeg" class="card-img-top" alt="College">
                <div class="card-body">
                    <h5 class="card-title">Le College de fou fou fou</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/blue.webp" class="card-img-top" alt="Blue">
                <div class="card-body">
                    <h5 class="card-title">Blue Lock</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/classroom.jpe" style="height: 400px" alt="classroom">
                <div class="card-body">
                    <h5 class="card-title">Classroom of the elite</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/fullmetal.jpe" style="height: 400px" alt="fullmetal">
                <div class="card-body">
                    <h5 class="card-title">Fullmetal Alchemist</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/naruto.jpg" class="card-img-top" alt="naruto">
                <div class="card-body">
                    <h5 class="card-title">Naruto</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col" style="width: 22rem ">
            <div class="card" >
                <img src="${appURL}/images/personal_project/shugo.jpg" class="card-img-top" alt="Shugo">
                <div class="card-body">
                    <h5 class="card-title">Shugo Chara</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>