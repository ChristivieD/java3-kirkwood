<%@include file="/WEB-INF/anime/top.jsp"%>
<main class="container mt-5"><!-- Added mt-5 for top margin -->
    <c:choose>
        <c:when test="${not empty flashMessageSuccess}">
            <div class="alert alert-success mb-2">
                    ${flashMessageSuccess}
            </div>
            <c:remove var="flashMessageSuccess" scope="session"></c:remove>
        </c:when>
        <c:when test="${not empty flashMessageWarning}">
            <div class="alert alert-warning mb-2">
                    ${flashMessageWarning}
            </div>
            <c:remove var="flashMessageWarning" scope="session"></c:remove>
        </c:when>
    </c:choose>
    <div class="d-flex justify-content-center">
        <div class="card" style="width: 80vw; max-width: 100rem;">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${appURL}/images/personal_project/test2.jpg" class="d-block w-100" alt="Graduation hat">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Fate gate stay</h5>
                            <p>Through the Gate of Babylon, Gilgamesh can instantly summon swords, spears, axes, hammers,
                                and all other types of weapons stored inside the treasury.
                                To average heroes and servants, the Gate of Babylon is actually a useless Noble Phantasm.</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="${appURL}/images/personal_project/test3.jpg" class="d-block w-100" alt="Books">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>One Piece</h5>
                            <p> In a seafaring world, a young pirate captain sets out with his crew to attain the title
                                of Pirate King, and to discover the mythical treasure known as 'One Piece. '</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="${appURL}/images/personal_project/fantasy.jpg" class="d-block w-100" alt="Books">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Inuyasha</h5>
                            <p>Inuyasha is a hybrid of human and dog yōkai who first appears sealed to a tree in the feudal world.
                                When a girl named Kagome Higurashi is being chased by a yōkai, Inuyasha
                                convinces her to free him so that he might eliminate the enemy.</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
    <!-- Featured Anime Section -->
    <section class="container my-5">
        <h2 class="mt-5 mb-4">Trending</h2>
        <div class="row flex-nowrap overflow-auto">
            <!-- Horizontal card list -->
            <div class="col-md-4 anime-card"> <!-- Changed to col-md-3 for one-quarter width -->
                <div class="card" style="width: 70%;"> <!-- Adjusted card width to 100% -->
                    <img src="${appURL}/images/personal_project/action.jpg" class="card-img-top" alt="Movie 1">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 1</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <!-- Repeat for other cards -->
            <div class="col-md-4 anime-card">
                <div class="card" style="width: 65%;">
                    <img src="${appURL}/images/personal_project/blue.webp" class="card-img-top" alt="Movie 2">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 2</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 anime-card">
                <div class="card " style="width: 65%;">
                    <img src="${appURL}/images/personal_project/kimetsu.jpg" class="card-img-top" alt="Movie 3">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 3</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 anime-card">
                <div class="card " style="width: 65%;">
                    <img src="${appURL}/images/personal_project/naruto.jpg" class="card-img-top" alt="Movie 3">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 3</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 anime-card">
                <div class="card " style="width: 63%;">
                    <img src="${appURL}/images/personal_project/solo.jpg" class="card-img-top" alt="Movie 3">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 3</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 anime-card">
                <div class="card " style="width: 70%;">
                    <img src="${appURL}/images/personal_project/shugo.jpg" class="card-img-top" alt="Movie 3">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 3</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 anime-card">
                <div class="card " style="width: 70%;">
                    <img src="${appURL}/images/personal_project/action.jpg" class="card-img-top" alt="Movie 3">
                    <div class="card-body">
                        <h5 class="card-title">Movie Title 3</h5>
                        <a href="#" class="btn btn-primary">Watch Now</a>
                    </div>
                </div>
            </div>
            <!-- Add more movie cards here -->
        </div>
    </section>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
