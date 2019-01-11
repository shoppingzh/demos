<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跨越请求</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
</head>
<body>

<button id="request">发出请求</button>
<button id="request-jsonp">发出请求(jsonp)</button>
<div id="container"></div>

<script type="text/javascript">
$(function(){
	/* $('#request').click(function(){
		var url = "http://localhost/jsonp-site1/user/profile/1";
		  $.post(url, {}, function(user){
		    showData(user);
		  });
	}); */
	
	$('#request').click(function(){
		//不要一直append，注意删除以前的<script>标签
		$('script[src="http:\/\/localhost\/jsonp-site1\/user\/profile\/1?callback=showData"]').remove();
		$('head').append($('<script src="http://localhost/jsonp-site1/user/profile/1?callback=showData"><\/script>'));
	});
	
	$('#request-jsonp').click(function(){
		$.ajax({
			url: "http://localhost/jsonp-site1/user/profile/1",
			type: "GET",
			dataType: "jsonp",
			jsonpCallback: "showData",
			success: function(result){
				showData(result);
			}
		});
	});
	
});
function showData(result){
  var $container = $('#container');
  $container.children().hide(500);
  $container.append($('<p></p>').text('姓名：' + result.name));
  $container.append($('<p></p>').text('年龄：' + result.age ));
  $container.append($('<p></p>').text('简述：' + result.description));
}
</script>

</body>
</html>