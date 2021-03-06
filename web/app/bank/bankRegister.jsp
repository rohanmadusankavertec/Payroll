<%-- 
/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
--%>

<%@page import="com.sumaga.hibe.model.BankAccounts"%>
<%@page import="com.sumaga.hibe.model.Bank"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../template/header.jsp"%>
<%@include file="../../template/sidebar.jsp"%>
<script src="app/js/invoice.js"></script>
<script src="app/js/notAlert.js"></script>

<div class="">

    <%
        List<Bank> bList = (List<Bank>) request.getAttribute("bList");
        List<BankAccounts> baList = (List<BankAccounts>) request.getAttribute("baList");

    %>
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Bank Account<small>Add Bank Account</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>

                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <form action="Bank?action=SaveAccount" method="post" class="form-horizontal" novalidate>

                        <div class="item form-group" style="padding-top: 20px;" id="branchwise">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Enter Account No <span class="required"></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" id="accNo" name="accNo" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                        </div>   
                        <div class="item form-group" style="padding-top: 20px;">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Select Account Type <span class="required"></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="accType" id="accType"  required="required">
                                    <option selected="true"  value="Saving Account">Saving Account</option>
                                    <option selected="true"  value="Current Account">Current Account</option>
                                </select>                              
                            </div>
                        </div>  
                        <div class="item form-group" style="padding-top: 20px;">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Select Bank <span class="required"></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select class="form-control" name="bankId" id="bankId"  required="required">
                                    <option selected="true" disabled value="">Select Bank</option>
                                    <%for (Bank b : bList) {%>
                                    <option selected="true"  value="<%=b.getId()%>"><%=b.getBankName() + " " + b.getBranch() %></option>
                                    <%}%>
                                </select>                              
                            </div>
                        </div>  
                        
                        <div class="item form-group" style="padding-top: 50px;">
                            <div class="col-xs-12 col-lg-offset-3">
                                <button class="btn btn-success" id="updateP"><i class="fa fa-arrow-right"></i>  Save </button>
                            </div>
                        </div> 
                    </form>
                    <div class="container">
                        <a id="modal_trigger" href="#modal" class="btn btn-success pull-right">Add Bank</a>

                        <div id="modal" class="popupContainer" style="display:none;">
                            <header class="popupHeader">
                                <span class="header_title">Register Bank</span>
                                <span class="modal_close"><i class="fa fa-times"></i></span>
                            </header>

                            <section class="popupBody">


                                <!-- Register Form -->
                                <div class="user_register col-md-12 col-sm-12 col-xs-12">
                                    <form action="Bank?action=SaveBank" method="post">
                                        <div class="item form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12" for="name">Enter Bank Name<span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="bankName" name="bankName" required="required" class="form-control col-md-7 col-xs-12">

                                            </div>
                                        </div>   <br/><br/>
                                        <div class="item form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12" for="name">Enter Branch<span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="branchName" name="branchName" required="required" class="form-control col-md-7 col-xs-12">

                                            </div>
                                        </div>  <br/><br/>
                                        <div class="item form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12" for="name">Address<span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="address" name="address" required="required" class="form-control col-md-7 col-xs-12">

                                            </div>
                                        </div>  <br/><br/>
                                        <div class="item form-group">
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12" for="name">Contact No<span class="required"></span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="contactNo" name="contactNo" required="required" class="form-control col-md-7 col-xs-12">

                                            </div>
                                        </div>  





                                        <div class="action_btns" style="padding-top: 30px;">
                                            <div class="one_half last col-md-offset-3"><button type="submit" class="btn btn-success pull-right"><i class="fa fa-briefcase"></i>Save Bank</button></div>
                                        </div>
                                    </form>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="row">

        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Registered users <small>up to now</small></h2>
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

                                    <th>Account No</th>
                                    <th>Account Type </th>
                                    <th>Bank</th>
                                    <th class=" no-link last"><span class="nobr">Action</span>
                                    </th>
                                </tr>
                            </thead>

                            <tbody>

                                <% for (BankAccounts ba : baList) {%>
                                <tr>

                                    <td class=" "><%=ba.getAccountNo()%></td>
                                    <td class=" "><%=ba.getAccountType()%></td>
                                    <td class=" "><%=ba.getBankId().getBankName()%></td>

                                    <td class=" last"> 
                                        <form name="form1" method="post" action="Bank?action=UpdateAccount"><input type="hidden" name="bankAccountId" value="<%=ba.getId()%>"/>
                                            <button type="submit" class="glyphicon glyphicon-edit">

                                            </button></form>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>

        <br />
        <br />
        <br />

    </div>
</div>
<!-- footer content -->
<%@include file="../../template/footer.jsp"%>
<script type="text/javascript">
    $("#modal_trigger").leanModal({top: 200, overlay: 0.6, closeButton: ".modal_close"});

    $(function () {


        // Calling Register Form
        $("#modal_trigger").click(function () {
            $(".user_register").show();
            $(".header_title").text('Add Bank');
            return false;
        });



    });
</script>
<script>
    // initialize the validator function
    validator.message['date'] = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
            .on('blur', 'input[required], input.optional, select.required', validator.checkField)
            .on('change', 'select.required', validator.checkField)
            .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required')
            .on('keyup blur', 'input', function () {
                validator.checkField.apply($(this).siblings().last()[0]);
            });

    // bind the validation to the form submit event
    //$('#send').click('submit');//.prop('disabled', true);

    $('form').submit(function (e) {
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
    $('#vfields').change(function () {
        $('form').toggleClass('mode2');
    }).prop('checked', false);

    $('#alerts').change(function () {
        validator.defaults.alerts = (this.checked) ? false : true;
        if (this.checked)
            $('form .alert').remove();
    }).prop('checked', false);
</script>
<script>
    $(document).ready(function () {
        $('input.tableflat').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });
    });

    var asInitVals = new Array();
    $(document).ready(function () {
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
        $("tfoot input").keyup(function () {
            /* Filter on the column based on the index of this element's parent <th> */
            oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
        });
        $("tfoot input").each(function (i) {
            asInitVals[i] = this.value;
        });
        $("tfoot input").focus(function () {
            if (this.className == "search_init") {
                this.className = "";
                this.value = "";
            }
        });
        $("tfoot input").blur(function (i) {
            if (this.value == "") {
                this.className = "search_init";
                this.value = asInitVals[$("tfoot input").index(this)];
            }
        });
    });
</script>