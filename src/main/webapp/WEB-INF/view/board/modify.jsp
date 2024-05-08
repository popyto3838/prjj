<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

</head>
<body>
<c:import url="/WEB-INF/fragment/navbar.jsp"></c:import>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">

            <h3 class="mb-4">${board.id}번 게시물 수정</h3>
            <form action="/modify" method="post">
                <div>
                    <input type="hidden" name="id" value="${board.id}">
                </div>
                <div class="mb-3">
                    <label for="inputTitle">제목</label>
                    <input class="form-control" id="inputTitle" name="title" type="text" value="${board.title}"
                           required>
                </div>
                <div class="mb-3">
                    <label for="inputContent">내용</label>
                    <textarea class="form-control" id="inputContent" name="content" id="" cols="30" rows="10"
                              required>${board.content}</textarea>
                </div>
                <div class="mb-3">
                    <label for="inputWriter">작성자</label>
                    <input class="form-control" id="inputWriter" name="writer" type="text" value="${board.writer}"
                           required>
                </div>
                <div>
                    <button class="btn btn-warning">수정</button>
                </div>
            </form>

        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
