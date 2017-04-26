<%-- 
/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="template/header.jsp"%>
<%@include file="template/sidebar.jsp"%>
<script src="app/js/notAlert.js"></script>

<script type="text/javascript">
    loadData();
    function loadData() {
        $.ajax({
            type: "POST",
            url: "Report?action=dashboard",
            success: function(msg) {
                var reply = eval('(' + msg + ')');
                var arrLn1 = reply.des;
                for (var f = 0; f < arrLn1.length; f++) {
                    document.getElementById("employee").innerHTML=arrLn1[f].employee;
                    document.getElementById("advance").innerHTML=arrLn1[f].advance;
                    document.getElementById("salary").innerHTML=arrLn1[f].salary;
                    document.getElementById("payment").innerHTML=arrLn1[f].payment;
                    document.getElementById("outstanding").innerHTML=arrLn1[f].outstanding;
                    document.getElementById("loan").innerHTML=arrLn1[f].loan;
                    document.getElementById("holiday").innerHTML=arrLn1[f].holiday;
                    document.getElementById("users").innerHTML=arrLn1[f].users;
                }
            }
        });
    }
</script>




<div class="">
    <div class="row top_tiles">
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-users"></i>
                </div>
                <div class="count" id="employee">0</div>
                <h3>Employees</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-money"></i></div>
                <div class="count" id="advance">0</div>
                <h3>Advance Paid</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-database"></i>
                </div>
                <div class="count" id="salary">0</div>
                <h3>Total Salaries</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-paypal"></i></div>
                <div class="count" id="payment">0</div>
                <h3>Total Payments</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-outdent"></i></div>
                <div class="count" id="outstanding">0</div>
                <h3>Total Outstanding</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-dollar"></i></div>
                <div class="count" id="loan">0</div>
                <h3>Pending Staff Loans</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-calendar"></i></div>
                <div class="count" id="holiday">0</div>
                <h3>Holidays</h3>
                <p></p>
            </div>
        </div>
        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
            <div class="tile-stats">
                <div class="icon"><i class="fa fa-user-secret"></i></div>
                <div class="count" id="users">0</div>
                <h3>Users</h3>
                <p></p>
            </div>
        </div>
    </div>




</div>

<script src="resources/js/echart/echarts-all.js"></script>
<script src="resources/js/echart/green.js"></script>
<script src="app/js/dashboard.js"></script>

<!-- footer content -->
<%@include file="template/footer.jsp"%>
