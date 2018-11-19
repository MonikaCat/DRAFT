package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/header.jsp", out, false);
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Taxi Booking System</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

 
            if(request.getSession().getAttribute("user_details") == null) {
                request.setAttribute("login", true);
                request.getRequestDispatcher("UserService.do").forward(request, response);
            }
            
            
            else 
            {
                 List<String> values = (ArrayList)request.getSession().getAttribute("user_details");
             String user_name = values.get(0).toString();
             System.out.println("USERNAME " + user_name);
             String user_type = values.get(1).toString();
             System.out.println("USER TYPE " + user_type);
                System.out.println("WE REACH HERE2222222");
                 System.out.println(request.getSession().getAttribute("user_details"));
                 System.out.println("WE REACH HERE");
                 //System.out.println(values.get(0) + " HERE ");
        
      out.write("\n");
      out.write("        <h1>Taxi Booking System</h1>\n");
      out.write("        <form method=\"POST\" action=\"UserService.do\">\n");
      out.write("        <p />\n");
      out.write("            View a table <br />\n");
      out.write("            <input type=\"radio\" name=\"tbl\" value=\"User\">USER PAGE<br />\n");
      out.write("            <input type=\"radio\" name=\"tbl\" value=\"Admin\">ADMIN PAGE<br />\n");
      out.write("            <input type=\"radio\" name=\"tbl\" value=\"Driver\">DRIVER PAGE<br />\n");
      out.write("          \n");
      out.write("            <input type=submit value=\"Confirm\"> <br />\n");
      out.write("        </form> \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"Logout\">\n");
      out.write("    <input type=\"submit\" value=\"Log out\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("         ");

            }

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
