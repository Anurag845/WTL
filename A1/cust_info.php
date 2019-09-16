<html>


<?php
        if(isset($_POST['submit']))
        {
            $xml = new DOMDocument("1.0","UTF-8");
            $xml->load('cust_info.xml');
            
            $rootTag = $xml->getElementsByTagName("Customers")->item(0);
            
            $dataTag = $xml->createElement("customer");
            
            $name = $xml->createElement("name",$_POST['cust_name']);
            $city = $xml->createElement("city",$_POST['city']);
            $gender = $xml->createElement("gender",$_POST['gender']);
//            
            $lng="";
            foreach($_POST['lang'] as $selected){
            	$lng=$lng.$selected.",";
            }   
            
            $languages = $xml->createElement("languages",$lng);
             
            $dataTag->appendChild($name);
            $dataTag->appendChild($city);
            $dataTag->appendChild($gender);
            $dataTag->appendChild($languages);
            
            $rootTag->appendChild($dataTag);
            
            $xml->save('cust_info.xml');
            
        }
?>

<head>
	<link rel="stylesheet" type="text/css" href="cust_info.css">
</head>

<body>
	<fieldset>
		<legend>Customer Information</legend>
			<form action="cust_info.php" method="POST">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="cust_name"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><textarea rows="3" name="cust_addr"></textarea></td>
					</tr>
					<tr>
						<td>Gender</td>
						<td>
							<select name="gender">
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Languages</td>
						<td>
							<input type="checkbox" name="lang[]" value="english">English
							<br>
							<input type="checkbox" name="lang[]" value="hindi">Hindi
							<br>
							<input type="checkbox" name="lang[]" value="marathi">Marathi
							<br>
							<input type="checkbox" name="lang[]" value="sanskrit">Sanskrit
							<br>
							<input type="checkbox" name="lang[]" value="german">German
						</td>
					</tr>
					<tr>
						<td>City</td>
						<td>
							<select name="city">
								<option value="pune">Pune</option>
								<option value="mumbai">Mumbai</option>
								<option value="bangalore">Bangalore</option>
								<option value="chennai">Chennai</option>
								<option value="delhi">Delhi</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="text-align:center; width:50%;"><input type="reset" value="Reset"></td>
						<td style="text-align:center; width:50%;"><input type="submit" value="Submit"></td>
					</tr>
				</table>
			</form>
	</fieldset>

</body>

</html>
