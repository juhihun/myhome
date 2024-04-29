/*
*member.js
*/
//추가 클릭 이벤트 등록.
//사용자의 입력값 3개 => tr > td * 3 =>tbody 하위요소로 추가.

document.querySelector('#addMember').addEventListener('click',function(){
	
	let no = document.querySelector('#memberNo').value;
	let name = document.querySelector('#memberName').value;
	let point = document.querySelector('#memberPoint').value;
	/*let tbody = document.querySelector('.dd')*/
	const mem = {no,name,point}
	let tr = makeRow(mem);	
	document.querySelector('table#tlist tbody').appendChild(tr);
});

//member 정보를 활용 tr 반환.
function makeRow(mem = { no, name, point }) {
	//tr생성
	let tr = document.createElement('tr');
	tr.addEventListener('click', function() {
		document.querySelector('#memberNo').value
			= tr.children[0].innerText;
		document.querySelector('#memberName').value 
			= tr.children[1].innerText;
		document.querySelector('#memberPoint').value
			= tr.children[2].innerText;


	}),true



	for(let prop in mem){	
	let td = document.createElement('td');
	td.innerText = mem[prop]; //mem.memNo
	tr.appendChild(td);
	
	}
	
	
	//<td><button>삭제</button></td>
	let btn = document.createElement('button');
	let td = document.createElement('td');
	btn.innerText = '삭제';
	btn.addEventListener('click',deleteRow);
	td.appendChild(btn);
	tr.appendChild(td);

	//체크박스
	td = document.createElement('td');
	let chk = document.createElement('input');
	chk.setAttribute('type','checkbox');
	chk.addEventListener('change',changeRow);
	td.appendChild(chk);
	tr.appendChild(td);
	return tr;
	}//end of makeRow
	
	
	function deleteRow(event){
		event.stopPropagation(); //상하위요소로 이벤트 전달하지않음
		event.target.parentElement.parentElement.remove();
	}
	
	function changeRow(e){
		//this => <input type = "checkbox" checked>
		console.log(this.checked);//checkbox일경우
		document.querySelector('#memberNo').value = 
		document.querySelector('table#tlist tbody tr').children[2].innerText;
	}

	
	
	
//members 배열의 갯수만큼 tr 생성.
members.forEach(function(item){
	//tr생성
	let tr = makeRow(item);arguments
	//tr에 click 이벤트 등록
	document.querySelector('table#tlist tbody').appendChild(tr);
});


//thead input[type = "checkbox"]
document.querySelector('thead input[type="checkbox"]')
.addEventListener('change',function(){
	//event핸들러 => this
	//thead = > tbody 적용
	let inp = this;
	document.querySelectorAll('tbody input[type="checkbox"]')
	.forEach((item) => {
		console.log(this);
		item.checked = inp.checked;
	})
});


	
	
