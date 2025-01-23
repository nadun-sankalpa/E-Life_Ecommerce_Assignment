<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/22/2025
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #e3f2fd;" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">E-Life</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="AdminDashboard.jsp">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminCateogary.jsp">Cateogaries</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminOrders.jsp">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminProducts.jsp">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminUsers.jsp">Users</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Content -->
<div class="container mt-5">
    <h1 class="text-center mb-4">Users</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contact Number</th>
            <th>Email</th>
            <th>Active Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <!-- Assuming you have a list of users -->
        <tr>
            <td>john_doe</td>
            <td>John Doe</td>
            <td>123 Elm St, Springfield</td>
            <td>555-1234</td>
            <td>john@example.com</td>
            <td>
                <!-- Display active status, change button based on status -->
                <span id="status-1" class="badge bg-success">Active</span>
            </td>
            <td>
                <button class="btn btn-warning" onclick="toggleActiveStatus(1)">Change Status</button>
            </td>
        </tr>
        <tr>
            <td>jane_smith</td>
            <td>Jane Smith</td>
            <td>456 Oak St, Springfield</td>
            <td>555-5678</td>
            <td>jane@example.com</td>
            <td>
                <span id="status-2" class="badge bg-danger">Inactive</span>
            </td>
            <td>
                <button class="btn btn-warning" onclick="toggleActiveStatus(2)">Change Status</button>
            </td>
        </tr>
        <!-- Additional rows can be dynamically added from the database -->
        </tbody>
    </table>
</div>

<!-- JavaScript to handle changing active status -->
<script>
    function toggleActiveStatus(userId) {
        var statusElement = document.getElementById('status-' + userId);
        if (statusElement.classList.contains('bg-success')) {
            statusElement.classList.remove('bg-success');
            statusElement.classList.add('bg-danger');
            statusElement.textContent = 'Inactive';
        } else {
            statusElement.classList.remove('bg-danger');
            statusElement.classList.add('bg-success');
            statusElement.textContent = 'Active';
        }


    }
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
