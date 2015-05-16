<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
<form method="post" action="" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent nowrap" layoutH="57">
		<div class="unit">
			<label>用户名: </label>
			<input type="text" name="username" class="required alphanumeric" minlength="6" maxlength="20"/>
		</div>
		<div class="unit">
			<label>密码: </label>
			<input type="text" name="password" class="required alphanumeric" minlength="6" maxlength="20"/>
		</div>
		<div class="unit">
			<label>昵称: </label>
			<input type="text" name="nickname" class="required" maxlength="30"/>
		</div>
		<div class="unit">
			<label>性别: </label>
			<select name="gender">
				<option>请选择</option>
				<option>男</option>
				<option>女</option>
			</select>
		</div>
		<div class="unit">
			<label>Email: </label>
			<input type="text" name="email" class="required email" maxlength="100"/>
		</div>
		<div class="unit">
			<label>电话: </label>
			<input type="text" name="phone" maxlength="30"/>
		</div>
		<div class="unit">
			<label>出生日期: </label>
			<input type="text" name="birthDate" class="date" readonly="readonly"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
		</div>
		<div class="unit">
			<label>个人简介：</label>
			<textarea  id="content" name="content" class="kindeditor" style="width: 680px; height: 200px;
                                visibility: hidden;"></textarea>			
		</div>
		<div class="unit">
			<label>上传头像：</label>
			<input class="ke-input-text" type="text" id="portrait" value="" readonly="readonly" />
			<input type="button" id="portraitBtn" value="Upload" />
		</div>
		<div class="unit">
			<label>备注：</label>
			<textarea id="reamrk" name="remark" class="kindeditor" style="width: 680px; height: 200px;
                                visibility: hidden;"></textarea>			
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
