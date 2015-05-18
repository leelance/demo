# demo-springmvc-mybatis-dwz
dwz加入kindeditor部分插件, 如: 富文本编辑器, 上传文件插件, 由于dwz集成的是uploadify flash类型插件
当一个页面很多个上传附件插件时, 会出现页面渲染缓慢
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
