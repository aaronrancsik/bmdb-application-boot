<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn"
           uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:loginRegistationWrapper>
    <div class="row">
        <div class="col-lg-4 col-md-12">
            <div class="card">
                <div class="card-header bg-primary">
                    <h4><b>Registration</b></h4>
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
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <spring:bind path="password">
                                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                                <form:errors path="password"/>
                            </spring:bind>
                        </div>
                        <button type="submit" class="btn bg-primary">Register</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</t:loginRegistationWrapper>
