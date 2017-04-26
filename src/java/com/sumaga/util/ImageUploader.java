/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.util;

import com.sumaga.daoimpl.AttendanceDAOImpl;
import com.sumaga.daoimpl.EmployeeDAOImpl;
import com.sumaga.hibe.model.Fpfiles;
import com.sumaga.hibe.model.SysUser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ROHAN
 */
@WebServlet(name = "uploader", urlPatterns = {"/uploader"})
public class ImageUploader extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();
        SysUser user1 = (SysUser) httpSession.getAttribute("user");
        try {
            System.out.println("Calling");
            System.out.println("IMAGE UPLOADER");
            String result = "", result2 = "";
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

            if (isMultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {

                    List<FileItem> fi = upload.parseRequest(request);
                    String path2 = "";
                    int eid = 0;
                    for (FileItem itm : fi) {

                        if (!itm.isFormField()) {
                            String name = new File(itm.getName()).getName();
                            String sctm = System.currentTimeMillis() + "";
                            // itm.write(new File(request.getServletContext().getRealPath("/")+"myFile/"+System.currentTimeMillis()+"_"+name));

                            
                            
                            
                            
                            
//                            String path = "/var/lib/userimage";
//                            path2 = path + "/" + sctm + "_" + name;
//                            File theDir = new File(path);

                            
                            
                            
                            
                            
                                 
//                            start
//                             String path = "/images";
                             String path = "C:/fpdata";

                             path2 =  path+"/" + sctm + "_" + name;
                            File theDir = new File(path);

//                                End
                            
// if the directory does not exist, create it
                            if (!theDir.exists()) {
                                boolean result3 = false;
                                try {
                                    theDir.mkdir();
                                    result3 = true;
                                } catch (SecurityException se) {
                                    se.printStackTrace();
                                }
                                if (result3) {
                                    System.out.println("DIR created");
                                }
                            }
                            if (theDir.exists()) {
                                System.out.println("FILE EXIST>>>>>>>");
                            } else {
                                System.out.println("FILE NOT EXIST>>>>>>>");
                            }
                            File fff = new File(path2);
//                            File fff = new File(request.getServletContext().getRealPath(path2));
                            itm.write(fff);

                        } else if (itm.getFieldName().equals("employee")) {
                            System.out.println("*******************************************");
                            System.out.println("*******************************************");
                            System.out.println(itm.getString());
                            eid = Integer.parseInt(itm.getString());
                            System.out.println("*******************************************");
                            System.out.println("*******************************************");
                        }
                    }
                    System.out.println("EMPLOYEE ID: " + eid);
                    System.out.println("LINK : " + path2);

                    result = new EmployeeDAOImpl().SetImage(eid, "/Payroll"+path2);
                    if (result.equals(VertecConstants.SUCCESS)) {
                        result2 = new AttendanceDAOImpl().UpdateAttendance(user1);
                    } else {

                    }

                } catch (Exception e) {
                    out.write(e.toString());
                    System.out.println(e);
                    e.printStackTrace();
                }
            } else {
            }
            if (result.equals(VertecConstants.SUCCESS) & result2.equals(VertecConstants.SUCCESS)) {
                request.getSession().removeAttribute("Success_Message");
                request.getSession().setAttribute("Success_Message", "Successfully Added");
                response.sendRedirect("dashboard.jsp");
            } else {
                request.getSession().removeAttribute("Error_Message");
                request.getSession().setAttribute("Error_Message", "Not Added,Please Try again");
                response.sendRedirect("dashboard.jsp");
            }
        } finally {
            out.close();
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
