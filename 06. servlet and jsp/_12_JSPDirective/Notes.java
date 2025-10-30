/*

    NOTES:
	- JSP Directive:
		- @page
		- @include
		- @taglib



	@page
		<%@ page attribute="value" attribute="value" attribute="value" ... %>

		language="scripting language"
		extends= "className"
		import="importlist"
		session="true|false"
		autoFlash="true|false"
		contentType="ctinfo"
		errorPage="error_url"
		isErrorPage="true|false"
		info="Information"
		isThreadSafe="true|false"
		isELIgnore="true|false"

		<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*, java.sql.*" info="Contact Page"
			extends="com.jarvis.User" isThreadSafe="true" isELIgnore="true" session="false" pageEncoding="UTF-8"
		%>

        NOTE:
            - 'import' is the only attribute you can have several of



	@include
		<%@ include file="filename" %>
		<%@ include file="header.jsp" %>



	@taglib
		<%@ taglib uri="uri" prefix="fx" %>
		<fx:navin>

 */

public class Notes {
}
