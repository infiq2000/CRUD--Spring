<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> Course </h2>
		</div>
	</div>
	            <!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
	<div id="container">
	
		<div id="content">
			<table>
				<tr>
					<th>Title</th>
					<th>Instructor_id</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCourse" items="${courses}">
				
<%-- 					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempCustomer.id}" />
					</c:url>
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempCustomer.id}" />
					</c:url>	
					<c:url var="listCourse" value="/student/getListCourse">
						<c:param name="studentId" value="${tempCustomer.id}" />
					</c:url> --%>
					<tr>
						<td> ${tempCourse.id} </td>
						<td> ${tempCourse.title} </td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









