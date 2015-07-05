package hopebing.hopelog.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author hopebing
 *
 */
@Controller
public class HelloController {

	private static Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping(value = "/xtgl/test.do", method = RequestMethod.GET)
	public String hello(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String s = request.getParameter("test");

		model.addAttribute("test", "����");
		logger.info("����Ϊ:" + s);
		return "xtgl/test";
	}
}
