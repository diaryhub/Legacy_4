const id = document.getElementById("id");
const idResult=document.getElementById("idResult");
const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const pw2 = document.getElementById("pw2");
const pw2Result = document.getElementById("pw2Result");
const name = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const btn = document.getElementById("btn");


pw.addEventListener('blur', function(){
    if(pw.value.length<8||pw.value.length>12){
        pwResult.innerHTML="사용할 수 없는 비밀번호 입니다.";
        
    }
    else{
        pwResult.innerHTML="사용 가능한 비밀번호 입니다.";
    }
})
let pwcheck=true;
pw2.addEventListener('blur', function(){
    pwcheck=true;
    if(pw.value!=pw2.value){
        pw2Result.innerHTML="비밀번호가 일치하지 않습니다.";
        
    }else{
        pwcheck=false;
        pw2Result.innerHTML="비밀번호 일치";
    }
})

pw.addEventListener("change", function(){
    pwcheck=true;
    pw2.value='';
    pw2Result.value='';
    pw2.focus();
})

id.addEventListener('blur', function(){
    if(id.value==''){
        idResult.innerHTML="ID를 입력하세요.";
    }
})


btn.onclick = function(){
    if(id.value==''){
        alert("ID를 입력해주세요.");
        id.focus();
        return;
    }
    if(pw.value==''||pw.value.length<8||pw.value.length>12){
        alert("pw가 정확하지 않습니다.");
        pw.focus();
        return;
    }
    if(pwcheck){
        alert("비밀번호가 일치하지 않습니다.");
        pw2.focus();
        return;
    }
    if(name.value==''){
        alert("이름을 입력해주세요.");
        name.focus();
        return;
    }
    if(email.value==''){
        alert("메일을 입력해주세요.");
        email.focus();
        return;
    }
    if(phone.value==''){
        alert("전화번호를 입력해주세요.");
        phone.focus();
        return;
    }
        frm.submit();
    
}
