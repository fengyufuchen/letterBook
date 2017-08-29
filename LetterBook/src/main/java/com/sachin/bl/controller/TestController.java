package com.sachin.bl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sachin.bl.pojo.AjaxObject;
import com.sachin.bl.utils.JsonUtils;

@Controller
public class TestController {

	@RequestMapping(value = "/test/node")
	@ResponseBody
	public void testMapping(Node p) {

		System.out.println(p.x);
		System.out.println(p.y.value);

	}

	@RequestMapping(value = "/test/ajax")

	@ResponseBody
	public AjaxObject testajax() {

		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setMessage("中国广东");
		return ajaxObject;

	}

	@RequestMapping(value = "/test/utfajax")

	@ResponseBody
	public Object testaUTFjax() {

		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setMessage("中国广东");

		return JsonUtils.objectToJson(ajaxObject);

	}

}
