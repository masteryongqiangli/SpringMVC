package system.core.controller;

import java.util.Date;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import system.core.interceptor.DateConvertEditor;

public class BaseController {
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
}
