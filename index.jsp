<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>DND Free Character Sheets</title>
      <link rel="stylesheet" href="style.css">
  </head>
  <style>
   fieldset {
     background-color: #eeeeee;
   }

   legend {
     background-color: gray;
     color: white;
     padding: 5px 10px;
   }

   input {
     margin: 5px;
   }
   table, th, td {
     border: 1px solid black;
     border-collapse: collapse;
   }
  </style>
  <body>
  <table>
    <form action="loginServlet" method="post">
      <legend>DND User Login</legend>
         <tr>	 
		<td><label for="userName">Username: </label></td>
		<td><input type="text" name="userName" required  autofocus/></td>
		<td><label for="password">Password: </label></td>
		<td><input type="text" name="password" required / ></td>
	</tr>
              <input type="submit" value="Login"/>
    </form>
  </table>
  <p>Click here if you need to create an account<a href="/dnd/createLogin.jsp">Create Account</a>.</p>
  </body>
</html>
