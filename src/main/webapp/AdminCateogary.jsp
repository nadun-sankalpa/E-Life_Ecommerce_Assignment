<%@ page import="lk.ijse.nrshopping.Entity.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/22/2025
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<% String saveSuccessful = request.getParameter("saveSuccess");%>
<% String saveFail = request.getParameter("saveFail");%>

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
    <h1 class="text-center mb-4">ADMIN</h1>
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3>Category Management</h3>
        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addCategoryModal">Add Category</button>
    </div>
    <form action="all-category-servlet" method="get">
        <% String allListFailed = request.getParameter("allListFailed"); %>
        <!-- Display error if allListFailed is set -->
        <% if (allListFailed != null) { %>
        <div class="alert alert-warning" role="alert">
            <%= allListFailed %>
        </div>
        <% } else { %>

        <%
            List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
            if (categoryList != null && !categoryList.isEmpty()) {
        %>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Category ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Category category : categoryList) {
            %>
            <tr>
                <td><%= category.getCategoryId() %></td>
                <td><%= category.getName() %></td>
                <td><%= category.getDescription() %></td>
                <td>
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editCategoryModal" onclick="populateEditCategoryModal(`<%= category.getCategoryId()%>`, `<%=category.getName()%>`,`<%=category.getDescription()%>`)">Edit</button>
                    <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteCategoryModal" onclick="setDeleteCategoryConfirmation(`<%= category.getCategoryId()%>`, `<%=category.getName()%>`,`<%=category.getDescription()%>`)">Delete</button>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <% } else { %>
        <div class="alert alert-warning" role="alert">
            No categories available to display.
        </div>
        <% } %>
        <% } %>
    </form>
</div>



<!-- Add Category Modal -->
<div class="modal fade" id="addCategoryModal" tabindex="-1" aria-labelledby="addCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCategoryModalLabel">Add Category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/add-category-servlet" method="post" id="addCategoryForm">
                    <div class="mb-3">
                        <label for="categoryName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" name="categoryName" id="categoryName" required>
                    </div>
                    <div class="mb-3">
                        <label for="categoryDescription" class="form-label">Description</label>
                        <textarea class="form-control" name="categoryDescription" id="categoryDescription" rows="3" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Save Category</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Edit Category Modal -->
<div class="modal fade" id="editCategoryModal" tabindex="-1" aria-labelledby="editCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCategoryModalLabel">Edit Category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editCategoryForm" action="edit-category-servlet" method="post">
                    <div class="mb-3">
                        <label for="editCategoryId" class="form-label">Category ID</label>
                        <input type="text" class="form-control" id="editCategoryId" name="categoryId" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="editCategoryName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="editCategoryName" name="editCategoryName" required>
                    </div>
                    <div class="mb-3">
                        <label for="editCategoryDescription" class="form-label">Description</label>
                        <textarea class="form-control" id="editCategoryDescription" name="editCategoryDescription" rows="3" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Update Category</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Delete Confirmation Modal -->
<div class="modal fade" id="deleteCategoryModal" tabindex="-1" aria-labelledby="deleteCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteCategoryModalLabel">Confirm Deletion</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="delete-category-servlet" method="post" id="deleteCategoryForm">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="deleteCategoryId" class="form-label">Category ID</label>
                        <input type="text" class="form-control" id="deleteCategoryId" name="categoryId" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="deleteCategoryName" class="form-label">Category Name</label>
                        <input type="text" class="form-control" id="deleteCategoryName" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="deleteCategoryDescription" class="form-label">Category Description</label>
                        <textarea class="form-control" id="deleteCategoryDescription" rows="3" readonly></textarea>
                    </div>
                    <p class="text-danger">Are you sure you want to delete this category?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<% if (saveSuccessful != null && !saveSuccessful.isEmpty()) { %>
<!-- Success Toast -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="successToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                <%= saveSuccessful %>
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>
<% } else if (saveFail != null && !saveFail.isEmpty()) { %>
<!-- Fail Toast -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="failToast" class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body">
                <%= saveFail %>
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>
<% } %>

<script>
    // Show the toast when the page loads (adjust as needed for your logic)
    document.addEventListener("DOMContentLoaded", function () {
        const toastElement = document.getElementById('successToast');
        const toast = new bootstrap.Toast(toastElement, { delay: 10000 }); // 10 seconds delay
        toast.show();
    });
    document.addEventListener("DOMContentLoaded", function () {
        const toastElement = document.getElementById('failToast');
        const toast = new bootstrap.Toast(toastElement, { delay: 10000 }); // 10 seconds delay
        toast.show();
    });
    function populateEditCategoryModal(categoryId, categoryName, categoryDescription) {
        // Populate the Edit Modal with category details (use AJAX or data from your database)
        document.getElementById('editCategoryId').value = categoryId;
        document.getElementById('editCategoryName').value = categoryName;
        document.getElementById('editCategoryDescription').value = categoryDescription;
    }

    function setDeleteCategoryConfirmation(categoryId, categoryName, categoryDescription) {
        document.getElementById('deleteCategoryId').value = categoryId;
        document.getElementById('deleteCategoryName').value = categoryName;
        document.getElementById('deleteCategoryDescription').value = categoryDescription;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
