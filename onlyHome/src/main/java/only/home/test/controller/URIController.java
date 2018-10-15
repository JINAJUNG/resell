package only.home.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URIController {
	
	@RequestMapping(value="/url/{path}",method=RequestMethod.GET)
	public String goPage(@PathVariable String path) {
		try {
			Integer.parseInt(path.substring(path.lastIndexOf(":")+1));
			path = path.substring(0, path.lastIndexOf(":"));
			path = path.replace(":","/");
		}catch (Exception e) {
			// TODO: handle exception
			path = path.replace(":","/");
		}
		return path;
		
	}
}
