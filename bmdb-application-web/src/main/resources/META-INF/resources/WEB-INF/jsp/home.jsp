<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:bootstrapWrapper>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark rounded">
        <a class="navbar-brand">Media reviews</a>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link">Media</a>
            </li>
            <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Language</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item">Hungarian</a>
                    <a class="dropdown-item">English</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">

                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <div class="rounded border border-light">
                        <button id="sub" type="submit" class="btn btn-dark">Logout</button>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </li>
        </ul>
    </nav>

    <div class="card mt-5">
        <div class="card-header bg-primary">
            <h4><b>User details</b></h4>
        </div>
        <div class="card-body">
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <spring:bind path="name">
                        <form:input type="text" path="name" class="form-control" placeholder="Name"
                                    autofocus="true"/>
                        <form:errors path="name"/>
                    </spring:bind>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <spring:bind path="email">
                        <form:input type="email" path="email" class="form-control"
                                    placeholder="Email"/>
                        <form:errors path="email"/>
                    </spring:bind>
                </div>
                <button type="submit" class="btn bg-primary">Save</button>
            </form:form>
        </div>
    </div>


    <div class="card mt-5">
        <div class="card-header bg-primary">
            <h4><b>Reviews</b></h4>
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Creator</th>
                    <th scope="col">Associated media</th>
                    <th scope="col">Rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rev" items="${reviews}">
                    <tr>
                        <th scope="row"><c:out value="${rev.id}"/></th>
                        <td><b><c:out value="${rev.creator.name}"/></b></td>
                        <td>
                            <b><c:out value="${rev.media.title}"/></b>
                        </td>
                        <td><b> <c:out value="${rev.rating}"/></b></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</t:bootstrapWrapper>