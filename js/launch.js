/**
 * Created by Leo on 2017/8/2.
 *
 */

//
//function three(){
//    $("#div2").show();
//    //$("#div1").hide();
//    //$("#div1").style.display="none";
//}
//function one(){
//    $("#div3").show();//$("#div2").hide();
//}
//function two(){
//   // $("#div4").show(); $("#div3").hide();
//    $("#div4").style.display="block";
//}
//window.onload = function(){
//    $("#z").click(three());
//    $("#x").click(one());
//    $("#v").click(two());
//}


window.onload = function(){
    //var z=$("#z");
    //var x=$("#x");
    //var v=$('#v');
    z.onclick = function(){ $("#div2").show();}
    x.onclick = function(){ $("#div3").show();}
    v.onclick = function(){ $("#div4").show();}
    //$("#x").click($("#div3").show());
    //$("#v").click($("#div4").show());
}