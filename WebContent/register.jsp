<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 
<% 
String error = (String)request.getAttribute("Error");


%>
</head>
<!--  
<style>

.titleContainer{
margin-top: 20px;
 
  text-align : center;

}
.formContiner{
margin-top: 25px;
  margin-bottom: auto;
  margin-right: auto;
  margin-left: auto;

  width: 50%;
  border: 3px solid cyan;
  padding: 25px;
} 

</style>
-->
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



<!--
if(error != null){
 out.print("<h2>"+error+"</h2>"); } --->


<!-- 
<form method="post" action=register class ="formContiner">
<h1>Register</h1>
 
 <div >
 
<p class='text-danger'><% if(error != null)out.print(error);%></p>

</div> 
 -->

<!-- 
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" id="inputName" aria-describedby="emailHelp">
  </div>

  S name -->
  
  <!-- 
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <!--  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
  <!-- 
  <button type="submit" value="submit" class="btn btn-primary">Create User</button>
</form>
 -->


<section class="vh-200 gradient-custom">
<nav class="navbar bg-dark d-flex justify-content-between">
<div class="d-flex justify-content-start"> 
<span class="navbar-brand mb-0 px-3 h1 text-white">Todo's</span>
</div>

</nav>
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
	<form method="post" action="register">
	<h2 class="fw-bold mb-5 ">Register</h2>
	<p class='text-danger'><% if(error != null)out.print(error);%></p>
            <div class="mb-md-5 mt-md-4 pb-5">

              
				<div class="form-outline form-white mb-4">
				 
                <input type="text" name="name" id="typeEmailX" placeholder="Name" class="form-control form-control-lg" />
              
              </div>
              
              
              <div class="form-outline form-white mb-4">
                <input type="email" name="email"id="typeEmailX"  placeholder="Email" class="form-control form-control-lg" />
              
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" name="password" id="typePasswordX" placeholder="Password" class="form-control form-control-lg" />
             
              </div>

              <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>

              <button class="btn btn-outline-light btn-lg px-5"  type="submit">Register</button>

            </div>
            </form>

            

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>