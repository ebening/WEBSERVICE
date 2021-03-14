package com.uadec.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uadec.core.util.Constantes;

@RestController
public class GenericController {

	@RequestMapping(value = "/")
	public String main(HttpServletRequest request) throws UnsupportedEncodingException {
		return "index";
	}

	@RequestMapping(value = "/me")
	public Object me(HttpServletRequest request) {
		return request.getSession().getAttribute(Constantes.SESSION_ATTRIBUTE_USUARIO);
	}

	@RequestMapping(value = "/alwaysSuccess")
	public Map<String, Object> alwaysSuccess(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}
}