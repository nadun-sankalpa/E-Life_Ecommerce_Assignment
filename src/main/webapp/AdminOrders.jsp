<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/22/2025
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
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
    <h1 class="text-center mb-4">Orders</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Total Amount</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>101</td>
            <td>2025-01-15</td>
            <td>$250</td>
        </tr>
        <tr>
            <td>102</td>
            <td>2025-01-16</td>
            <td>$500</td>
        </tr>
        <tr>
            <td>103</td>
            <td>2025-01-17</td>
            <td>$150</td>
        </tr>
        <!-- Additional rows can be dynamically added from the database -->
        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
