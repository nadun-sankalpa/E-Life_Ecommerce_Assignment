package lk.ijse.nrshopping;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.nrshopping.BO.BOFactory;
import lk.ijse.nrshopping.BO.custom.UserBO;

import java.io.IOException;

@WebServlet(name = "UpdateUserStatusServlet", value = "/update-user-status-servlet")
public class UpdateUSerStatusServlet extends HttpServlet {
    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String status = req.getParameter("status");

        boolean newStatus = "true".equals(status);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            boolean isStatusUpdated = userBO.updateStatus(userId, newStatus);

            if (isStatusUpdated) {
//                resp.getWriter().write("{\"status\":\"success\",\"message\":\"Status successfully updated\",\"newStatus\":\"" + newStatus + "\"}");
                resp.sendRedirect(req.getContextPath()+"/all-users-servlet");
            } else {
//                resp.getWriter().write("{\"status\":\"error\",\"message\":\"Status update failed\"}");
                resp.sendRedirect(req.getContextPath()+"/all-users-servlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
//            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            resp.getWriter().write("{\"status\":\"error\",\"message\":\"Internal server error\"}");
            resp.sendRedirect(req.getContextPath()+"/all-users-servlet");
        }
    }
}
