package mx.com.spring.eureka.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@Value("${info}")
	String info;

	@RequestMapping(value = "/info", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String getInfoController() {
		return info;
	}
}
