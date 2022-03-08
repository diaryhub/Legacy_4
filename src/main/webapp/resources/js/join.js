//전역변수
//var
const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");
const id = document.getElementById("id");
const idResult = document.getElementById("idResult");
const pw2 = document.getElementById("pw2");
const pw2Result = document.getElementById("pw2Result");
const frm = document.getElementById("frm");
const btn = document.getElementById("btn");
const name1 = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");

let idcheck=false;
let pw1check=false;
let pw2check=false;
let namecheck=false;
let emailcheck=false;
let phonecheck=false;

pw.addEventListener("change",function(){
    pw2check=false;
    pw2Result.innerHTML="패스워드가 일치하지 않습니다.";
    pw2.value='';
    pw2.focus();
})

btn.onclick = function(){
    if(idcheck&&pw1check&&pw2check&&namecheck&&emailcheck&&phonecheck){
        frm.submit();
    }
    else{
        alert("다시 확인해 주세요.");
        console.log(idcheck);
        console.log(pw1check);
        console.log(pw2check);
        console.log(namecheck);
        console.log(emailcheck);
        console.log(phonecheck);
    }
}

pw.addEventListener("keyup", function(){
    if(pw.value.length<8||pw.value.length>12){
        pwResult.innerHTML="적절하지 않은 비밀번호 입니다.";
        pwcheck=false;
    }
    else{
        pwResult.innerHTML="사용할 수 있는 비밀번호 입니다.";
        pw1check=true;
    }
})


id.onblur = function(){
    if(id.value.length<1){
        idResult.innerHTML="ID는 필수입니다.";
        idcheck=false;
    }
    else{
        idResult.innerHTML="";
        idcheck=true;
    }
}

pw2.onblur = function(){
    pwcheck=false;
    if(pw.value==pw2.value){
        pw2Result.innerHTML="패스워드가 일치합니다.";
        pw2check=true;
    }
    else{
        pw2Result.innerHTML="패스워드가 일치하지 않습니다.";
        pw2check=false;
    }
}

name1.onblur = function(){
    if(name1.value.length<1){
        namecheck=false;
    }
    else{
        namecheck=true;
    }
}
email.onblur = function(){
    if(email.value.length<1){
        emailcheck=false;
    }
    else{
        emailcheck=true;
    }
}
phone.onblur = function(){
    if(phone.value.length<1){
        phonecheck=false;
    }
    else{
        phonecheck=true;
    }
}