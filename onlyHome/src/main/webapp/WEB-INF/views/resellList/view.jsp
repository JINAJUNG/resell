<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	function resellDrow(res) {
		res = JSON.parse(res);
		/* data-속성으로만 가져오는방법쓰 var hObjs = document.querySelectorAll('[data-field]'); */
		var html = '';
		var img;
		for (ri in res) {
			try {
				if(ri=='prophoto'){
					if( res[ri]==null){
						img = document.querySelector('[data-field=' + ri + ']');
						img.src = '../resources/img/notfound.png';
						continue;
					}
					img = document.querySelector('[data-field=' + ri + ']');
					img.src='../resources/img/'+res[ri];
					continue;
				}
				document.querySelector('[data-field=' + ri + ']')
						.insertAdjacentHTML('beforeend', res[ri]);
				if (ri === 'prodesc' && res[ri] == null) {
					document.querySelector('[data-field=prodescname]').style.display = 'none';
					document.querySelector('[data-field=prodesc]').style.display = 'none';
				}

			} catch (e) {
				console.error(ri + ' can\'t find in document');
			}
		}
		/* return html; */
	}

	window.addEventListener('load', function() {
		var loV = window.location.href.substring(window.location.href
				.lastIndexOf(':') + 1);
		var conf = {
			url : '/only/resellList/' + loV,
			success : resellDrow,
			method : 'GET'
		}
		var au = new AjaxUtil(conf);
		au.send();

		/* console.log(au.getReturnVar()) */
	});
</script>

<!--Grid row-->
<div class="row wow justify-content-center">
	<!--Grid column-->
	<div class="col-md-4">
		<!-- card -->
		<div class="card card-cascade narrower">

			<!--Card image-->
			<div class="view view-cascade">
				<img class="card-img-top" alt="photo" data-field="prophoto"> <a>
					<div class="mask img-gradient"></div>
				</a>
			</div>
			<!--/.Card image-->

			<!--Card content-->
			<div class="card-body card-body-cascade">
				<h4 class="purple-text" data-field="procategory">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i>
				</h4>
				<!--Title-->
				<h6 class="card-title" data-field="proname">
					<i class="fa fa-cube" aria-hidden="true"></i>
				</h6>
				<h6 class="card-title" data-field="pronum">
					<i class="fa fa-tags" aria-hidden="true"></i>

				</h6>
				<h6 class="card-title" data-field="indate">
					<i class="fa fa-calendar" aria-hidden="true"></i>
				</h6>
				<h6 class="card-title" data-field="inpay">
					<i class="fa fa-krw" aria-hidden="true"></i>
				</h6>
				<h5 class="card-title" data-field="prodescname">
					<i class="fa fa-comments" aria-hidden="true"></i>
				</h5>
				<!--Text-->
				<div class="text-center">
					<p class="card-text" data-field="prodesc"></p>
				</div>
				<div class="text-right">
					<button class="btn btn-unique waves-effect waves-light">Delete</button>
					<button class="btn btn-unique waves-effect waves-light">Update</button>
				</div>
			</div>
			<!--/.Card content-->
		</div>
		<!-- card end -->
	</div>
	<!--Grid column-->
</div>
<!--Grid row-->
<script>
	var btns = document.querySelectorAll('button.btn');
	btns[0].addEventListener('click',function(){
		console.log('/only/resellList/'+document.querySelector('[data-field=pronum]').innerText);
		var conf = {
				url : '/only/resellList/'+document.querySelector('[data-field=pronum]').innerText,
				success : mov,
				method : 'DELETE'
		}
		var au = new AjaxUtil(conf);
		au.send();
		
	});

	function mov(res){
		if(res==1){
			alert('삭제 완료');
			location.href='/only/url/resellList:list';
			return;
		}
		alert('실패');
	}
////////////////////////////////
	btns[1].addEventListener('click',function(){
		var val = document.querySelector('[data-field=pronum]').innerText;
		location.href = '/only/url/resellList:update?pronum='+val;
	});

	
</script>