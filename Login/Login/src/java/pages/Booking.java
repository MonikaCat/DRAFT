/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

/**
 *
 * @author Mandoka
 */
public class Booking extends HttpServlet {

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
            String [] query = new String[10];
            // Request parameter and save it in array
            query[0] = (String)request.getParameter("userid");
            query[1] = (String)request.getParameter("email");
            query[2] = (String)request.getParameter("phone");
            query[3] = (String)request.getParameter("pickup");
            query[4] = (String)request.getParameter("dropoff");
            query[5] = (String)request.getParameter("date");
            query[6] = (String)request.getParameter("time");
            query[7] = (String)request.getParameter("reg");
            query[8] = (String)request.getParameter("jid");
            
                 
            
            //System.out.println(query[0] +  "" + query[1]);
        //String insert = "INSERT INTO `Users` (`username`, `password`) VALUES ('";
      
            // Access Jdbc class and get create session  
            Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
            
            // Check if connection is null and display error
             if (jdbc == null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
             
             if(query[0].equals("") ) {
            request.setAttribute("message", "Name cannot be NULL");
        } 
             else if (query[1].equals(""))
        {
            request.setAttribute("message", "email cannot be NULL");
        }
             else if (query[2].equals(""))
        {
            request.setAttribute("message", "Phone cannot be NULL");
        }
             
        if(!(query[0].equals("")))
        {
            jdbc.insertJourney(query);
            request.setAttribute("message", "Journey added to the system!");
        }
        
             else {
            request.setAttribute("message", " There has been a problem \n\nPlease try again!");
        }
             
        
        
        // Display login page again if no success login in
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
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
    
