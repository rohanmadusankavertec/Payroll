/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumaga.controller;

import com.sumaga.daoimpl.AttendanceDAOImpl;
import com.sumaga.daoimpl.EmployeeDAOImpl;
import com.sumaga.hibe.model.Attendance;
import com.sumaga.hibe.model.Bank;
import com.sumaga.hibe.model.BankAccounts;
import com.sumaga.hibe.model.Employee;
import com.sumaga.hibe.model.Leaves;
import com.sumaga.hibe.model.SysUser;
import com.sumaga.util.Save;
import com.sumaga.util.VertecConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
@WebServlet(name = "AttendanceController", urlPatterns = {"/AttendanceController"})
public class AttendanceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final EmployeeDAOImpl EmployeeDAOImpl = new EmployeeDAOImpl();
    private final AttendanceDAOImpl AttendanceDAOImpl = new AttendanceDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            HttpSession httpSession = request.getSession();
            SysUser user1 = (SysUser) httpSession.getAttribute("user");
            RequestDispatcher requestDispatcher;
            switch (action) {
                //Load View Registration Page
                case "ViewaddLeave": {
                    List<Employee> cuList = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", cuList);
                    requestDispatcher = request.getRequestDispatcher("app/attendance/addLeave.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //Load finger Print data reading Page
                case "ReadFPData": {
                    requestDispatcher = request.getRequestDispatcher("app/attendance/fpData.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //load View Attendance Page 
                case "Attendance": {
                    
                    List<Employee> cuList = EmployeeDAOImpl.getEmployees();
                    request.setAttribute("employee", cuList);
                    List<Attendance> attendance = AttendanceDAOImpl.getAttendance();
                    request.setAttribute("attendance", attendance);
                    requestDispatcher = request.getRequestDispatcher("app/attendance/Attendance.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //Add Leave
                case "addLeave": {
                    String emp = request.getParameter("employee").trim();
                    String leave = request.getParameter("leavetype").trim();
                    String desc = request.getParameter("description").trim();
                    String from = request.getParameter("fromdate").trim();
                    String to = request.getParameter("todate").trim();
                    String day = request.getParameter("days").trim();

                    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fromdate = null;
                    Date todate = null;
                    try {
                        fromdate = DateFormat.parse(from);
                        todate = DateFormat.parse(to);
                    } catch (ParseException ex) {
                        Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Leaves e = new Leaves();
                    e.setDays(Double.parseDouble(day));
                    e.setType(leave);
                    e.setDescription(desc);
                    e.setFromdate(fromdate);
                    e.setTodate(todate);
                    e.setIsApproved(null);
                    Employee employee = new Employee(Integer.parseInt(emp));
                    e.setEmployeeId(employee);
                    e.setAddedBy(user1);
                    e.setIsPay(null);
                    String result = Save.Save(e);
                    if (result.equals(VertecConstants.SUCCESS)) {
                        request.getSession().removeAttribute("Success_Message");
                        request.getSession().setAttribute("Success_Message", "Successfully Added");
                        response.sendRedirect("Attendance?action=ViewaddLeave");

                    } else {
                        request.getSession().removeAttribute("Error_Message");
                        request.getSession().setAttribute("Error_Message", "Not Added,Please Try again");
                        response.sendRedirect("Attendance?action=ViewaddLeave");

                    }
                    break;
                }
                //Load View leave Page
                case "ViewLeave": {
                    List<Leaves> cuList = AttendanceDAOImpl.getLeave();
                    request.setAttribute("leave", cuList);
                    requestDispatcher = request.getRequestDispatcher("app/attendance/ViewLeaves.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //Approve a Leave
                case "ApproveLeave": {
                    String lid = request.getParameter("lid").trim();
                    String remark = request.getParameter("remark").trim();
                    String pay = request.getParameter("pay").trim();
                    boolean ispay = false;
                    if (pay.equals("1")) {
                        ispay = true;
                    }
                    Leaves l = new Leaves();
                    l.setId(Integer.parseInt(lid));
                    l.setIsApproved(true);
                    l.setIsPay(ispay);
                    l.setRemark(remark);

                    String result = AttendanceDAOImpl.ApproveLeave(l);
                    response.getWriter().write(result);
                    break;
                }
                //To Ignore Leave
                case "IgnoreLeave": {
                    String lid = request.getParameter("lid").trim();
                    String result = AttendanceDAOImpl.IgnoreLeave(Integer.parseInt(lid));
                    response.getWriter().write(result);
                    break;
                }
                //Save Attendance
                case "addAttendance": {
                    String emp = request.getParameter("employee").trim();
                    String date2 = request.getParameter("date").trim();
                    String intime2 = request.getParameter("intime").trim();
                    String outtime2 = request.getParameter("outtime").trim();

                    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm"); //if 24 hour format
                    System.out.println(intime2);
                    System.out.println(outtime2);
                    Date date = null;
                    Date intime = null;
                    Date outtime = null;
                    try {
                        date = DateFormat.parse(date2);
                        intime = TimeFormat.parse(intime2);
                        outtime = TimeFormat.parse(outtime2);
                    } catch (ParseException ex) {
                        Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(intime);
                    System.out.println(outtime);
                    Attendance a = new Attendance();
                    a.setIntime(intime);
                    a.setMarkedBy(user1);
                    a.setMarkedDate(new Date());
                    a.setDate(date);
                    a.setOuttime(outtime);
                    a.setIsValid(true);
                    Employee employee = new Employee(Integer.parseInt(emp));
                    a.setEmployeeId(employee);
                    String result = Save.Save(a);

                    if (result.equals(VertecConstants.SUCCESS)) {
                        request.getSession().removeAttribute("Success_Message");
                        request.getSession().setAttribute("Success_Message", "Successfully Added");
                        response.sendRedirect("Attendance?action=Attendance");
                    } else {
                        request.getSession().removeAttribute("Error_Message");
                        request.getSession().setAttribute("Error_Message", "Not Added,Please Try again");
                        response.sendRedirect("Attendance?action=Attendance");
                    }
                    break;
                }
                //Load Attendance update page 
                case "viewUpdateAttendance": {
                    String id = request.getParameter("eid").trim();
                    System.out.println(id);
                    Attendance attendance = AttendanceDAOImpl.getattendance(id);
                    request.setAttribute("attendance", attendance);
                    requestDispatcher = request.getRequestDispatcher("app/attendance/UpdateAttendance.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                }
                //Update attendance
                case "UpdateAttendance": {
                    String id = request.getParameter("id").trim();
                    String date2 = request.getParameter("date").trim();
                    String intime2 = request.getParameter("intime").trim();
                    String outtime2 = request.getParameter("outtime").trim();

                    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm"); //if 24 hour format
                    System.out.println(intime2);
                    System.out.println(outtime2);
                    Date date = null;
                    Date intime = null;
                    Date outtime = null;
                    try {
                        date = DateFormat.parse(date2);
                        intime = TimeFormat.parse(intime2);
                        outtime = TimeFormat.parse(outtime2);
                    } catch (ParseException ex) {
                        Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(intime);
                    System.out.println(outtime);
                    Attendance a = new Attendance();
                    a.setIntime(intime);
                    a.setDate(date);
                    a.setOuttime(outtime);
                    a.setIsValid(true);
                    a.setId(Integer.parseInt(id));
                    String result=AttendanceDAOImpl.UpdateAttendance(a);
                    if (result.equals(VertecConstants.SUCCESS)) {
                        request.getSession().removeAttribute("Success_Message");
                        request.getSession().setAttribute("Success_Message", "Successfully Added");
                        response.sendRedirect("Attendance?action=Attendance");
                    } else {
                        request.getSession().removeAttribute("Error_Message");
                        request.getSession().setAttribute("Error_Message", "Not Added,Please Try again");
                        response.sendRedirect("Attendance?action=Attendance");
                    }
                    break;
                }
            }
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
