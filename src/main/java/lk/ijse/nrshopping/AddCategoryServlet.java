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

@WebServlet(name = "AddCategoryServlet", value = "/add-category-servlet")
public class AddCategoryServlet extends HttpServlet {

    // CategoryBO instance to interact with the business logic layer
    private final CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get parameters from the request (category name and description)
            String categoryName = req.getParameter("categoryName");
            String categoryDescription = req.getParameter("categoryDescription");

            // Log the input for debugging purposes
            System.out.println("Category Name: " + categoryName);
            System.out.println("Category Description: " + categoryDescription);

            // Validate the input to ensure neither field is null or empty
            if (categoryName == null || categoryName.trim().isEmpty()) {
                req.setAttribute("errorMessage", "Category name is required!");
                req.getRequestDispatcher("/AdminCategory.jsp").forward(req, resp);
                return;
            }

            if (categoryDescription == null || categoryDescription.trim().isEmpty()) {
                req.setAttribute("errorMessage", "Category description is required!");
                req.getRequestDispatcher("/AdminCategory.jsp").forward(req, resp);
                return;
            }

            // Create a new Category object and set the fields
            Category category = new Category();
            category.setName(categoryName.trim());
            category.setDescription(categoryDescription.trim());

            // Save the category using CategoryBO
            boolean isSaved = categoryBO.save(category);

            // Redirect to AdminCategory.jsp with success or failure message
            if (isSaved) {
                resp.sendRedirect(req.getContextPath() + "/AdminCateogary.jsp?saveSuccess=Category Saved Successfully!");
            } else {
                resp.sendRedirect(req.getContextPath() + "/AdminCateogary.jsp?saveFail=Category Save Failed!");
            }

        } catch (Exception e) {
            // Log the error for debugging purposes
            e.printStackTrace();

            // Redirect to the AdminCategory.jsp with an error message
            resp.sendRedirect(req.getContextPath() + "/AdminCateogary.jsp?saveFail=An unexpected error occurred while saving the category!");
        }
    }
}
