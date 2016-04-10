<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FiBank: Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<style>
body {background-color: #f1f5f6;}
</style>
    <nav class="navbar navbar">
	<style>
         nav {background-color: #CEF1FF}
     </style>
        <div class="container-fluid">

            <div class="navbar-header">
                <a href="#" class="navbar-brand">My Bank</a>
            </div>

            <div>
                <ul class="nav navbar-nav">
                <li class="active"><a href="./Home">Home</a></li>
				<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Accounts <span class="caret"></span></a>
                        <ul class="dropdown-menu">
						    <li role="separator" class="divider"></li>
                            <li><a href="#">Check Balance</a></li>
							<li role="separator" class="divider"></li>
                            <li><a href="./NewAccount">Add An Account</a></li>
							<li role="separator" class="divider"></li>
                            <li><a href="#">Delete An Account</a></li>
                        </ul>
                    </li>
					<li class="active"><a href="./Transaction">Transfer Money</a></li>
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">History <span class="caret"></span></a>
                        <ul class="dropdown-menu">
						    <li role="separator" class="divider"></li>
                            <li><a href="#">Transfer History</a></li>
							<li role="separator" class="divider"></li>
                            <li><a href="#">Log In History</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
                        <ul class="dropdown-menu">
						    <li role="separator" class="divider"></li>
                            <li><a href="#">View Details</a></li>
							<li role="separator" class="divider"></li>
                            <li><a href="#">Change Password</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="./Logout">Log Out</a></li>
                </ul>

            </div>

        </div>
    </nav>
</body>
</html>