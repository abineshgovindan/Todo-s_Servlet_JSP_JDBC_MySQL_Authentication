<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<% 
String error = (String)request.getAttribute("Error");


%>
</head>
<style>
.gradient-custom {
  background: radial-gradient(50% 123.47% at 50% 50%, #00ff94 0%, #720059 100%),
    linear-gradient(121.28deg, #669600 0%, #ff0000 100%),
    linear-gradient(360deg, #0029ff 0%, #8fff00 100%),
    radial-gradient(100% 164.72% at 100% 100%, #6100ff 0%, #00ff57 100%),
    radial-gradient(100% 148.07% at 0% 0%, #fff500 0%, #51d500 100%);
  background-blend-mode: screen, color-dodge, overlay, difference, normal;
}

</style>
<body>


<section class="vh-300 gradient-custom">
<nav class="navbar bg-dark d-flex justify-content-between">
<div class="d-flex justify-content-start"> 
<span class="navbar-brand mb-0 px-3 h1 text-white">Todo's</span>
</div>

</nav>
  <div class="container py-5 w-200">
    <div class="row d-flex justify-content-center align-items-center h-200">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
	<form method="post" action="login">
	 <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
	
            <div class="mb-md-3 mt-md-4 pb-5">

             
              <p class="text-white-50 mb-5">Please enter your login and password!</p>
 <p class='text-danger'><% if(error != null)out.print(error);%></p>
              <div class="form-outline form-white mb-4">
                <input type="text" name="email" id="typeEmailX" placeholder="Email" class="form-control form-control-lg" />
            
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" name="password" id="typePasswordX" placeholder="Password" class="form-control form-control-lg" />

              </div>

              <p class="small mb-1 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>
 <p class="mb-5">Don't have an account? <a href="/Todo_app/registerPage" class="text-white-50 fw-bold">Sign Up</a>
              </p>
              <button class="btn btn-outline-light btn-lg px-5"  type="submit">Login</button>

            

            </div>
            </form>
            <div>
             
            </div>

            

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>