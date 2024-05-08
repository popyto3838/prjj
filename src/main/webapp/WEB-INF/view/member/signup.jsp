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
            <h3 class="mb-3">회원가입</h3>
            <form action="/member/signup" method="post" onsubmit="return checkValues()">
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">이메일</label>
                    <div class="input-group">

                        <input class="form-control" name="email" id="inputEmail" type="text" required>
                        <button onclick="emailCheck()" type="button" id="buttonEmailCheck"
                                class="btn btn-outline-secondary">중복확인
                        </button>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">패스워드</label>
                    <input oninput="passwordCheck()" class="form-control" name="password" id="inputPassword"
                           type="password" required>
                </div>
                <div class="mb-3">
                    <label for="inputPasswordCheck" class="form-label">패스워드확인</label>
                    <input oninput="passwordCheck()" class="form-control" id="inputPasswordCheck" type="password"
                           required>
                    <div class="form-text" id="passwordMessage"></div>
                </div>
                <div class="mb-3">
                    <label for="inputNickName" class="form-label">닉네임</label>
                    <input class="form-control" name="nickName" id="inputNickName" type="text" required>
                </div>
                <div class="mb-3">
                    <button class="btn btn-secondary">가입</button>
                </div>

            </form>

        </div>
    </div>
</div>

<script>

    async function emailCheck() {
        const emailValue = document.querySelector("#inputEmail").value;
        const url = "/member/email?email=" + emailValue;

        //ajax 요청
        const response = await fetch(encodeURI(url));

        //응답처리
        alert(await response.text());

    }


    function passwordCheck() {
        const password = document.querySelector("#inputPassword").value;
        const passwordCheck = document.querySelector("#inputPasswordCheck").value;

        if (password != passwordCheck) {

            document.querySelector("#passwordMessage").textContent = "패스워드가 일치하지 않습니다.";
        } else {
            document.querySelector("#passwordMessage").textContent = "";
        }

    }
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>
</html>
