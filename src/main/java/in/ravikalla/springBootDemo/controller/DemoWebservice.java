package in.ravikalla.springBootDemo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// URL
// http://localhost:8080/demoWebservice/name

@RestController
@RequestMapping("/demoWebservice")
public class DemoWebservice {

	private static final Logger L = LogManager.getLogger(DemoWebservice.class);

	@RequestMapping(value="/name", method=RequestMethod.GET)
	public String getName() {
		L.info("Start : DemoWebservice.getName()");
		return "Ravi Demo";
	}

	@RequestMapping(value="/name", method=RequestMethod.DELETE)
	public String deleteName() {
		L.info("Start : DemoWebservice.getName()");
		return "Ravi Demo";
	}
}
