<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}"  />
		<!-- Home news -->
		<div class="container">
			<button>
				<b>+</b>
			</button>
			<!-- Example row of columns -->
			<table>
				<s:iterator value="eventos">
	     
			<td>
				<s:property value="nombre"/>
			</td>
			<s:property value="direccion"/>
			<td>
			<s:property value="ciudad"/>
			</td>
			<td>
			<s:property value="fecha"/>
			</td>
					<!-- this outputs the full object, may be useful for debugging -->
				</s:iterator>
			</table>
		</div>
		
			<!-- end Home news -->
	<t:footer/>
</t:base>