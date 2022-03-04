const title = document.getElementById("title");
const contents = document.getElementById("contents");
const writer = document.getElementById("writer");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");

btn.onclick = function(){
    if(title.value.length>0&&contents.value.length>0&&writer.value.length>0){
        frm.submit();
    }
    else{
        alert("내용을 입력하세요.");
    }
}
