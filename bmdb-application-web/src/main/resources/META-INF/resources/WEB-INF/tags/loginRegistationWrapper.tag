<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn"
           uri = "http://java.sun.com/jsp/jstl/functions" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:bootstrapWrapper>

<div class="jumbotron text-white bg-dark">
    <div class="container text-center">
        <h1 class="display-4">Welcome to BMDB!</h1>
        <p>A media rating interface for reviewing and checking out details of series and movies.</p>
    </div>
</div>
<h2> <b> <a href="<c:url value='/login'/>" class="text-primary">Login</a> or <a href="<c:url value='/register'/>" class="text-primary">Register</a> to start! </b> </h2>
<jsp:doBody/>


</t:bootstrapWrapper>