<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>

function resellDrow(res){
	res = JSON.parse(res);
	var html = '';
	document.querySelector('#tbody').innerHTML='';
	for(var riv of res){
		html += '<tr data-move="view" onclick="movePage(this)">';
		for(rik in riv){
			if(rik=='pronum'){
				html += '<th scopoe="row">'+riv[rik]+'</th>';
				continue;
			}else if (riv[rik]==null){
				html += '<td></td>';
				continue;
			}else if(rik=='prophoto' && riv['prophoto']!=null){
				html += '<td> O </td>';
				continue;
			}
			html += '<td>'+riv[rik]+'</td>';
		}
		html += '</tr>';
	}
	document.querySelector('#tbody').insertAdjacentHTML('beforeend',html);
	/* return html; */
}
window.addEventListener('load',function(){
	var conf = {
			url : '/only/resellList',
			success : resellDrow,
			method : 'GET'
	}
	var au = new AjaxUtil(conf);
	au.send();
	
	/* console.log(au.getReturnVar()) */
});


</script>

<!-- Heading -->
<div class="card mb-4 wow fadeIn">

	<!--Card content-->
	<div class="card-body d-sm-flex justify-content-between">

		<h4 class="mb-2 mb-sm-0 pt-1">
			<a href="#" target="_blank">Home Page</a> <span>/</span> <span>RESELL</span>
		</h4>

		<div class="d-flex justify-content-center">
			<!-- Default input -->
			<select
				class="browser-default custom-select mb-4" name="seK">
				<option value="pronum">제품번호</option>
				<option value="procategory">카테고리</option>
				<option value="proname">제품이름</option>
				<option value="indate">등록일</option>
			</select> <input type="search" placeholder="Type your query"
				aria-label="Search" class="form-control" name="seV">
			<button class="btn btn-primary btn-sm my-0 p" id="sebtn">
				<i class="fa fa-search"></i>
			</button>

		</div>
		<!-- form up -->
	</div>

</div>
<!-- Heading -->

<!--Grid row-->
<div class="row wow fadeIn">
	<!--Grid column-->
	<div class="col-md-12">

		<!--Card-->
		<div class="card">

			<!--Card content-->
			<div class="card-body">

				<!-- Table  -->
				<table class="table table-hover">
					<!-- Table head -->
					<thead class="blue lighten-4">
						<tr>
							<th>ProNum</th>
							<th>Category</th>
							<th>ProName</th>
							<th>InDate</th>
							<th>InPay</th>
							<th>OutDate</th>
							<th>OutPay</th>
							<th>Desc</th>
							<th>Photo</th>
						</tr>
					</thead>
					<!-- Table head -->

					<!-- Table body -->
					<tbody id="tbody">
					</tbody>
					<!-- Table body -->
				</table>
				<!-- Table  -->
			</div>
		</div>
		<!--/.Card-->

	</div>
	<!--Grid column-->
</div>
<!--Grid row-->

<!-- Heading -->
<div class="row justify-content-end">
	<div class="col-md-2">
		<button type="button" class="btn btn-light-blue"
			onclick="movePage(this)" data-move="insert">등록</button>
	</div>
</div>
<!-- Heading -->

<script>

function movePage(obj){
	var move = '/only/url/resellList:';
	var viewval='';
	if(obj.firstChild.nodeName=="TH"){
		viewval = ':'+obj.firstElementChild.innerText;
	}
	move = move +  obj.getAttribute('data-move')+viewval;
	location.href = move;
}

var sebtn = document.querySelector('#sebtn');

sebtn.addEventListener('click',function(){
	var sek = document.querySelector('[name="seK"]').value;
	var sev = document.querySelector('[name="seV"]').value;
	var param = sek+'='+sev;
	console.log(param)
	/* 
	param[sek]=sev;
	param = JSON.stringify(param);
	
	var formd = new FormData();
	formd.append(sek,sev);
	*/

	var conf = {
			url:'/only/resellList?'+param,
			method: 'GET',
			success : resellDrow
	}

	var au = new AjaxUtil(conf)
	au.send();
});
</script>