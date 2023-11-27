<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TODO</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

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

.gradient-custom-2 {
  /* fallback for old browsers */
  background: #7e40f6;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(
    to right,
    rgba(126, 64, 246, 1),
    rgba(80, 139, 252, 1)
  );

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(
    to right,
    rgba(126, 64, 246, 1),
    rgba(80, 139, 252, 1)
  );
}

.mask-custom {
  background: rgba(24, 24, 16, 0.2);
  border-radius: 2em;
  backdrop-filter: blur(25px);
  border: 2px solid rgba(255, 255, 255, 0.05);
  background-clip: padding-box;
  box-shadow: 10px 10px 10px rgba(46, 54, 68, 0.03);
}

.body-padding{
padding: 
}
</style>

<body>
<section>
<div>





<section class="vh-200 gradient-custom">
<nav class="navbar bg-dark ">
  <span class="navbar-brand mb-0 px-3 h1 text-white">Todo's</span>
</nav>
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
	<form action="insert" method="post">
	<h2 class="fw-bold mb-5 text-uppercase">Add Todo..</h2>
	
            <div class="mb-md-5 mt-md-4 pb-5">

              
				<div class="form-outline form-white mb-4">
				 
                <input type="text" id="task_description" name="task_description" required placeholder="Task..." class="form-control form-control-lg" />
              
              </div>
           
              
              <div class="form-outline form-white mb-4">
                <input type="date" id="due_date" name="due_date" placeholder="Due Date" required class="form-control form-control-lg" />
              
              </div>

              <div class="form-outline form-white mb-4">
               <select class="form-select form-select-lg bg-light  " name="task_priority"  aria-label=".form-select-sm">
 								 <option selected>Priority</option>
								  <option value="1"  >Low</option>
								  <option value="2">Mid</option>
								  <option value="3">High</option>
							      </select>
             
              </div>

            

              <button class="btn btn-outline-light btn-lg px-5"  type="submit">Create Task</button>

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