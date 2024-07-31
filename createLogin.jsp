<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>DND Free Create User Account</title>
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
    <form action="createLogin" method="post">
      <legend>DND Create User</legend>
         <tr>	 
		<td><label for="name">Name:</label></td>
		<td><input type="text" name="name" required autofocus /></td>
		<td><label for="email">Email:</label></td>
		<td><input type="text" name="email" required /></td>
		<td><label for="userName">Username: </label></td>
		<td><input type="text" name="userName" required /></td>
		<td><label for="password">Password: </label></td>
		<td><input type="password" name="password" required /></td>
	</tr>
              <input type="submit" value="Create Account"/>
    </form>
  </table>
  </body>
</html>
