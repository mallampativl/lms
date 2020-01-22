<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <form action="save"> 
<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>NAME</th><th>FROMDATE</th><th>TODATE</th></tr>  
   <c:forEach var="list" items="${list}">   
   <tr>  
   <td>${list.name}</td>  
   <td>${list.fromDate}</td>  
   <td>${list.toDate}</td>  
  	<td>${list.no_of_days}</td>
    
   </tr>  
   </c:forEach>  
   </table> 
    
 </form>