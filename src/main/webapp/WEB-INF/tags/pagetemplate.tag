<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <img src="${pageContext.request.contextPath}/images/FOGLogo.png" width="75px;" class="img-fluid"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <c:if test="${sessionScope.user.username!=null}">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/buildACarport.jsp">Byg en
                            Carport</a>
                    </c:if>
                    <c:if test="${sessionScope.user.username!=null}">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/myOrders.jsp">Mine
                            Ordre</a>
                    </c:if>
                    <c:if test="${sessionScope.user.username.equalsIgnoreCase('admin')}">
                        <a class="nav-item nav-link"
                           href="${pageContext.request.contextPath}/admin.jsp">${sessionScope.user.username}</a>
                    </c:if>
                    <c:if test="${sessionScope.user.username!=null&&!sessionScope.user.username.equalsIgnoreCase('admin')}">
                        <a class="nav-item nav-link"
                           href="${pageContext.request.contextPath}/myProfile.jsp">Min Profil</a>
                    </c:if>
                    <c:if test="${sessionScope.user == null }">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                    </c:if>
                </div>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup2">
                <div class="navbar-nav">
                    <a href="https://www.johannesfog.dk/om-fog/forretninger" class="css-gldnal e1anyrz52">
                        <svg viewBox="0 0 25 25" xmlns="http://www.w3.org/2000/svg" width="1em" height="1em">
                            <path d="M13.737 9.053a1.685 1.685 0 1 1-3.37-.002 1.685 1.685 0 0 1 3.37.002Zm3.368 0c0 4.21-5.052 10.947-5.052 10.947S7 13.263 7 9.053a5.053 5.053 0 0 1 10.105 0Z"
                                  stroke="#101820" stroke-width="2" fill="none" stroke-linecap="round"
                                  stroke-linejoin="round">
                            </path>
                        </svg>
                        <span class="css-108uwdu e1anyrz54">Find Fog</span></a>
                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <h1>
        <jsp:invoke fragment="header"/>
    </h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container mt-3">
    <hr/>
    <div class="row mt-4">
        <div class="col">
            Nørgaardsvej 30<br/>
            2800 Lyngby
        </div>
        <div class="col">
            <jsp:invoke fragment="footer"/>
            <br/>
            <p>&copy; 2022 Cphbusiness</p>
        </div>
        <div class="col">
            Datamatikeruddannelsen<br/>
            2. semester efterår 2022
        </div>
    </div>

</div>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>