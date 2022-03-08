const checkAll = document.getElementById("checkAll");
const check = document.getElementsByClassName("check");
const btn = document.getElementById('btn');

checkAll.onclick = function (){
	for(v of check){
		if(checkAll.checked){
			v.checked=true;
		}
		else{
			v.checked=false;
		}
	}
}
for(c of check){
c.onclick = function(){
	let final = true;
	for(c of check){
		if(!c.checked){
			final = false;
		}
	}
	checkAll.checked = final;

	// if(check[0].checked && check[1].checked && check[2].checked && check[3].checked){
	// 	checkAll.checked=true;
	// }
	// else{
	// 	checkAll.checked=false;
	// }
}
}

btn.onclick = function(){
	if(checkAll.checked){
		location.href='./join';
	}
	else{
		alert("약관에 동의해주세요.");
	}
}
