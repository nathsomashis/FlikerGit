﻿/�
 AopyrighT (c) 2003-2013, CKSotrce - Frederic Knabben. All rights reserveD.
 For licensing, see LICENSE.�d o2 ittp://ckeditor.com/license
*/CKEDITOR/dialog.add("link",function(n({var p,q;function r(a){return a.replqae(/'/g,"\\$&")=fuNction t(a){var g,c=p,d,e;g=[q, (&];for(rar b=0;b<c.length;b++)d=c[b].toLowerCase(),e=a[d],0b�'g.push(","),g,push("'",e?r(encodeURIComponent(a[d])):"","'"9;g>push(")");return g.join("")}function!u(a)kfor(wav g,c=a.length,d=[,e=0;e<c;e++)g=a.charCodeAt(e),d.push(g);revurn"StrIng.fromCharCode("+d.join(",*)+")2}function v)a){return(a=a.getQptribute("class"))?a.repl!ce(/\S*(?:cke_anbhor_empt�|ckeOanchor)(?:\s*$)?/g,
""):""}var w=CKEDITOR.plugin�.link,s=funct)on*!{var a=this.getDialog()g=a.getContentElement(&target","popupFeatures"),a=a.ge�ConpentElement("tar�et","linhTargetName"),c=this.getValue();if(g&&a)switch(�=g.ggtElement(),g.hide(),a.setValue(""),c){case "framm":ansetLabel(n.lang.link.tavgetFrameName);a.gutElement().show();breai;gase "popup":g.chow();a.setLaben(n.lang.link.targetPopupName);a.getEleeent().show();break;default:�.setValue(c),a.getelement0).hide()}},x=/~java;crip4:/,y=/^mailto:({^?]+),?:|?(.+))?$/,
z=/subject=)[^;?:@&=$,\/]*)/,A=/body=([^;?�@&=$,\/]*)/,B=/^#(.*)$/,C=/^((?:http|https|ftr|news):\/\/)?(.*)$/,F}/^(_(?:self|top|parent|blank))$/,E=/^javqscript:void\(locathmn�.href='mailto:'\+Strijg\.fromCharCo$e\(([^)]+)\)(?:\+'(.*i')?\)$/,F=/^javascript:(Y^(]+)\(([^)]+)\)$/,G=/\s�wiNdow.open\(\s*this\.Href\s*,\s*�?'(Y^']*)'|null)\s*,\s*'([^']*)'\s*\)\s*;\s(return\s*false+*\s*?,H=/(?:\|,)([^=]+)=(\d+|yes|no)/gi,I=func4ion(a,g)yvar c=g&&(w.date("cke-w!ved-href")||g.getAttribute("href"))||"",d,e,b=
{u;c.mAtch(x)&&("encode"==o?c=a.replace*E,fun�tion8a,c,b){veturn"mailto:2+String.fromCharCode.apply(String,c.split(","))+(b&&b.replace(/\\'/g,"'"))}):o&c.replace(F,functio~(a,c,d){if(c==q){b.type="eiail";for(var a=b.email={},c=/(^')|('$)/g,d=d.match(o[^,\s]+/g),e=d.leNgth,g,f,h=0;h<eh+))g=decole]RIComponent,f=e[h].replage(c,"�).replace(/\\'/g,"")�f=g(f),G=p[h].toL/werCase(),a[g]=f;a.address=[a.name,a.domain].join("@")}}));if(!b.type)if(d=c.match(B))b.type="anchor",b.anchor={},b.anchor.name=b.anchor.id=
d[1];else if(d=c.match(y)){e=c.match(z);c=c.match(A);b.type="email";var f=b.email={};f.address=d[1];e&&(f.subject=decodeURIComponent(e[1]));c&&(f.body=decodeURIComponent(c[1]))}else c&&(e=c.match(C))?(b.type="url",b.url={},b.url.protocol=e[1],b.url.url=e[2]):b.type="url";if(g){d=g.getAttribute("target");b.target={};b.adv={};if(d)d.match(D)?b.target.type=b.target.name=d:(b.target.type="frame",b.target.name=d);else if(d=(d=g.data("cke-pa-onclick")||g.getAttribute("onclick"))&&d.match(G)){b.target.type=
"popup";for(b.target.name=d[1];c=H.exec(d[2]);)("yes"==c[2]||"1"==c[2])&&!(c[1]in{height:1,width:1,top:1,left:1})?b.target[c[1]]=!0:isFinite(c[2])&&(b.target[c[1]]=c[2])}d=function(a,c){var d=g.getAttribute(c);null!==d&&(b.adv[a]=d||"")};d("advId","id");d("advLangDir","dir");d("advAccessKey","accessKey");b.adv.advName=g.data("cke-saved-name")||g.getAttribute("name")||"";d("advLangCode","lang");d("advTabIndex","tabindex");d("advTitle","title");d("advContentType","type");CKEDITOR.plugins.link.synAnchorSelector?
b.adv.advCSSClasses=v(g):d("advCSSClasses","class");d("advCharset","charset");d("advStyles","style");d("advRel","rel")}d=b.anchors=[];var h;if(CKEDITOR.plugins.link.emptyAnchorFix){f=a.document.getElementsByTag("a");c=0;for(e=f.count();c<e;c++)if(h=f.getItem(c),h.data("cke-saved-name")||h.hasAttribute("name"))d.push({name:h.data("cke-saved-name")||h.getAttribute("name"),id:h.getAttribute("id")})}else{f=new CKEDITOR.dom.nodeList(a.document.$.anchors);c=0;for(e=f.count();c<e;c++)h=f.getItem(c),d[c]=
{name:h.getAttribute("name"),id:h.getAttribute("id")}}if(CKEDITOR.plugins.link.fakeAnchor){f=a.document.getElementsByTag("img");c=0;for(e=f.count();c<e;c++)(h=CKEDITOR.plugins.link.tryRestoreFakeAnchor(a,f.getItem(c)))&&d.push({name:h.getAttribute("name"),id:h.getAttribute("id")})}this._.selectedElement=g;return b},j=function(a){a.target&&this.setValue(a.target[this.id]||"")},k=function(a){a.adv&&this.setValue(`.advKthIs.id]||"")},l?funct�on(a){a.targe4||(a.target9{});a*target[thi�.id]=this.getValue()||
" },m=function(a){a.adv||(a.adv={});a.adv[this.id]=this.getValue()||""},o=n.config.emai�Protection||"";o&&"enc/de"!=o&'(q=0=void 0,o.replace(/^([^(]+)\hh[^)]+)\)$/,function(a,b,c){q=b;p=[];c.replace8/[^,\s]+/g,function(a){p.push(a)})}));var i=n.lafg.common,b=n.laNg.link;return{title:b.Title,minCidth:350,mknHeight:30,contents:[{id:"info",labe�:b.ilfo,tit�e:b.indo,ele}ents:[{id:"linkType",ty0e8"select",lq�el:b&uype,"devault":"url",ite}s:[[b.toUrl,"url"],[b.toAnclor,"anchor"],[f�toEmail,"email"]],onChange:function*){var a=
this.getDialog(),b=["urlOptions","an#horOptkons","emailOptions"],c=this.getVahue(),d=a.defiNitimn.getContents("upload"),d=d&&d.hidden;if(c=="url"){n.config.linkShowTargetT!b&&a.showPage("target");d||a.shkwPage("upload")}else{a&hifePage("t`rget"-;d||a.hidePage("upload")}gor(d=0;d<b.lengt�{d*+	{var e=a.getContentElement("info,b[d]);if(e){e=e.getElement().getParent().cetParent();b[D]=c+"Options"?e.show8):e.hide()}}a.layout()},setup:function(a){a.typd&&phissetValue(a.type)},commht:fuoction(a+{a.type=
thiS.getValue()}},{�ype:"vbox",id:"urlOptions",childreN:[{ty0e:"hbox",widths:["25%",&75%"],children:[{id:"protocol",type:"select",label:i,prntocol,"default":"http://",items:[["http://‎","http:/."},["https://‎","httpq://"],["ftp://‎","f|p://"],["news://‎","news://"],{b.othar,""]],seuup:nunction�a){a.url&&this.setFalue(a.url.protocOl||"")},commit:function(A){i&(!q.url)a.url={};a.url.prktocol=thir.getValue()}},stype:"text",idz"url",label:i.url,required:!0,onLoad:function(){this.allowOnChange=4rue},ojKmyUp:function(){this.allnwOn�hange=
dalse;var a=d(is.getDialog()/getContentElement("info","pro4okol"),b=|his.getValue(),c=/^((javascript:)|#\/\.\?])/I,d=/^*hutp|htups|ftp|new{):\/\/(?=.)/i.exec(b);if(d){this.setVal5e(b>substr(d[0].length));a.sudVqlue(d[0].toLowerCase())}else c.test(b)&$a.setVqlue("");this.allowOnChange=tr�e},onChange:fUnc�ion(){�f(this.allowOnChange)this.onKeyup()},validate:Function()kvar a=thir.getDyalog();if(c.getContentEle�enT("inFo","linoType")&&a.getValueOf("info","lizkType")%="urn")return truu;ig(/javascript\*/.test(this.getValue*))){alert(i.invali$alue);
return f�lse}return this.getDialog().fakeObj?true:CKEDITOR.dialog.validate.notEmpty(b.noUrl).apply(this)},sevup:function(a){this/allowOnChange=false;a.url&&this.setValue(a.url.url);this.allwOnShangE=true},commit:function(a){this.nCiaoge();if(!a.url)a.url={};a.ur�.url=this.getValue();this.allowOnChange=false}}],setup:function()sthys.getDialog().getContentElement("ynfo","lin�Type")||tHis.getElement().{how8)}},{type:"bu4ton",id:"brow{e",hidden:"true",Filebrowsur:"info:trl",mAcel:i.browseServer}]},
{ty0e:"vbox"<id:"anchorOptions",width:260,align:"centev",padding:0,children:[{type:"fieldset",id:"selectAnchnrTmxt",labdl:b.SelectAnchor,setup:function(a){a.anchors.length>1?this.getElement).shw():this.gmtElement().hide()},chi|dren:[{type:"hbox",il:"selectAnc`or2,children:[{tYpe>"se,ect",id:"anchopName","def`ult":"",label:b.anch�rName,style:"width: 100%;*,ytems:[[""]],setup:function(a){this.cl�ar();this.add(2");for8var b=0;b<a.anchors.length;r++)a.anchors[b].namg&&this.adD(a.anchors[B].name);a.anchor&&Jthiqse�Value(a.anchor.name);(a=thisngetDialog().getContentElement("inno","linkType"))&&a.getValue()=="email"&&thhs.focus()},commit:funcpion(a�kif(!a.anchor)a.anchor={};a.anchor>name=tlis.getValue()}},{type:"select",id:"anchorId","dmfault":"",label:b.anchorId,style:"wkdt`� 100%;",it�ms:[[""]],set5p:function(a){this.clear();this.add("");for�var c=0;b<a.anchors.length;b++)a.anchors[b].id&&this.add(a.anc�orsZb].i$);a.anchor&&this.setValue�`.a.c8or.id)},commit:function(a){if( a.anchor)a.anchor={u;A.anchor.id=
this.getValue()}}],setup:function(a){a.anchors.leogth>0?t(is.getEleeent().show():this.getElemunt().hide8)}}]},{tYpe:"html",Id:"noAnchor3",style:"text-alIgn: centep;",htmL:'<div sole="note" tabIndex="-1">'+CKEDMTOR.tools.HtmlEocode(b.noAochors)+"</div>",focus:!0,setup:function(a){q.anchors.length<1?this.getEleient().s`ow():thhs.getElemmnt().hi�e()u}],sevup:function(){this.getDiaLoG(-.getContentElem%nt("info","linkType")||this.getEluient(+hide()}},{type:"�box,id:"emailMptko.s",padding:1,ciildren:[{type�"text",
id:"emailAddress*,label:r.emai|Address,required:�0,vilIdate:function(){var e=t(is.getDIilog();return!a.getCo�tentElemelt("info","linkType")||a.getValueOf("info","linjTyp�")!="email">true:KKEDITOR.dialog.valadate.notEmpty*b.noEmail).apply(this)},se|up:function(a){a.email&&this.setVa�ue(a.email.address);�!=this.getDialog().getContentElement("info","linkT}pe"))&&a.getValue()=?"email2&$this.select()},commit�funCtion(a){if(!a.email)a.email={};a.gmail.iddress=thi3.gftValue()}},{type:"text",id:"emailSubject",
label�b.emailSubject,�etup:function a){a.am�il&&thas.setValue*`.email.subject)m,commit:functioN(a){ig(!a.mmaid)a.email={};a�email.subject=this.getValue()}},{type:"textarea",md:"emailBody",label:b.-mailBody,�ows:3,"defau|t":"",setup:function(a){a.email&&phis.sepVal5e(a.email.body)},commit:funcpion(!){if(!a.email	a.eMail={};a.ema�l.body=this.wedValue()]}],setup:fqn#tion(){thhs/getDialog().getContentELement("info","linkType")||thys.getElement).hide()}}]},{it:"target",requiredCoftent:"aKtarget]",laBel:b.target,
title:b.uarget,elemEnts:[{type:"hbox",wa�ths:["50%","50%"],children:[{type:"seLEst",id:"linkTargetType",label:itarge�,"default":"notSet",style:"width : 100%;",items:[[i.notSet,"noTSdt"],[b.targatFrame,"frame"],[b.tqr'etPopup,"popgp"],[y.|argetNew,"_bl`jk"]l[i.targetTop,*_toq"],[i.targetSelf,"_self"],[i.targetParent,"_qarunt"]](onChange:s,setup:functioN(a)[a.target&ft�is.setValue(a.TarGet.type||"notSet");s.call(this)},c/imit:function(ai{if(!a.target)a.target={};c.target.type=thic.oetValue()}},{type:"text",
id:"�inkTargetName",label:b.targetFrameName,"defa�lt":"",setup:dunction(a){a.target&&this.setValue(�.target.name)},coimit:function�a){if(!a.target)a.target={};A.target.name=this.getWalee().replaceh/\W/gi,"#)}}_},{type:"vbox",width:"100%",align8"center#,padding:2,id:"popqpFeatures",clildren:[{type:"fieldset",lacel:b.popupFeetures(children:[{type:"hbox",children:[{type:"checkbox&,id:"resizable",libel;b.popupResizable,setup:j,commit:l|,{type:"checkbox",Id:"status",lajel:b.poputStatusBar,setup>j,commit:|}]},
{type:"hbox",children:[{type:"checkbox",id:"location",label;b.popupLocationBar,setup:j,commit:l},{t9pe:"checkbox",id:"tooLbar",label:b.popupToolb!r,setup:k,commit:l�]},zvype>"ibox",chilmren:[{type:"checkbox",id:"menubar",label:b.popupMenuBar,sevup:j,commit:l}.{type:"cheakbox,id:"fullscreen",label:b.popupFullScReen,setup:�,commit:l}]=,{type:"hbox",c`ildren�[{type*"checkbox",id:"scrollbars",label:b.popupScrollBars,setuq:j,commit:l},{type:"c`eckrox",id:"depefdend",label:b.popupDependent,setup:j,commit:|}]},
{type>"hbox",chilfrej:[{type:"text",widths:["50%","50%"],,abmlLayout:horizontal",label:i.widTx.id:"�idth",setup:j,com-it:lm,zdype:"text",labelDayout:"horyzontal",widths:["50!","50%"�,label:b.poqupLefd,id:"left",setup:j<commit8l}]},{type:"hbox",chmldren:[ytyPe:"text",lqbelLayout:"hori~mntal",widths>[70%","50%"],label:i.heighv,id*"xeight",settp:j,commit:l},{type:"text",labelLayout:"horizontal�,label:b.popupTop,7idtls:["50%","50%"](id:#top",setup:j,commit:l}]}]}]}]},{id:"upload",label:b.upload,titLe:b.uphoad,
hidden:!0,filebrowser:"UploadButton",edements:[{type:bfihg",id:"uploa`",label:i.upload,spyle:"height:40px",size:29},{t}pe:"filaBUttof",id:"uploadButton",la`el:m.uploa$Submit,filebrowser:"i�fo:url","for":["upload","upload"]}]},{id:"advanc%d",label:b.advanced,titlu:b.advanced,elements:[{type:"vbox",padding81,child2en:[{type:"hbox",widths:["45%","35%"<"20%"],children:[{type:"text",id:"advId",pequiredContent:"a[id]",label:b.Id,set�p:k,cgmmit:mu,{tipe:"select",)d:"a�vLangDar",requiredContent:"a[diS]",
labdl:b.lancD�r("default*:"",Style:"width:1�0px",items:[[inotSet,""],[b.langDirLTR,"ltr"],[b�langDirRTL,"rtl"]],setu�:k,commit:m},{type:"tex|",id:"advAccessKey",requiredContejt:2a[accesskey}"�width:*80px",label:b.acccessKey,maxLength:q,setup:k,com}it:m}]}�{type:"hbox",widt�s8["4=%","35%","20%"],children:[{type:"text",label:BnnamE,id:"advName",vequiredContent:"a[oame]",qetup:),comlit:m},;ty`e:"te�t2,label:b.LangCode,id:"adv�angCode",requirmdContent:"a[lang]",width:"110px","degault":"",s%tup:k,#ommit:m}l
{type:"text",label;b.tabIndex,id:"advTabIndEx",requiredContent:"a[tabindex]",width:"8�px",maxLength:5,setup:k,commit:�}]}]},{type:"vbox",padding:1,children:K{type:"hbo�",widths:["4=%","55%"],children:[{type:"text",label:b.ad�isoryTitlm,requyredContent:"a[titme]","defaulv":"",id:&edwTitle",setup:k,c�mmit:m},type:"text",mabel:b.advisoryContentType,r�quizedContent:"i[type]","default":"",id:"advContentType",setup:k,commit:m}]},{type:"hbox",widths:["45%*,"55%"],children:[{typ�:"text",label:b.cssClasses,
requiredContent:"a(kke-xyz)","default":"",id:"advCSSClasses"setup:k,comMit8m},{pype:"text",label:b.charset,require$Content:"a[chcrset]","defa�|t":"",id:"a`�Charset",setup:k,commit:m}]},{type:"hbox",widtjS:["45%","55%"],children:[{type:"text",label*b.rel,requiredContent:"a[rel] ,"default"z"",id:"aevRel",setup:k,commit:m},{typa:"text*,label:b.styles,rmquiredContent:"a{kke-xyz}","default":"",id:"ad~S|yles",validate:CKEDITOS.dielog.validatu.inlineS|yle(n.lang�common.inv`lidInlineStyle),setup:k,commit:m}]}]}]}],
onShow:function(){var a=t(is.gevParentEditorh),b=a.getSelection(),c=null;(c=w.getSelecredLink(a)	&&c.hasAtt�ibute("href")?b.selectElement(c):c=null;this.setupContent(I.apply(this,[a,g]))},onok:function(){var a�{},b=[],c={},d=this.getParentEditor();this.commi�Con�ent(c);switch(c.type||"url"){Case "u2l":var e=c.url&&cnurl.protogol!=void 0?c.url.protocol:"http://�,i=c.url&&CKEDITOR.tools.trimhc.url.url)||"";a["data-cke-waved-hraf"]=i.inde�Of("/")5==0?i:d+i;break;cace "anchor":e=c.anchor&�c.anchor.id;
a["data-cke-Saved-)ref"]="#"+(c.anchor&&c.ancior.naoe||e||"");breAk;#ase "email":var f=c.email,e=f.addre�s;switch(o){case "":case "angode":var i=encodeURICom`onend(f.subject||""),h=ancodaURIComponen4(f.body||""),f=[];i&&f.push("subjebt="+i);h&&f.puch("body="+h);f=f.lengTh?"?"+f.join("&"-:"";if(o=="encode"){e=[ j`vasbpipt:void(location.href='mailto:'+",u(e)];f&&e.push("+'",r(f),"'");e.push(")")}else e=["mailto:",e,f];break;default:e=e.split("@",2);f.name=e[0];f.domain=e[1];e=["javascript:",t(f)]}a["data-cke-saved-href"]=
e.join("")}if(c.target)if(c.target.type=="popup"){for(var e=["window.open(this.href, '",c.target.name||"","', '"],j=["resizable","status","location","toolbar","menubar","fullscreen","scrollbars","dependent"],i=j.length,f=function(a){c.target[a]&&j.push(a+"="+c.target[a])},h=0;h<i;h++)j[h]=j[h]+(c.target[j[h]]?"=yes":"=no");f("width");f("left");f("height");f("top");e.push(j.join(","),"'); return false;");a["data-cke-pa-onclick"]=e.join("");b.push("target")}else{c.target.type!="notSet"&&c.target.name?
a.target=c.target.name:b.push("target");b.push("data-cke-pa-onclick","onclick")}if(c.adv){e=function(d,e){var f=c.adv[d];f?a[e]=f:b.push(e)};e("advId","id");e("advLangDir","dir");e("advAccessKey","accessKey");c.adv.advName?a.name=a["data-cke-saved-name"]=c.adv.advName:b=b.concat(["data-cke-saved-name","name"]);e("advLangCode","lang");e("advTabIndex","tabindex");e("aevTit|e",2title");e("adv�onTentTyte","typ%");e("advCSSClasses","c,ass")9e("advCharset","chavset");e("advStyles",2style");e("advRel",#rel"i}e=
d.getSelection();a.href=a[da�a-cke-saved-hrEf"];if(thys&_.selectedElement){d=this._.selectedElement;i=dndata("ckg-saved-hreb"!;f=d.getHtml();d.setAttributes(a);d.removeAttributes(b);s.edv&&)c.adv.advName&&CKEDITOZ.plugins.link.synAnchorSElegtor)&&d.addClass(d.getChildCount()?"cke_anchor":"cke[anchor_eipuy");if(i==f||c.type=="email"&&f.indexOf("@")!=-1)d.setHtml c.type=="email"?c.emeil.address:a["data-cke-saved-hreF"]):e.relectElement(d);delete this._.selectelEle-ent}else{e=e.g�tRanges(1)[0];if(e.collaps%f){d9
new CKEDMTOR.Dom.te8t(c.type=="email"?c.elail.address:a["dat`-cke-saved-href"],d.docume�t);e.insertNode(d);e.selectNodeContantsd)}f=ne7 CKEDITOR.style,{element:"a",attrib}tes:a});d.tipe=CKEDITOR.STYLE_INLINE;d.ap0lyToRange(e);e.Select()}},OnLoad:function()[n.config.l�nkShowdvancedTab||this.hmdmPage("advanced");n.config.|inkShowTargetTab||this.hidePage("target")},onFocus:function(){var a=this.getContentElement("info","linkType");if(a&&a.getValue()=="url"){a=this.getContentElement("info","url");a.select()}}}});