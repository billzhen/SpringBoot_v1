(this.webpackJsonpreciptprinter=this.webpackJsonpreciptprinter||[]).push([[0],{106:function(e,t,a){"use strict";a.r(t);var n=a(1),c=a.n(n),r=a(37),s=a.n(r),o=(a(58),a(7),a(6)),i=(a(59),a(10)),l=a.n(i),u=a(21),m=(a(61),a(26)),f=a.n(m),p=a(38),d=a.n(p),g=a(39),h=a.n(g),v=(a(62),a(63),a(127)),b=a(128),j=a(121),E=a(122),x=a(123),O=a(124),y=a(125),w=a(126),k={dark:j.a,light:E.a};function N(){var e=Object(n.useState)([]),t=Object(o.a)(e,2),a=t[0],r=t[1],s=Object(n.useState)(""),i=Object(o.a)(s,2),m=i[0],p=i[1],g=Object(n.useRef)(null),b=Object(n.useState)(0),j=Object(o.a)(b,2),E=j[0],x=j[1],O=function(e){var t=[];return a.map((function(e){t.push({role:"user",content:e.name}),e.contents[0]&&t.push({role:"assistant",content:e.contents[0].text})})),new Promise((function(e){v.a.post("/search/send",{frequency_penalty:0,max_tokens:2048,model:"text-davinci-003",presence_penalty:0,message:t,temperature:.5,top_p:1}).then((function(t){if(Array.isArray(t.data.choices)){console.log("\u8bf7\u6c42\u6210\u529f",t);var a=t.data.choices.map((function(e){return{index:e.index,text:e.message.content}}));e(a)}else alert("\u7a0b\u5e8f\u9519\u8bef")})).catch((function(e){console.log(e)}))}))},y=function(){g.current&&setTimeout((function(){g.current.scrollTop=g.current.scrollHeight}),0)},w=Object(n.useCallback)((function(){y()})),k=function(){var e=Object(u.a)(l.a.mark((function e(t){var n;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(""!==m.trim()){e.next=3;break}return alert("\u8bf7\u8f93\u5165\u95ee\u9898"),e.abrupt("return");case 3:p(""),n=a.length,a.push({id:Math.random(),name:m,contents:[]}),r(a),x(E+1),setTimeout(Object(u.a)(l.a.mark((function e(){var t;return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,O();case 2:t=e.sent,a[n].contents=t,r(a),p(""),x(0);case 7:case"end":return e.stop()}}),e)}))),0);case 9:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}();console.log("comments ==========",a);return Object(n.useEffect)((function(){y()})),console.log("Parent here."),c.a.createElement("div",{className:"app_container"},0===a.length?c.a.createElement("div",{style:{flex:1}},c.a.createElement("div",{className:"no-comment"},"\u6682\u65e0\u95ee\u9898\uff0c\u5feb\u53bb\u63d0\u95ee\u5427~"),c.a.createElement("img",{className:"chatGPTImg",src:f.a})):c.a.createElement("div",{ref:function(e){g.current=e},style:{flex:1},className:"list_container"},c.a.createElement("ul",{style:{color:"white"}},a.map((function(e,t){return c.a.createElement("li",{key:e.id,style:{color:"white"}},e.name?c.a.createElement("div",{className:"quiz"},c.a.createElement("img",{className:"quiz_avatar",src:d.a}),c.a.createElement("div",{className:"response",style:{marginLeft:8}},"\u63d0\u95ee\uff1a ",e.name)):null,e.contents.length?c.a.createElement("div",{className:"answer"},c.a.createElement("img",{className:"quiz_avatar",src:f.a}),c.a.createElement(_,{dataList:e.contents,index:t,updateScroll:w})):c.a.createElement("div",null,c.a.createElement("div",{style:{display:"flex",justifyContent:"center",backgroundColor:"black"}},c.a.createElement("img",{className:"heike",src:h.a})),c.a.createElement("div",{className:"answer2"},"\u601d\u8003\u4e2d...")))})))),c.a.createElement("div",{className:"input_style"},c.a.createElement("input",{className:"input_quertion",type:"text",placeholder:"\u8bf7\u8f93\u5165\u95ee\u9898",value:m,name:"userName",onChange:function(e){p(e.target.value)}}),c.a.createElement("div",{style:{width:"1vw"}}),c.a.createElement("button",{onClick:k,className:"confirm_button"},"\u53d1\u8d77\u63d0\u95ee")))}var _=c.a.memo((function(e){var t=e.dataList,a=e.index;e.updateScroll;console.log("\u7ec4\u4ef6\u5185\u90e8"+a+"\u66f4\u65b0");var r=Object(n.useState)(t),s=Object(o.a)(r,2),i=s[0],m=(s[1],Object(n.useState)(1)),f=Object(o.a)(m,2),p=(f[0],f[1],Object(n.useState)(!1)),d=Object(o.a)(p,2),g=d[0],h=d[1],v=(Object(n.useRef)([]),Object(n.useRef)(!0),Object(n.useRef)([]));Object(n.useRef)([]),Object(n.useRef)(null),Object(n.useRef)(null);Object(n.useEffect)((function(){(function(){var e=Object(u.a)(l.a.mark((function e(){return l.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:i.map((function(e){v.current.push(e.text)}));case 1:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()(),h(!0)}),[]);return console.log("here"),c.a.createElement("div",{style:{position:"relative",width:"100%"}},c.a.createElement("div",null,g&&v.current.length&&v.current.map((function(e,t){return c.a.createElement("div",{style:{marginLeft:8,marginBottom:10},key:t},"\u56de\u7b54\uff1a ",c.a.createElement("pre",{style:{width:"100%"}},c.a.createElement(S,{textContent:e,language:"javascript",darkMode:!0})))}))))})),S=function(e){var t=e.textContent,a=e.darkMode,r=e.language,s=void 0===r?"txt":r,i=Object(n.useState)(t),l=Object(o.a)(i,2),u=l[0];l[1];return"undefined"===typeof a&&(k.light=x.a),"boolean"===typeof a&&(k.light=E.a),Object(n.useEffect)((function(){b.a.registerLanguage("jsx",O.a),b.a.registerLanguage("javascript",y.a),b.a.registerLanguage("js",y.a)}),[]),c.a.createElement(w.a,{source:u,escapeHtml:!1,language:s},t)};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(c.a.createElement(c.a.StrictMode,null,c.a.createElement(N,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))},26:function(e,t,a){e.exports=a.p+"static/media/chatgpt.8b0cad56.png"},38:function(e,t,a){e.exports=a.p+"static/media/user.12f71825.png"},39:function(e,t,a){e.exports=a.p+"static/media/heike.729fd49e.gif"},53:function(e,t,a){e.exports=a(106)},58:function(e,t,a){},59:function(e,t,a){},61:function(e,t,a){},62:function(e,t,a){e.exports=a.p+"static/media/qiu.5b7b93a2.gif"},63:function(e,t,a){e.exports=a.p+"static/media/jushou.a8ebfd24.gif"}},[[53,1,2]]]);
//# sourceMappingURL=main.a6873e87.chunk.js.map