<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--Grid row-->
<div class="row wow justify-content-center">
	<!--Grid column-->
	<div class="col-md-6">

		<!-- Default form contact -->
		<form method="POST" enctype="multipart/form-data" class="text-center p-5" action="/only/resellList">

			<p class="h4 mb-4">중고 물품 등록</p>

			<!-- Subject -->
			<label>Category</label> <select
				class="browser-default custom-select mb-4" name="procategory">
				<option value="" >카테고리</option>
				<option value="전자기기">전자기기</option>
				<option value="의류">의류</option>
				<option value="가구">가구</option>
				<option value="과자">과자</option>
			</select>
			<input type="text" name="proname"
				class="form-control mb-4" placeholder="제품이름">

			<input type="number" name="inpay"
				class="form-control mb-4" placeholder="가격">

			<div class="form-group">
				<textarea class="form-control rounded-0"
					name="prodesc" rows="3" placeholder="설명"></textarea>
			</div>

			<div class="form-group">
				<label>Only '.png' upload please</label>
				<input type="file" class="form-control-file" name="prophoto">
			</div>

			<!-- Send button -->
			<button class="btn btn-info btn-block" id="rebtn" type="button">Send</button>
		</form>
		<!-- Default form contact -->
	</div>
	<!--Grid column-->
</div>
<!--Grid row-->
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