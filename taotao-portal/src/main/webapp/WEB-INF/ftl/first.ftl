<html>
<head>
	<title>${title}</title>
	<script type="text/javascript">
		alert(document.location.protocol);
	</script>
</head>
<body>
	<label>学号：</label>${student.id}<br>
	<label>姓名：</label>${student.name}<br>
	<label>住址：</label>${student.address}<br>
	
	<#list lists as l>
	${l} &lt; ${l_index}
	</#list>
	date
	
	${aaa!"空的"}

	<#assign test=123>
	${test}
	${test?string}
	${test?string.currency} <br>
	${test?string.percent}<br>
	
</body>
</html>