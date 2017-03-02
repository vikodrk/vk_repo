package mx.com.spring.demoTestApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@Value("${info}")
	String info;
	
	@RequestMapping("/info")
	public @ResponseBody String getInfoController()
	{
		return info;
	}
	
}
