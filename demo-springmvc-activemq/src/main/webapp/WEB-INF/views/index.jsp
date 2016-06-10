<html>
<body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<h2>Hello World!</h2>

<a id="btn" href="#">ActiveMQ Send Message</a>

<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.get("/click");
		});
	});
</script>
</body>
</html>
