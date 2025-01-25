package lk.ijse.nrshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.nrshopping.BO.BOFactory;
import lk.ijse.nrshopping.BO.custom.CategoryBO;

import java.io.IOException;
@WebServlet(name = "DeleteCategoryServlet", value = "/delete-category-servlet")
public class DeleteCategoryServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");

        boolean isDeleted = categoryBO.delete(categoryId);

        if (isDeleted){
            resp.sendRedirect(req.getContextPath() + "/all-category-servlet?saveSuccess=Category Deleted Successfully!");
        } else {
            resp.sendRedirect(req.getContextPath() + "/all-category-servlet?saveFail=Category Delete Failed!");
        }
    }
}
