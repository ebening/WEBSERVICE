package com.uadec.core.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public abstract class BaseController<S,T>{
	
	protected static Logger log = Logger.getLogger(BaseController.class);
	private S service;
	
	@Autowired
	private void init(S  service){
		this.service  = service;
	}

	public S getService() {
		return service;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleUncaughtException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		long ticketId = System.currentTimeMillis();
		
		map.put("errorCode", String.valueOf(ticketId));
		map.put("errorClass", ex.getClass().getName());
		map.put("errorMessage", ex.getMessage());
		
		log.error("Error errorCode: " + ticketId,ex);
		ex.printStackTrace();
		return map;
	}
}