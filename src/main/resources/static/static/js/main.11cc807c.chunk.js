(this.webpackJsonpreciptprinter=this.webpackJsonpreciptprinter||[]).push([[0],[,,,,,,,,,,function(e,t,n){e.exports=n.p+"static/media/chatgpt.8b0cad56.png"},,,,function(e,t,n){e.exports=n.p+"static/media/user.12f71825.png"},function(e,t,n){e.exports=n.p+"static/media/heike.729fd49e.gif"},,function(e,t,n){e.exports=n(32)},,,,,function(e,t,n){},function(e,t,n){},,function(e,t,n){},function(e,t,n){e.exports=n.p+"static/media/qiu.5b7b93a2.gif"},function(e,t,n){e.exports=n.p+"static/media/jushou.a8ebfd24.gif"},,,,,function(e,t,n){"use strict";n.r(t);var a=n(1),r=n.n(a),c=n(13),u=n.n(c),i=(n(22),n(16),n(3)),o=(n(23),n(4)),s=n.n(o),l=n(6),m=(n(25),n(10)),f=n.n(m),p=n(14),d=n.n(p),h=n(15),v=n.n(h),b=(n(26),n(27),n(34));function g(){var e=Object(a.useState)([]),t=Object(i.a)(e,2),n=t[0],c=t[1],u=Object(a.useState)(""),o=Object(i.a)(u,2),m=o[0],p=o[1],h=Object(a.useRef)(null),g=Object(a.useState)(0),w=Object(i.a)(g,2),j=w[0],O=w[1],x=function(e){return new Promise((function(t){b.a.post("/search/send",{frequency_penalty:0,max_tokens:2048,model:"text-davinci-003",presence_penalty:0,message:e,temperature:.5,top_p:1}).then((function(e){Array.isArray(e.data.choices)?(console.log("\u8bf7\u6c42\u6210\u529f",e),t(e.data.choices)):alert("\u7a0b\u5e8f\u9519\u8bef")})).catch((function(e){console.log(e)}))}))},y=function(){h.current&&setTimeout((function(){h.current.scrollTop=h.current.scrollHeight}),0)},k=Object(a.useCallback)((function(){y()})),N=function(){var e=Object(l.a)(s.a.mark((function e(t){var a;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(""!==m.trim()){e.next=3;break}return alert("\u8bf7\u8f93\u5165\u95ee\u9898"),e.abrupt("return");case 3:p(""),a=n.length,n.push({id:Math.random(),name:m,contents:[]}),c(n),O(j+1),setTimeout(Object(l.a)(s.a.mark((function e(){var t;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,x(m);case 2:t=e.sent,n[a].contents=t,c(n),p(""),O(0);case 7:case"end":return e.stop()}}),e)}))),0);case 9:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}();console.log("comments ==========",n);return Object(a.useEffect)((function(){y()})),console.log("Parent here."),r.a.createElement("div",{className:"app_container"},0===n.length?r.a.createElement("div",null,r.a.createElement("div",{className:"no-comment"},"\u6682\u65e0\u95ee\u9898\uff0c\u5feb\u53bb\u63d0\u95ee\u5427~"),r.a.createElement("img",{className:"chatGPTImg",src:f.a})):r.a.createElement("div",{ref:function(e){h.current=e},className:"list_container"},r.a.createElement("ul",{style:{color:"white"}},n.map((function(e,t){return r.a.createElement("li",{key:e.id,style:{color:"white"}},e.name?r.a.createElement("div",{className:"quiz"},r.a.createElement("img",{className:"quiz_avatar",src:d.a}),r.a.createElement("span",{style:{marginLeft:8}},"\u63d0\u95ee\uff1a ",e.name)):null,e.contents.length?r.a.createElement("div",{className:"answer"},r.a.createElement("img",{className:"quiz_avatar",src:f.a}),r.a.createElement(E,{dataList:e.contents,index:t,updateScroll:k})):r.a.createElement("div",null,r.a.createElement("img",{className:"heike",src:v.a}),r.a.createElement("div",{className:"answer2"},"\u601d\u8003\u4e2d...")))})),r.a.createElement("li",{style:{color:"white",height:100}}))),r.a.createElement("div",{className:"input_style"},r.a.createElement("input",{className:"input_quertion",type:"text",placeholder:"\u8bf7\u8f93\u5165\u95ee\u9898",value:m,name:"userName",onChange:function(e){p(e.target.value)}}),r.a.createElement("div",{style:{width:"1%"}}),r.a.createElement("button",{onClick:N,className:"confirm_button"},"\u53d1\u8d77\u63d0\u95ee")))}var E=r.a.memo((function(e){var t=e.dataList,n=e.index,c=e.updateScroll;console.log("\u7ec4\u4ef6\u5185\u90e8"+n+"\u66f4\u65b0");var u=Object(a.useState)(t),o=Object(i.a)(u,2),m=o[0],f=(o[1],Object(a.useState)(1)),p=Object(i.a)(f,2),d=(p[0],p[1]),h=Object(a.useState)(!1),v=Object(i.a)(h,2),b=v[0],g=v[1],E=Object(a.useRef)([]),w=Object(a.useRef)(!0),j=Object(a.useRef)([]),O=Object(a.useRef)([]),x=Object(a.useRef)(null),y=Object(a.useRef)(null),k=function(e){return new Promise((function(t){var n=setInterval((function(){clearInterval(n),t()}),e)}))};Object(a.useEffect)((function(){(function(){var e=Object(l.a)(s.a.mark((function e(){return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:m.map((function(e){j.current.push(e.text)}));case 1:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()()}),[]),Object(a.useEffect)((function(){console.log("\u7ec4\u4ef6-useEffect"+n+"\u66f4\u65b0");var e=function(){var e=Object(l.a)(s.a.mark((function e(){return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:m.map((function(e){O.current.push(e.text.split(""))})),x.current=setTimeout(Object(l.a)(s.a.mark((function e(){var t,n;return s.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t=0;case 1:if(!(t<O.current.length)){e.next=17;break}E.current.push([]),n=0;case 4:if(!(n<=O.current[t].length)){e.next=14;break}if(void 0!==O.current[t][n]){e.next=7;break}return e.abrupt("continue",11);case 7:return e.next=9,k(100*Math.random());case 9:E.current[t]=E.current[t]+O.current[t][n],w.current&&c();case 11:n++,e.next=4;break;case 14:t++,e.next=1;break;case 17:setTimeout((function(){clearTimeout(x.current),clearInterval(y.current)}),1e3);case 18:case"end":return e.stop()}}),e)}))),0);case 2:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}();return m&&m.length&&(e(),y.current=setInterval((function(){d((function(e){return e+1}))}),100)),function(){clearTimeout(x.current),clearInterval(y.current)}}),[]);return console.log("here"),r.a.createElement("div",{style:{position:"relative",width:"100%"}},r.a.createElement("div",{style:{width:30}}," ",r.a.createElement("button",{onClick:function(){clearTimeout(x.current),clearInterval(y.current),w.current=!1,setTimeout(c(),0),g(!0)},className:"quickButton"},"\u52a0\u901f")),r.a.createElement("div",null,!b&&E.current.length&&E.current.map((function(e,t){return r.a.createElement("div",{style:{marginLeft:8,marginBottom:10},key:t},"\u56de\u7b54\uff1a ",r.a.createElement("pre",{style:{width:"100%"}},e))}))),r.a.createElement("div",null,b&&j.current.length&&j.current.map((function(e,t){return r.a.createElement("div",{style:{marginLeft:8,marginBottom:10},key:t},"\u56de\u7b54\uff1a ",r.a.createElement("pre",{style:{width:"100%"}},e))}))))}));Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));u.a.render(r.a.createElement(r.a.StrictMode,null,r.a.createElement(g,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}],[[17,1,2]]]);
//# sourceMappingURL=main.11cc807c.chunk.js.map