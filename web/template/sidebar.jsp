<%-- 
    Document   : sidebar
    Created on : Mar 21, 2016, 2:25:42 PM
    Author     : User
--%>

<%@page import="com.sumaga.util.CheckAuth"%>
<%@page import="com.sumaga.hibe.model.UserGroupPrivilegeItem"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="com.sumaga.hibe.model.SysUser"%>


<c:set var="context" value="${pageContext.request.contextPath}" />

<%    SysUser user = (SysUser) session.getAttribute("user");
    CheckAuth ca = new CheckAuth();
    int group = user.getUserGroupId().getUserGroupId();
%>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${context}/dashboard.jsp" class="site_title"><img src="${context}/resources/images/payroll-Logo.jpg" style="width: 200px; height: 60px;"/></i> <span></span></a>
        </div>
        <div class="clearfix"></div>
        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a href="${context}/dashboard.jsp"><i class="fa fa-home"></i> DashBoard </a>

                    </li>

                    <li><a><i class="fa fa-user-plus"></i>Employee<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("VIEW_DEPARTMENTS", group) != null) {%>
                            <li><a href="${context}/Employee?action=Department">Manage Departments</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_DESIGNATIONS", group) != null) {%>
                            <li><a href="${context}/Employee?action=Designation">Manage Designations</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_DESIGNATIONS", group) != null) {%>
                            <li><a href="${context}/Employee?action=ViewEmployeeType">Manage Employee Type</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ADD_EMPLOYEES", group) != null) {%>
                            <li><a href="${context}/Employee?action=EmployeeReg">Employee Registration</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ADD_EMPLOYEES", group) != null) {%>
                            <li><a href="${context}/Employee?action=EmployeeImage">Employee Image</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_EMPLOYEES", group) != null) {%>
                            <li><a href="${context}/Employee?action=ViewEmployee">View Employee</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Attendance <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("ADD_LEAVE", group) != null) {%>
                            <li><a href="${context}/Attendance?action=ViewaddLeave">Add Leaves</a>
                            </li>
                            <%}%>
                             <%if (ca.checkUserAuth("VIEW_LEAVE", group) != null) {%>
                            <li><a href="${context}/Attendance?action=ViewLeave">View Leaves</a>
                            </li>
                            <%}%>   
                            <%if (ca.checkUserAuth("VIEW_ATTENDANCE", group) != null) {%>
                            <li><a href="${context}/Attendance?action=Attendance">Attendance</a>
                            </li>
                            <%}%> 
                            <%if (ca.checkUserAuth("ADD_FINGERPRINT", group) != null) {%>
                            <li><a href="${context}/Attendance?action=ReadFPData">Read Finger Print Data</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bank"></i> Bank Details <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("VIEW_BANK", group) != null) {%>
                            <li><a href="${context}/Bank?action=LoadBank">Save Bank</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-arrow-circle-up"></i> Allowance & Deduction <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("ADD_ALLOWANCE", group) != null) {%>
                            <li><a href="${context}/Allowance?action=ViewaddAllowance">Allowance & Deductions</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_ALLOWANCE", group) != null) {%>
                            <li><a href="${context}/Allowance?action=ViewAllowance">View Allowance & Deductions</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-recycle"></i> Staff Loans <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("VIEW_STAFFLOANS", group) != null) {%>
                            <li><a href="${context}/Salary?action=staffloans">Staff Loan</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                     <li><a><i class="fa fa-money"></i> Salary<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("VIEW_WORKING_HOURS", group) != null) {%>
                            <li><a href="${context}/Salary?action=ViewDefault">Working Hours</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_HOLIDAY", group) != null) {%>
                            <li><a href="${context}/Salary?action=ViewHolyday">HoliDays</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_DEFAULT_PAYMENT", group) != null) {%>
                            <li><a href="${context}/Salary?action=ViewDefaultPayments">Default Payments</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_ADVANCE_PAYMENT", group) != null) {%>
                            <li><a href="${context}/Salary?action=ViewAdvancePayment">Advance payment</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("CALCULATE_SALARY", group) != null) {%>
                            <li><a href="${context}/Salary?action=CalSalary">Calculate Salary</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("SALARY_PAYMENT", group) != null) {%>
                            <li><a href="${context}/Salary?action=ViewSalaryPayment">Salary payment</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-user-secret"></i>User Management<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("ADD_USER", group) != null) {%>
                            <li><a href="${context}/app/users/userRegister.jsp">Add New User</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("VIEW_USERS", group) != null) {%>
                            <li><a href="${context}/User?action=ViewUsers">Manage Users</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ADD_USER_GROUP", group) != null) {%>
                            <li><a href="${context}/app/users/createUserGroup.jsp">Create User Group</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>

                    <li><a><i class="fa fa-check"></i>Privilege Management<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("ADD_PRIVILEGE", group) != null) {%>
                            <li><a href="${context}/Privilege?action=ViewPrivilege">Manage Privilege Groups</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ADD_PRIVILEGE_ITEM", group) != null) {%>
                            <li><a href="${context}/Privilege?action=ForPrivilegeItem">Manage Privileges</a>
                            </li>
                            <%}%>
