package com.sachin.bl.pojo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;

public class SachinResult {

	/**
	 * This mapper (or, data binder, or codec) provides functionality for
	 * converting between Java objects (instances of JDK provided core classes,
	 * beans), and matching JSON constructs. It will use instances of JsonParser
	 * and JsonGenerator for implementing actual reading/writing of JSON.
	 * 
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private int status;// 状态
	private String msg;// 消息
	private Object data;// data

	public SachinResult() {
		super();

	}

	public SachinResult(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public SachinResult(Object data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.status = 200;
		this.msg = "OK";
	}

	public static SachinResult ok() {

		return new SachinResult(null);
	}

	public static SachinResult ok(Object data) {

		return new SachinResult(data);
	}

	public static SachinResult build(int status, String msg) {
		return new SachinResult(status, msg, null);
	}

	private static SachinResult build(int asInt, String asText, Object obj) {
		// TODO Auto-generated method stub
		return new SachinResult(asInt, asText, obj);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static SachinResult formatToPojo(String jsonData, Class<?> clazz) {

		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, SachinResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {

					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}

			return build(jsonNode.get("status").asInt(), jsonNode.get("msg").asText(), obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static SachinResult format(String json) {

		try {
			return MAPPER.readValue(json, SachinResult.class);
		} catch (Exception e) {

		}
		return null;
	}

}
