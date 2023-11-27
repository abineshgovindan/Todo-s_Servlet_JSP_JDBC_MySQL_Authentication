<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

<body class="">



<section class="gradient-custom ">
<nav class="navbar bg-dark d-flex justify-content-between">
<div class="d-flex justify-content-start"> 
<span class="navbar-brand mb-0 px-3 h1 text-white">Todo's</span>
</div>
 
<div class="">

<a href="<%=request.getContextPath()%>/taskFormPage" class="btn btn-outline-primary mx-2 btn-sm">Create New Tasks</a>
<button type="button" class="btn  btn-outline-info mx-2 btn-sm">LogOut</button>
</div>
  
  
</nav>

  <div class="container py-5  mb-75">
    <div class="row d-flex justify-content-center align-items-center ">
      <div class=" col">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-7 text-center">
       

            <!-- Table content -->
            <div class="bg-dark">
            <table class="table text-white m-1 py-2">
              <thead>
                <tr>
                  <th scope="col "><h4>Task</h4></th>
                  <th scope="col"><h4>Due_Date</h4></th>
                  <th scope="col"><h4>Priority</h4></th>
                  <th scope="col"><h4>Actions</h4></th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="task" items="${listTasks}">
                   <tr class="fw-normal ">
                 
                  <td class="align-middle w-100">
                  <c:choose>
                  <c:when test="${task.completed == true }">
                   <h6 class="mb-0 p-2"><s class="text-danger">${task.task_description} </s></h6>
                  
                  </c:when>
                  <c:otherwise>
                   <h6 class="mb-0 p-2">${task.task_description}</h6>
                  </c:otherwise>
                  </c:choose>
                  </td>
                    <td class="align-middle">
                    <h6 class="mb-0 p-2">${task.due_date}</h6>
                  </td>
                  <td class="align-middle">
                  <c:choose>
                  
                  <c:when test="${ task.task_priority == 2}">
                 <h6 class="mb-0"><span class="badge bg-warning">Middle priority</span></h6>
                  </c:when>
                  
                  <c:when test="${ task.task_priority == 3}">
                   <h6 class="mb-0"><span class="badge bg-danger">High priority</span></h6>
                  </c:when>
                  
                  <c:otherwise>
                   <h6 class="mb-0"><span class="badge bg-success">Low priority</span></h6>
                  </c:otherwise>
                  
                  </c:choose>
                   
                  </td>
                 <td class="align-middle">
                  <div class="col d-flex justify-content-center align-items-center mb-0 ">
                  <button type="button" class="btn btn-outline-primary btn-sm mx-2   ">Completed</button>
                    <button type="button" class="btn btn-outline-danger btn-sm ">Delete</button>
                  
                  </div>
                  </td>
                </tr>
              
              
              
              </c:forEach>
              
                <!--  bg-success  bg-warning  bg-danger 
           
                <tr class="fw-normal">
           
                  <td class="align-middle w-100">Office rent</td>
                  <td class="align-middle">
                    <h6 class="mb-0"><span class="badge bg-warning">Middle priority</span></h6>
                  </td>
                 <td class="align-middle">
                  <div class="col d-flex justify-content-center align-items-center mb-0 ">
                  <button type="button" class="btn btn-outline-primary btn-sm mx-2  ">Completed</button>
                    <button type="button" class="btn btn-outline-danger btn-sm ">Delete</button>
                  
                  </div>
                  </td>
                </tr>
                <tr class="fw-normal">
                  
                  <td class="align-middle w-100">Office grocery shopping</td>
                  <td class="align-middle">
                    <h6 class="mb-0"><span class="badge bg-danger">High priority</span></h6>
                  </td>
                  <td class="align-middle">
                  <div class="col d-flex justify-content-center align-items-center mb-0 ">
                  <button type="button" class="btn btn-outline-primary btn-sm mx-2 ">Completed</button>
                    <button type="button" class="btn btn-outline-danger btn-sm ">Delete</button>
                  
                  </div>
                    
                   
                  </td>
                </tr>
                -->
                
              </tbody>
            </table>
            
            <!-- Table End -->

           </div>
            </div>
             </div>
              </div>
               </div>
                </div>
         
</section>

</body>

</html>