<!--                            <li><a href="${context}/Privilege?action=LoadUserGroups">Set Privilege</a>
                            </li>-->
                            <%if (ca.checkUserAuth("SET_PRIVILEGE_ITEM", group) != null) {%>
                            <li><a href="${context}/Privilege?action=LoadUserGroupsForPI">Manage User Group Priviledges</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-newspaper-o"></i> Reports <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <%if (ca.checkUserAuth("EMPLOYEE_PROFILE_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=SearchEmployee">Employee Profile</a>
                            </li>
                            <%}%>
                             <%if (ca.checkUserAuth("EMPLOYEES_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=Employees">Employees</a>
                            </li>
                            <%}%>
                             <%if (ca.checkUserAuth("LEAVE_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=Leaves">Leaves</a>
                            </li>
                            <%}%>
                             <%if (ca.checkUserAuth("ATTENDANCE_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=Attendance">Attendance</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("BANK_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=Bank">Bank Accounts</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ALLOWANCE_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=Allowance">Allowance & Deduction</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("STAFFLOAN_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=staffloans">Staff Loans</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("HOLIDAY_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=holiday">Holidays</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ADVANCE_PAYMENT_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=advanse">Advance Payment</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("SALARY_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=salary">Salary</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("SALARY_PAYMENT_REPORT", group) != null) {%>
                            <li><a href="${context}/Report?action=salarypayment">Salary Payments</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("PAY_SLIP", group) != null) {%>
                            <li><a href="${context}/Report?action=payslip">Pay Slip</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("EPF_PAYABLE_REPOR", group) != null) {%>
                            <li><a href="${context}/Report?action=epf">EPF Payable</a>
                            </li>
                            <%}%>
                            <%if (ca.checkUserAuth("ETF_PAYABLE_REPOR", group) != null) {%>
                            <li><a href="${context}/Report?action=etf">ETF Payable</a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">

            <a data-toggle="tooltip" data-placement="top" title="Logout" href="${context}/Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>


<div class="top_nav">

    <div class="nav_menu">
        <nav class="" role="navigation">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
            <div style="" class="nav navbar-nav">
                <!-- Button -->
                <%
                    String success_message = (String) request.getAttribute("Success_Message");
                    String error_message = (String) request.getAttribute("Error_Message");
                    if (success_message == null) {
                        success_message = (String) session.getAttribute("Success_Message");
                    }
                    if (error_message == null) {
                        error_message = (String) session.getAttribute("Error_Message");
                    }
                    request.getSession().removeAttribute("Error_Message");

                %>
                <div class="" id="mydiv">
                    <strong><font color="green">
                        <% if (success_message != null) {
                                out.println(success_message);
                            }%>
                        </font>
                    </strong> 
                    <strong><font color="red">
                        <% if (error_message != null) {
                                out.println(error_message);
                            }%>
                        </font>
                    </strong> 
                </div>
            </div>
            <%
                request.getSession().removeAttribute("Error_Message");
                request.getSession().removeAttribute("Success_Message");

            %>
            <ul class="nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <%out.print(user.getFirstName() + " " + user.getLastName());%>
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                        <li><a href="${context}/app/users/editOwn.jsp">  Update Profile</a>
                        </li>
                        <li><a href="${context}/app/users/changePassword.jsp">  Change Password</a>
                        </li>

                        <li><a href="${context}/Logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                        </li>
                    </ul>
                </li>



            </ul>
        </nav>
    </div>

</div>

<!-- page content -->
<div class="right_col" role="main">