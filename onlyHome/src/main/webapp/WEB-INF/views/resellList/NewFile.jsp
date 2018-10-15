<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	<link rel="stylesheet" id="compiled.css-css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/compiled-4.5.12.min.css?ver=4.5.12" type="text/css" media="all">
<style>
.file-field.medium .file-path-wrapper {
  height: 3rem; }
  .file-field.medium .file-path-wrapper .file-path {
    height: 2.8rem; }

.file-field.big-2 .file-path-wrapper {
  height: 3.7rem; }
  .file-field.big-2 .file-path-wrapper .file-path {
    height: 3.5rem; }
</style> -->
<form action="/only/resellList" method="POST" enctype="multipart/form-data">
		이름 : <input type="text" name="name"><br> 이미지 : <input
			type="file" name="img"><br>
		<button type="button" id="rebtn">전송</button>
	</form>

<script>
	var btn = document.querySelector('#rebtn');
	btn.addEventListener('click',function(){
		var form = document.querySelector('form');
		var formdata = new FormData(form);

		if(datach(formdata)==-1){
			exit();
		}
		var conf = {
				url : form.getAttribute('action'),
				success : resellIn,
				method : form.getAttribute('method'),
				params : formdata
			}
		console.log()
		var au = new AjaxUtil(conf);
		au.send();
			
	})
	
	function resellIn(res){
		if(res==1){
			alert('등록 완료');
			location.href='/only/url/resellList:list';
			return;
		}
		location.href='/only/url/resellList:insert';
		alert('실패');
	}

	function datach(formdata){
		for(key of formdata){
			if(key[0]!='prodesc' && key[0]!='prophoto'){
				if(key[1].length==0){
					alert(key[0]+'의 값이 비었습니다.');
					return -1;
				}	
			}
		}
		return 0;
	}
</script>