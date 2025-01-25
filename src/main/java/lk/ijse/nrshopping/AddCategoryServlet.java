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
        // Get parameters from the request (category name and description)
        String categoryName = req.getParameter("categoryName");
        String categoryDescription = req.getParameter("categoryDescription");

        // Log the input (for debugging purposes)
        System.out.println("Category Name: " + categoryName);
        System.out.println("Category Description: " + categoryDescription);

        if (categoryName == null || categoryName.trim().isEmpty() || categoryDescription == null || categoryDescription.trim().isEmpty()) {
            // Handle the error case where the fields are missing
            req.setAttribute("errorMessage", "Both category name and description are required!");
            req.getRequestDispatcher("/AdminCategory.jsp").forward(req, resp);
            return;
        }

        // Create a new Category object and set the fields
        Category category = new Category();
        category.setName(categoryName);
        category.setDescription(categoryDescription);

        try {
            // Save the category using CategoryBO and check if it's saved successfully
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

            // Redirect to the AdminCategory.jsp with error message
            resp.sendRedirect(req.getContextPath() + "/AdminCateogary.jsp?saveFail=An error occurred while saving the category!");
        }
    }
}
