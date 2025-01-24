<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/23/2025
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<% String passwordMisMatch = request.getParameter("passwordMisMatch"); %>
<% String saveSuccessful = request.getParameter("saveSuccess");%>
<section class="h-100 bg-gradient">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="images/cart2.jpg"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                        </div>
                        <div class="col-xl-6">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase">Customer Registration Form</h3>

                                <!-- Form starts here -->
                                <form action="user-registration-servlet" method="post">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="firstName" name="firstName" class="form-control form-control-lg" required />
                                                <label class="form-label" for="firstName">First Name</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="lastName" name="lastName" class="form-control form-control-lg" required />
                                                <label class="form-label" for="lastName">Last Name</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="username" name="username" class="form-control form-control-lg" required />
                                        <label class="form-label" for="username">Username</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="userType">User Type</label>
                                        <select id="userType" name="userType" class="form-select form-select-lg" required>
                                            <option value="" disabled selected>Select User Type</option>
                                            <option value="admin">Admin</option>
                                            <option value="customer">Customer</option>
                                        </select>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="email" id="email" name="email" class="form-control form-control-lg" required />
                                        <label class="form-label" for="email">Email Address</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="password" name="password" class="form-control form-control-lg" required />
                                        <label class="form-label" for="password">Password</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control form-control-lg" required />
                                        <label class="form-label" for="confirmPassword">Confirm Password</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="address" name="address" class="form-control form-control-lg" required />
                                        <label class="form-label" for="address">Address</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="date" id="dob" name="dob" class="form-control form-control-lg" required />
                                        <label class="form-label" for="dob">Date of Birth</label>
                                    </div>

                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="reset" class="btn btn-light btn-lg">Reset</button>
                                        <button type="submit" class="btn btn-outline-primary btn-lg ms-2">Submit</button>
                                    </div>
                                </form>
                                <!-- Form ends here -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%
    if (saveSuccessful !=null){%>
<!-- Toast Container -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="successToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                <%=saveSuccessful%>
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>
<%}%>


<script>

    document.addEventListener("DOMContentLoaded", function () {
        const toastElement = document.getElementById('successToast');
        const toast = new bootstrap.Toast(toastElement, { delay: 10000 });
        toast.show();
    });
</script>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</body>
</html>
