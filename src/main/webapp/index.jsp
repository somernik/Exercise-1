<%@include file="head.jsp"%>
<html>
<style>
    form {
        width: 60%;
        margin: 2em;
    }

    input[type=text], select {
        padding: 12px 20px;
        margin: 8px 0;
        display: inline;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=text]:focus {
        background-color: lightblue;
    }

    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
<body>
<h2>User Display Exercise - Week 1</h2>
<form action="/searchUser">
    <h3>Search Users</h3>
    <select id="searchType" name="searchType">
        <option value="id">ID</option>
        <option value="f_name">First Name</option>
        <option value="l_name">Last Name</option>
    </select>
    <select id="searchOperator" name="searchOperator">
        <option value="=">=</option>
        <option value="LIKE">contains</option>
    </select>
    <input name="searchValue" id="searchValue" type="text" required />
    <input type="submit" value="Search" />
</form>
<a href = "searchUser">See all users</a>
</body>
</html>