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
                        <h2>Delete Anime Confirmation.</h2>
                        <p>Are you sure you want to delete  this anime<strong>${anime.title}</strong>?</p>
                        <form action="${appURL}/deleteAnime" method="post">
                            <input type="hidden" name="animeId" value="<%=request.getParameter("anime_id")%>">
                            <div class="mt-5 text-right">
                                <button class="btn btn-danger mb-0" type="submit">Yes, delete</button>
                                <a href="${appURL}/animeList"> Cancel</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
