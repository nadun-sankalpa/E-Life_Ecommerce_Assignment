<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/23/2025
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
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
    <h2>Your Shopping Cart</h2>

    <table class="table">
        <thead>
        <tr>
            <th>Product Image</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><img src="product1.jpg" alt="Product 1" width="50"></td>
            <td>Product Name 1</td>
            <td><input type="number" min="1" value="1" style="width: 50px;"></td>
            <td>$199.99</td>
            <td id="total1">$199.99</td>
            <td><button class="btn btn-danger btn-sm">Remove</button></td>
        </tr>
        <tr>
            <td><img src="product2.jpg" alt="Product 2" width="50"></td>
            <td>Product Name 2</td>
            <td><input type="number" min="1" value="2" style="width: 50px;"></td>
            <td>$99.99</td>
            <td id="total2">$199.98</td>
            <td><button class="btn btn-danger btn-sm">Remove</button></td>
        </tr>
        </tbody>
    </table>

    <p><strong>Total:</strong> <span id="grandTotal">$399.97</span></p>

    <button class="btn btn-primary">Proceed to Checkout</button>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    // Update total on quantity change
    $('input[type="number"]').on('change', function() {
        var row = $(this).closest('tr');
        var price = parseFloat(row.find('td:nth-child(4)').text().replace('$', ''));
        var quantity = parseInt($(this).val());
        var total = price * quantity;
        row.find('td:nth-child(5)').text('$' + total.toFixed(2));
        updateGrandTotal();
    });

    function updateGrandTotal() {
        var grandTotal = 0;
        $('td:nth-child(5)').each(function() {
            grandTotal += parseFloat($(this).text().replace('$', ''));
        });
        $('#grandTotal').text('$' + grandTotal.toFixed(2));
    }


    updateGrandTotal();
</script>


</body>
</html>
