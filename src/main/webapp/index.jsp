<%@include file="WEB-INF/shared/top.jsp"%>
    <title>Java 3 Web Applications</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${appURL}css/loading.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container py-4 text-center">
    <h1 class="my-4">Java 3 Web Applications</h1>
    <div class="row justify-content-center" style="text-align: center;">
        <div class="col-xs-12 col-sm-6 col-lg-5 mb-4">
            <h3>Personal Projects</h3>
            <div class="list-group">
                <a href="${appURL}/email" class="list-group-item list-group-item-action">Assignment 1-Email</a>
                <a href="${appURL}/chat" class="list-group-item list-group-item-action">Chat App</a>
                <a href="${appURL}/anime" class="list-group-item list-group-item-action">Anime</a>
                <a href="${appURL}/users" class="list-group-item list-group-item-action">Anime Users</a>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-lg-5">
            <h3>Class Demos</h3>
            <div class="list-group">
                <a href="${appURL}/learnx" class="list-group-item list-group-item-action">LearnX Home</a>
                <a href="${appURL}/all-users" class="list-group-item list-group-item-action">LearnX Users</a>
                <a href="${appURL}/artist" class="list-group-item list-group-item-action">Artist Json</a>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.js"></script>
<script src="js/loading.js"></script>
<%@include file="WEB-INF/shared/bottom.jsp"%>
