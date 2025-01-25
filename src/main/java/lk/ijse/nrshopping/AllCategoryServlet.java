package lk.ijse.nrshopping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.nrshopping.BO.BOFactory;
import lk.ijse.nrshopping.BO.custom.CategoryBO;
import lk.ijse.nrshopping.Entity.Category;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllCategoryServlet", urlPatterns = {"/all-category-servlet"})
public class AllCategoryServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AllCategoryServlet doGet called");
        List<Category> categoryList = categoryBO.getAll();
        if (categoryList != null && !categoryList.isEmpty()) {
            req.setAttribute("categoryList", categoryList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminCateogary.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("AdminCateogary.jsp?allListFailed=No categories found.");
        }
    }
}
