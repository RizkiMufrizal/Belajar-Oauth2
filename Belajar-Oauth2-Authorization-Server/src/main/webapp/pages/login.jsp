<%--
  Created by IntelliJ IDEA.
  User: rizki
  Date: 14/02/15
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- bower:css -->
    <link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.css"/>
    <!-- endbower -->

    <style type="text/css" rel="stylesheet">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <% if (request.getParameter("error") != null) { %>
                    <div class="alert alert-danger">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
                    <% } %>
                    <form accept-charset="UTF-8" role="form"
                          action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input name="email" type="email" class="form-control" placeholder="Email" required
                                       autofocus>
                            </div>
                            <div class="form-group">
                                <input name="password" type="password" class="form-control" placeholder="Password"
                                       required>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="Remember Me"> Remember Me
                                </label>
                            </div>
                            <input type="hidden" name="spring-security-redirect" value="http://google.com">
                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </fieldset>
                        <button type="submit" class="btn btn-primary btn-block">
                            Sign In
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- bower:js -->
<script src="../bower_components/jquery/dist/jquery.js"></script>
<script src="../bower_components/bootstrap/dist/js/bootstrap.js"></script>
<!-- endbower -->
</body>
</html>
