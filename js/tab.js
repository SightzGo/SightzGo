/**Created by czj 17/8/1 17：48
用于赛事GO赛事管控功能中
报名系统等标题与其对应页面的转换*/
function $(id){
    return typeof  id=="string"?document.getElementById(id):id;
}

window.onload = function(){
    var titleName = $("table-title").getElementsByTagName("li");
    var tabContent = $("content").getElementsByTagName("div");
    if(titleName.length != tabContent.length){
        return;
    }
    for(var i = 0;i<titleName.length;i++){
        titleName[i].id = i;
        titleName[i].onmouseover = function(){
            for(var j = 0;j<titleName.length;j++){
                titleName[j].className = "";
                tabContent[j].style.display = "none"
            }
            this.className = "select";
            tabContent[this.id].style.display = "block";
        }
    }
}