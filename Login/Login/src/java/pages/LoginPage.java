
/*
 * Group: Fire Breathing Rubber Duckies
 * Course: Computer Science
 * University Of West of England
 * Members: Monika Pusz (16024757)
 *           Devon Davies (16012456)
 *           George Thurston (16040939)
 *           Adwait Chhetri (15021047)
 *           George Jones (16005563)
 */

package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;


public class LoginPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
        
            // Create array of strings
            String [] query = new String[3];
            // Request parameter and save it in array
            query[0] = (String)request.getParameter("user_name");
            query[1] = (String)request.getParameter("user_password");
            query[2] = (String)request.getParameter("user_type");
            //System.out.println(query[0] +  "" + query[1]);
        //String insert = "INSERT INTO `Users` (`username`, `password`) VALUES ('";
      
            // Access Jdbc class and get create session  
            Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
            
            // Check if connection is null and display error
             if (jdbc == null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
             
        // Check if username field is empty and display error message
        if(query[0].equals("") ) {
            request.setAttribute("message", "Username cannot be NULL");
        } 
        
        // Check if password field is empty and display error message
        else if (query[1].equals(""))
        {
            request.setAttribute("message", "Password cannot be NULL");
        }
        // Check if user and password exists in database and login if successful
       
        else if(query[2].equals("Customer"))
            {
                if(jdbc.userExists(query[0], query[1]))
                {
                 request.setAttribute("message", query[0]+" Log in succesful!");
                 String user_name = query[0];
                 String user_type = query[2];
                 List<String> names = new ArrayList<String>();
                names.add(user_name);
                names.add(user_type);
                request.getSession().setAttribute("user_details", names);
                // Set attribute tp user_name to create session
                //request.getSession().setAttribute("user_name", username);
               // request.getSession().setAttribute("user_type", user_type);
                //Redirect to userhome.jsp if log in successful
                request.getRequestDispatcher("/WEB-INF/userhome.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("message", "Username "+ query[0] + " doesn't exist! Please try again! ");
                }
            }
       
        else if(query[2].equals("Driver"))
            {
                if(jdbc.driverExists(query[0], query[1]))
                {
                request.setAttribute("message", query[0]+" Log in succesful!");
                String user_name = query[0];
                String user_type = query[2];
                List<String> names = new ArrayList<String>();
                names.add(user_name);
                names.add(user_type);
                request.getSession().setAttribute("user_details", names);
                // Set attribute tp user_name to create session
                //request.getSession().setAttribute("user_name", username);
                //request.getSession().setAttribute("user_type", user_type);
                //Redirect to driverhome.jsp if log in successful
                request.getRequestDispatcher("/WEB-INF/driverhome.jsp").forward(request, response); 
                }
                else
                {
                    request.setAttribute("message", "Driver "+ query[0] + " doesn't exist! Please try again! ");
                }
            }
            
        else if(query[2].equals("Admin"))
            {
                if(query[0].equals("admin") && query[1].equals("admin"))
                {
                request.setAttribute("message", query[0]+" Log in succesful!");
                String user_name = query[0];
                String user_type = query[2];
                // Set attribute tp user_name to create session
                List<String> names = new ArrayList<String>();
                names.add(user_name);
                names.add(user_type);
                request.getSession().setAttribute("user_details", names);
                //request.getSession().setAttribute("user_name", username);
               // request.getSession().setAttribute("user_type", user_type);
                //Redirect to adminhome.jsp if log in successful
                request.getRequestDispatcher("/WEB-INF/adminhome.jsp").forward(request, response); 
                
                }
                else
                {
                    request.setAttribute("message", "Wrong admin username of password! Please try again! ");
                }
            }
            
          
        
        else {
            request.setAttribute("message", " Wrong username or password! \n\nPlease try again!");
        }
        
        // Display login page again if no success login in
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
            
           
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
