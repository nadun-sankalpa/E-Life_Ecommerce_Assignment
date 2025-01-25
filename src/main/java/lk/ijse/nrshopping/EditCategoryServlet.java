package lk.ijse.nrshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.nrshopping.BO.BOFactory;
import lk.ijse.nrshopping.BO.custom.CategoryBO;
import lk.ijse.nrshopping.Entity.Category;

import java.io.IOException;
@WebServlet(name = "EditCategoryServlet", value = "/edit-category-servlet")
public class EditCategoryServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
        String editCategoryName = req.getParameter("editCategoryName");
        String editCategoryDescription = req.getParameter("editCategoryDescription");

        Category category = categoryBO.getById(categoryId);

        category.setName(editCategoryName);
        category.setDescription(editCategoryDescription);

        boolean isUpdated = categoryBO.update(category);

        if (isUpdated){
            resp.sendRedirect(req.getContextPath() + "/all-category-servlet?saveSuccess=Category Updated Successfully!");
        } else {
            resp.sendRedirect(req.getContextPath() + "/all-category-servlet?saveFail=Category update Failed!");
        }
    }
}
