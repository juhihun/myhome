/*
* date.js
*/
const members = [
	{no : 1001, name: '홍길동', point:90},
	{no : 1002, name: '김길동', point:100},
	{no : 1003, name: '박길동', point:95},
];

//배열 for.
//for(let mem of members){}
members.forEach(function(item,idex,ary){
	if(item.point >= 95)
	console.log(item,idex,ary)
})