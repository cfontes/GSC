;if(window.jQuery)(function($){$.extend($,{fck:{waitFor:10,config:{Config:{}},path:'/fckeditor/',editors:[],loaded:false,intercepted:null,content:function(i,v){var x=FCKeditorAPI.GetInstance(i);if(!x){x=$('#'+i.replace(/\./gi,'\\\.')+'')[0];if(x)x=FCKeditorAPI.GetInstance(x.id)};if(!x){alert('FCKEditor instance "'+i+'" could not be found!');return''};if(v)x.SetHTML(v);return x.GetXHTML(true)},setHTML:function(i,v){if(typeof i=='object'){v=i.html;i=i.InstanceName||i.instance};return $.fck.content(i,v)},update:function(){LOG('DEBUGGGGGG fck.update 1');var e=$.fck.editors;for(var i=0;i<e.length;i++){var ta=e[i].textarea;var ht=$.fck.content(e[i].InstanceName);ta.val(ht).filter('textarea').text(ht);if(ht!=ta.val())alert('Critical error in FCK plugin:'+'\n'+'Unable to update form data')}},clean:function(){var a=$.fck.editors,b={},c=[];$.each(a,function(){if($('#'+this.InstanceName.replace(/\./gi,'\\\.')+'').length>0)b[this.InstanceName]=this});$.each(b,function(){c[c.length]=this});$.fck.editors=c},create:function(option){var o=$.extend({},$.fck.config||{},option||{});$.extend(o,{selector:(o.selector||'textarea.fck, textarea.fckeditor'),BasePath:(o.path||o.BasePath||$.fck.path)});var e=$(o.e);if(!e.length>0)e=$(o.selector);if(!e.length>0)return;o=$.extend({},o,($.meta?e.data():($.metadata?e.metadata():null))||{});if(!$.fck.loading&&!$.fck.loaded){$.fck.loading=true;$.getScript(o.BasePath+'fckeditor.js',function(){$.fck.loaded=true})};var start=function(){if($.fck.loaded){$.fck.editor(e,o)}else{if($.fck.waited<=0){alert('jQuery.fckeditor plugin error: The FCKEditor script did not load.')}else{$.fck.waitFor--;window.setTimeout(start,1000)}}};start(e);return e},intercept:function(){if($.fck.intercepted)return;$.fck.intercepted={ajaxSubmit:$.fn.ajaxSubmit||function(){}};$.fn.ajaxSubmit=function(){$.fck.update();return $.fck.intercepted.ajaxSubmit.apply(this,arguments)}},editor:function(e,o){o=$.extend({},$.fck.config||{},o||{});$.extend(o,{Width:(o.width||o.Width||'100%'),Height:(o.height||o.Height||'500px'),BasePath:(o.path||o.BasePath||$.fck.path),ToolbarSet:(o.toolbar||o.ToolbarSet||'Default'),Config:(o.config||o.Config||{})});e=$(e);if(e.size()>0){var a=$.fck.editors;e.each(function(i,t){if((t.tagName||'').toLowerCase()!='textarea')return alert(['An invalid parameter has been passed to the $.fckeditor.editor function','tagName:'+t.tagName,'name:'+t.name,'id:'+t.id].join('\n'));var T=$(t);if(!t.fck){t.id=t.id||'fck'+($.fck.editors.length+1);t.name=t.name||t.id;var n=a.length;a[n]=new FCKeditor(t.id);$.extend(a[n],o,o.Config||{});a[n].ReplaceTextarea();a[n].textarea=T;t.fck=a[n]}});$.fck.editors=a;$.fck.clean()};return e},start:function(o){$.fck.intercept();return $.fck.create(o)}}});$.extend($.fn,{fck:function(o){$.fck.start($.extend(o||{},{e:this}))}})})(jQuery);