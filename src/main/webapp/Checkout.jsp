<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/23/2025
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
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
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="products.jsp">Cateogaries</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Cart.jsp">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="products.jsp">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="User.jsp">User</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <h3 class="mb-4">Order Summary</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Subtotal</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Product 1</td>
                    <td>1</td>
                    <td>$10.00</td>
                    <td>$10.00</td>
                </tr>
                <tr>
                    <td>Product 2</td>
                    <td>2</td>
                    <td>$15.00</td>
                    <td>$30.00</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-6">
            <h3 class="mb-4">Checkout Summary</h3>
            <ul class="list-group">
                <li class="list-group-item">Order ID: <span id="orderId"></span></li>
                <li class="list-group-item">User: <span id="userId"></span></li>
                <li class="list-group-item">Date: <span id="orderDate"></span></li>
                <li class="list-group-item">Status: <span id="orderStatus"></span></li>
                <li class="list-group-item">Total: <span id="orderTotal">$0.00</span></li>
            </ul>
            <button type="button" class="btn btn-primary mt-3">Place Order</button>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
