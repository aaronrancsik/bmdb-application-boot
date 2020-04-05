<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:loginRegistationWrapper>
    <div class="row">
        <div class="col-lg-4 col-md-12">
            <div class="card">
                <div class="card-header bg-primary">
                    <h4><b>Login</b></h4>
                </div>
                <div class="card-body">
                    <form method="POST" action="${contextPath}/login" class="form-signin">
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>
                            <input name="username" type="text" class="form-control" placeholder="Username"
                                   autofocus="true"/>
                        </div>
                        <div class="form-group">
                            <input name="password" type="password" class="form-control" placeholder="Password"/>
                            <span>${error}</span>
                        </div>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn bg-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</t:loginRegistationWrapper>

