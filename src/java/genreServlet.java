/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maple
 */
public class genreServlet extends HttpServlet {

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
        String genre = request.getParameter("genreSelect");
        String[] movieArr = null;
        switch(genre) {
            case "Action" :
                movieArr = new String[] {"aeon_flux.jpg", "machete_kills.jpg", "showdown_tokyo.jpg", "terminator.jpg", "judge_dredd.jpg"};
                break;
            case "Horror" :
                movieArr = new String[] {"Conjuring_2.jpg", "alien.png", "dont_speak.jpg", "nightmare_elm.jpg", "slaughterhouse.jpg"};
                break;
            case "Mystery" :
                movieArr = new String[] {"bo3me3one.jpg", "cube.jpg", "scream_2.jpg", "the_calling.jpg", "the_room.jpg"};
                break;
            case "Animated" :
                movieArr = new String[] {"little_mermaid.jpg", "paprika.jpg", "spirited_away.jpg", "tangled.jpg", "gits.jpg"};
                break;
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
            out.println("<link rel='stylesheet' type='text/css' href='mainstyle.css'");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Results for " + genre + "</h1>");
            
            for(int i = 0; i < movieArr.length; i++) {
                out.println("<div class=\"item\">\n");
                out.println("      <img src=\"images/" + movieArr[i] + "\" alt=\"" + movieArr[i] + "\">\n" +
                        "    </div>\n");
            }
            out.println("</body>");
            out.println("</html>");
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
