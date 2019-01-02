/**
 * 
 */

var filterXSS=function(str){
    var results="";
    try{
        HTMLParser(he.unescape(str,{strict:true}), {
          start: function(tag, attrs, unary ) {
        	  debugger;
	        	if(tag=="script"||tag=="style"||tag=="link"||tag=="iframe"||tag=="frame"||tag=="flash"||tag=="form"||tag=="base"){
	        		return ;
	        	}  
	            results += "<" + tag;
	            for ( var i = 0,length=attrs.length; i <length; i++ ){
	            	if(xssoptions.attrfiler.contains(attrs[i].name)){
	            		continue;	
	            	}
	            	if(attrs[i].name=="style"){
	            		results += " " + attrs[i].name + '="' + xssoptions.stylefilter.filter(attrs[i].escaped) + '"';
	            	}else{
	            		results += " " + attrs[i].name + '="' + attrs[i].escaped + '"';
	            	}
	            }
	            results += unary?"/":"";
	            results += ">";
          },
          end: function( tag ) {
        	  results += "</" + tag + ">";
          },
          chars: function( text ) {
        	  results += text;
          },
          comment: function( text ) {
        	  results += "<!--" + text + "-->";
          }
        });    
    }catch(e){
        console.log(e);
    }finally{
    	return results;
    }
}

var xssoptions={
		attrfiler:{
			blacklist:["onerroe","onclick","onload","onchange","onblur","onabort","ondblclick","onfocus","onkeydown","onkeypress","onkeyup","onmousedown","onmousemove","onmouseout","onmouseover","onmouseup","onreset","onresize","onselect","onsubmit","onunload"],
			contains:function(attr){
				for(i in this.blacklist){
					if(this.blacklist[i]==attr)return true;
				}
			}
		},
		stylefilter:{
			blacklist:['background'],
			contains:function(attr){
				for(i in this.blacklist){
					if(attr.indexOf(this.blacklist[i])>-1){
						return {flag:true,index:i}
					}
				}
				return {flag:false,index:-1};
			},
			filter:function(attr){
				var tem=this.contains(attr);
				if(tem.flag){
					attr=attr.replace(this.blacklist[tem.index],'');
					attr=this.filter(attr);
				}
				return attr;
			},
		}
}