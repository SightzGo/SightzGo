// 底部
var _index = 0;
var _qindex = 0;
$(".but span") .mouseover(function(){
    $(this).addClass("hover") .siblings("span").removeClass("hover");
    //左移
    if(_index>_qindex) {
    //获取序列号
    _index = $(this).index();
    $(".roll img").eq(_qindex).animate({"left": "-1536px"}, 300);
    $(".roll img").eq(_index).css("left","820px").animate({"left": "0px"}, 300);
}
//右移
else if(_index<_qindex){
    $(".roll img").eq(_qindex).animate({"left": "1536px"}, 300);
    $(".rollimg").eq(_index).css("left","-820px").animate({"left": "0px"}, 300);
}
_qindex = _index;
});

//左右
