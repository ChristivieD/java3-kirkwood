<%@include file="/WEB-INF/anime/top.jsp"%>
<main>
    <div class="container mt-5">
        <h2> Added Anime Confirmation</h2>
        <form action="${appURL}/animeAdding" method="post">
            input type="hidden" name="animeId" ;%>">
            <div class="mt-5 text-right">
                <button class="btn btn-danger mb-0" type="submit">Add</button>
                <a href="/animeList"> confirm</a>
            </div>
        </form>
    </div>
</main>
<%@include file="/WEB-INF/anime/bottom.jsp"%>
