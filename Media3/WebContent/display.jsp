<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
1111111111111111

<table border="1" width="100%" >
<c:forEach items="${students}" var="student" varStatus="i" >
<tr>

   <td><c:out value="${student.dob}" /></td>
   <td><c:out value="${student.phone_number}" /></td>
   <td><c:out value="${student.created_at }" /></td>
   <td><c:out value="${student.id}" /></td>
  
  







</tr>
</c:forEach>
</table>
</body>
</html>