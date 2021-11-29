<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${name}!</title>
</head>
<body>
<h2>Hello ${name}!</h2>
<#--это темплейт найдет-->
<h3> <#if configFpName??> Exist config_fp_name: '${configFpName}'</#if></h3>
<#--можно в квадратных скобках-->
<h3> [#if configFpName??] square siblings: ${configFpName} 2'[/#if]</h3>
<#--это темплейт не найдет и выпилит из html-->
<#if notConfigFpName??><h3>  Exist config_fp_name: '${notConfigFpName}'</h3></#if>

<#--Через точки (дот нотации) //TODO разобраться почему не работает-->
<#--<h3> [#if configFpName.second??]  conf_name: "[=configFpName.second]"[/#if]</h3>-->
</body>
</html>
