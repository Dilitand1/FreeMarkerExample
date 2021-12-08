<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome [=user]!</h1>
<p>Our latest product:
    <a href="[=latestProduct.url]">[=latestProduct.name]</a>
    <h3>[#if latestProduct.serviceName??] Exist config_fp_name: '[=latestProduct.serviceName]' [/#if]</h3>
</body>
</html>