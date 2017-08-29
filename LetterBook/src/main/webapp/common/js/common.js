loadXML = function(xmlString) {
	//跨浏览器，ie和火狐解析xml使用的解析器是不一样的。  
	var xmlStrDoc = null;
	if (window.DOMParser) {// Mozilla Explorer  
		parser = new DOMParser();
		xmlStrDoc = parser.parseFromString(xmlString, "text/xml");
	} else {// Internet Explorer  
		xmlStrDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlStrDoc.async = "false";
		xmlStrDoc.loadXML(xmlString);
	}
	return xmlStrDoc;
}
