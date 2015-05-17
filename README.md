# demo-springmvc-mybatis-dwz
## js
 ```
 //KindEditor.uploadbutton上传文件
    $("input.ke-input-text", $p).each(function() {
    	var $thiz = $(this), _id = $thiz.attr("id");
    	$.getScript(ctx+'/static/kindeditor/kindeditor-min.js', function() {
    		var uploadbutton = KindEditor.uploadbutton({
				button : KindEditor('#'+_id+"Btn"),
				fieldName : 'imgFile',
				url : ctx+'/upload?dir=file',
				afterUpload : function(data) {
					if (data.error === 0) {
						//var url = KindEditor.formatUrl(data.url, 'absolute');
						$thiz.val(data.url);
					} else {
						alert(data.message);
					}
				},
				afterError : function(str) {
					alert('自定义错误信息: ' + str);
				}
			});
			uploadbutton.fileBox.change(function(e) {
				uploadbutton.submit();
			});
            
            prettyPrint();
        });
    });
 ```
## html
```
<div class="unit">
	<label>上传身份证：</label>
	<input class="ke-input-text" type="text" id="card" value="" readonly="readonly" />
	<input type="button" id="cardBtn" value="上传身份证" />
</div>
```
