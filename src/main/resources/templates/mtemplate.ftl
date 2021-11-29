<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
</head>
<body>

<input type="text" placeholder="${name}">

<table>
    <#list persons as row>
    <tr>
        <#list row as field>
            <td>${field}</td>
        </#list>
    </tr>
    </#list>
</table>

</body>
</html>