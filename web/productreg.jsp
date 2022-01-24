<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>Add Product</title>
        <style type="text/css">
            .button-register {
                background-color: green;
                color: white;
            }
            .button-report {
                background-color: #000000;
                color: white;
                margin-left: 30%;
            }
        </style>
        <script>
            function validateForm() {
                let productName = document.forms["myForm"]["productName"].value;
                let poductMake = document.forms["myForm"]["productMake"].value;
                let price = document.forms["myForm"]["price"].value;
                let availability = document.forms["myForm"]["availability"].value;
                if (productName === "" || poductMake==="" || price==="" || availability==="") {
                    alert("Name must be filled out");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h2>Simple CURD Using STRUTS2 FRAMEWORK</h2>
        <a href="productList.action"><button class="button-report" type="button">Report</button></a>
        <s:form name="myForm" action="addproduct.action" method="post" onsubmit="return validateForm()">
            <s:textfield label="Product Name" name="productName" />
            
            <s:textfield label="Product Make" name="productMake" />
            <s:textfield label="Price" name="price" />
            <s:textfield label="Availibility" name="availability" />
            <s:submit cssClass="button-add" value="AddProduct" />
        </s:form>
        <s:if test="ctr>0">
            <span style="color: green;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>