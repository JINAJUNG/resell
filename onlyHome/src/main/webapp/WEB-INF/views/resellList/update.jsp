<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String url = request.getParameter("pronum");%>
<script>
window.addEventListener('load',function(){
	var conf = {
		url : '/only/resellList/<%=url%>',
		success : resellDrow,
		method : 'GET'
	}
	var au = new AjaxUtil(conf);
	au.send();
})
var pronum;
function resellDrow(res){
	res = JSON.parse(res);
	pronum=res['pronum'];
	var html = '';
	for (ri in res) {
		try {
			if(res[ri]!=null){
				document.querySelector('[name=' + ri + ']').value=res[ri];	
			}
		} catch (e) {
			console.error(ri + ' can\'t find in document');
		}
	}
	console.log("err")
	/* return html; */
}
</script>
<!--Grid row-->
<div class="row wow justify-content-center">
	<!--Grid column-->
	<div class="col-md-6">

		<!-- Default form contact -->
		<form enctype="multipart/form-data" class="text-center p-5" action="/only/resellList">

			<p class="h4 mb-4">중고 물품 정보 수정</p>

			<!-- Subject -->
			<label>Category</label> <select
				class="browser-default custom-select mb-4" name="procategory" data-v="notnull">
				<option value="" >카테고리</option>
				<option value="전자기기">전자기기</option>
				<option value="의류">의류</option>
				<option value="가구">가구</option>
				<option value="과자">과자</option>
			</select>
			
			<label>제품번호</label>
			<input type="text" name="pronum"
				class="form-control mb-4" placeholder="제품번호" disabled >
			
			<label>제품이름</label>
			<input type="text" name="proname" data-v="notnull"
				class="form-control mb-4" placeholder="제품이름">
			
			<label>등록날짜</label>
			<input type="number" name="indate"
				class="form-control mb-4" placeholder="등록날짜" disabled >

			<label>등록가격</label>
			<input type="number" name="inpay" data-v="notnull"
				class="form-control mb-4" placeholder="등록가격" >

			<label>판매 확정일</label>
			<input type="date" name="outdate"
				class="form-control mb-4" placeholder="판매 확정날">
			
			<label>판매가격</label>
			<input type="number" name="outpay"
				class="form-control mb-4" placeholder="판매가격">
				
			<label>설명</label>
			<div class="form-group">
				<textarea class="form-control rounded-0"
					name="prodesc" rows="3" placeholder="설명"></textarea>
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
		var c=datach(formdata);
		if(c==-1){
			exit();
		}
		formdata = JSON.stringify(c)
		var conf = {
				url : form.getAttribute('action')+'/'+pronum,
				success : resellIn,
				method : 'PUT',
				params : formdata
			}
		var au = new AjaxUtil(conf);
		au.send();
			
	})
	
	function resellIn(res){
		if(res==1){
			alert('업데이트 완료');
			location.href='/only/url/resellList:list';
			return;
		}
		location.href='/only/url/resellList:update';
		alert('실패');
	}

	function datach(formdata){
		var params ={};
		for(key of formdata){	
			var k =key[0];
			var v = key[1];
			if((k=='procategory' || k=='proname' || k=='inpay') && v.length==0 ){
				alert(k+'의 값이 비었습니다.');
				return -1;
			}
			if(k=='outdate'){
				v = v.replace(/-/gi,'');
				if(document.querySelector('input[name="indate"]').value>v){
					alert('등록일 전에 팔렸어??');
					return -1;
				}
			}
			params[k]=v;
		}
		return params;
	}
</script>