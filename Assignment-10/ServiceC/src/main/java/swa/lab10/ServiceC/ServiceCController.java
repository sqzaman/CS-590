package swa.lab10.ServiceC;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceCController {

	@RequestMapping("/text")
	public String getText() throws Exception {
		Thread.sleep(5000);
		return "Service 3";
	}

}
