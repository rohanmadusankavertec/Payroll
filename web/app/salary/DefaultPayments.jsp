<%-- 
/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
--%>

<%@page import="com.sumaga.hibe.model.Employee"%>
<%@page import="com.sumaga.hibe.model.Designation"%>
<%@page import="com.sumaga.hibe.model.PayrollDefault"%>
<%@page import="com.sumaga.hibe.model.HollyDay"%>
<%@page import="com.sumaga.hibe.model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../template/header.jsp"%>
<%@include file="../../template/sidebar.jsp"%>
<script src="app/js/notAlert.js"></script>
<script type="text/javascript">
    function nom_Success(text) {
        BootstrapDialog.show({
            title: 'Notification',
            type: BootstrapDialog.TYPE_SUCCESS,
            message: text,
            size: BootstrapDialog.SIZE_NORMAL
        });
    }
    function sm_warning(text) {
        BootstrapDialog.show({
            title: 'Warning',
            type: BootstrapDialog.TYPE_WARNING,
            message: text,
            size: BootstrapDialog.SIZE_SMALL
        });
    }
    //This function will delete default Payment
    function DeleteDefaultPayment(id) {
        BootstrapDialog.show({
            message: 'Do you want to Delete ?',
            closable: false,
            buttons: [{
                    label: 'Yes',
                    action: function(dialogRef) {
                        dialogRef.close();
                        var xmlHttp = getAjaxObject();
                        xmlHttp.onreadystatechange = function()
                        {
                            if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
                            {
                                var reply = xmlHttp.responseText;
                                if (reply === "Success") {
                                    nom_Success("Default Payment Successfully Deleted ");
                                    setTimeout("location.href = 'Salary?action=ViewDefaultPayments';", 1500);
                                } else {
                                    sm_warning("Default Payment is Not Deleted, Please Try again.");
                                }
                            }
                        };
                        xmlHttp.open("POST", "Salary?action=deletedefaultPayment&id=" + id, true);
                        xmlHttp.send();
                    }
                }, {
                    label: 'No',
                    action: function(dialogRef) {
                        dialogRef.close();
                    }
                }]
        });
    }
    //Load designation to select element
    function loadDesignation() {
        $("#designation").empty();
        var desi = document.getElementById('designation');
        var t1 = document.createElement("option");

        t1.innerHTML = "Select Designation";
        desi.appendChild(t1);
        var dept = document.getElementById('departmentname').value;
        $.ajax({
            type: "POST",
            url: "Employee?action=getDesignation&id=" + dept,
            success: function(msg) {
                var reply = eval('(' + msg + ')');

                var arrLn1 = reply.des;
                for (var f = 0; f < arrLn1.length; f++) {
                    var t = document.createElement("option");
                    var val = arrLn1[f].id;
                    t.value = val;
                    t.innerHTML = arrLn1[f].designation;
                    desi.appendChild(t);
                }
            }
        });
    }
</script>



<%if (ca.checkUserAuth("ADD_USER", group) != null) {%>
<div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>
                Default Payments
                <%
                    List<Employee> employee = (List<Employee>) request.getAttribute("employee");
                    List<PayrollDefault> bList = (List<PayrollDefault>) request.getAttribute("dp");
                %>
            </h3>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Default Payments<small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form action="Salary?action=AddDefaultPayment" method="post" class="form-horizontal form-label-left" novalidate>

                        <span class="section"></span>
                        <div class="item form-group">
                            <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">Employee</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="employee" id="employee"  required="required" >
                                    <option selected="true" disabled="true" >Select Employee</option>
                                    <%for (Employee emp : employee) {%>
                                    <option value="<%=emp.getId() %>"><%=emp.getFname()+" "+emp.getLname() %></option>
                                    <%
                                        }
                                    %>
                                </select>                            
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Over Time Payment per Hour (LKR)<span class="required"></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input class="form-control col-md-7 col-xs-12"  data-validate-words="1" name="ot" required="required" type="number">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">No Pay Deduction per Hour (LKR)<span class="required"></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input class="form-control col-md-7 col-xs-12" name="np" type="number">
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4 col-lg-offset-4">
                                <button id="send" type="submit" class="btn btn-success">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Current Default Payments <small>up to now</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div class="table-responsive">
                        <table id="example" class="table table-striped responsive-utilities jambo_table">
                            <thead>
                                <tr class="headings">
                                    <th>Employee</th>
                                    <th>O/T Payment per hour </th>
                                    <th>No Pay Deduction per Hour</th>
                                    <th class=" no-link last"><span class="nobr">Action</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (PayrollDefault pi : bList) {%>
                                <tr>
                                    <td class=""><%= pi.getEmployeeId().getFname()+" "+pi.getEmployeeId().getLname() %></td>
                                    <td class=""><%=pi.getOtHr()%></td>
                                    <td class=""><%=pi.getNoPayHr()%></td>
                                    <td class="last"><input type="submit" value="Delete" class="btn btn-warning" onclick="DeleteDefaultPayment('<%=pi.getId()%>')" /> </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <br/>
        <br/>
    </div>
</div>
<%} else {%>
<script type="text/javascript">
    window.location = 'error403.jsp';
</script>
<%}%>





<!-- footer content -->
<%@include file="../../template/footer.jsp"%>
<script>
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
            .on('keyup blur', 'input', function() {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function(e) {
        e.preventDefault();
        var submit = true;
        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
            this.submit();
        return false;
    });

    /* FOR DEMO ONLY */
    $('#vfields').change(function() {
        $('form').toggleClass('mode2');
    }).prop('checked', false);

    $('#alerts').change(function() {
        validator.defaults.alerts = (this.checked) ? false : true;
        if (this.checked)
            $('form .alert').remove();
    }).prop('checked', false);
</script>
<script>
    $(document).ready(function() {
        $('input.tableflat').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });
    });

    var asInitVals = new Array();
    $(document).ready(function() {
        var oTable = $('#example').dataTable({
            "oLanguage": {
                "sSearch": "Search all columns:"
            },
            "aoColumnDefs": [{
                    'bSortable': false,
                    'aTargets': [0]
                } //disables sorting for column one
            ],
            'iDisplayLength': 12,
            "sPaginationType": "full_numbers",
            "dom": 'T<"clear">lfrtip',
            "tableTools": {
                "sSwfPath": "${context}/resources/js/datatables/tools/swf/copy_csv_xls_pdf.swf"
            }
        });
        $("tfoot input").keyup(function() {
            /* Filter on the column based on the index of this element's parent <th> */
            oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
        });
        $("tfoot input").each(function(i) {
            asInitVals[i] = this.value;
        });
        $("tfoot input").focus(function() {
            if (this.className == "search_init") {
                this.className = "";
                this.value = "";
            }
        });
        $("tfoot input").blur(function(i) {
            if (this.value == "") {
                this.className = "search_init";
                this.value = asInitVals[$("tfoot input").index(this)];
            }
        });
    });
</script>