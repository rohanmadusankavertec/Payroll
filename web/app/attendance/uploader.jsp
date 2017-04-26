<%-- 
/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
--%>

<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            
            if(isMultipart){
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try{
                    
                    List<FileItem> fi = upload.parseRequest((RequestContext) request);
                    for (FileItem itm : fi) {
                        if(!itm.isFormField()){
                            String name = new File(itm.getName()).getName();
                           // itm.write(new File(request.getServletContext().getRealPath("/")+"myFile/"+System.currentTimeMillis()+"_"+name));
                            itm.write(new File("D:/ar/"+System.currentTimeMillis()+"_"+name));
                        }
                    }
                    
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }else{
            }
        %>
    </body>
</html>
