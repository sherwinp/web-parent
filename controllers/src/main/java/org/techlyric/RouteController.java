package org.techlyric;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/")
@Controller
public class RouteController {
	@RequestMapping(value="/index",  method={RequestMethod.GET})
	public ModelAndView index_0(HttpServletRequest request, HttpServletResponse response, ModelAndView model){
		return new ModelAndView("index");
	}
	@RequestMapping(value="/index/**",  method={RequestMethod.GET})
	public ModelAndView index_1(HttpServletRequest request, HttpServletResponse response, ModelAndView model){
		return new ModelAndView("index");
	}
	@RequestMapping(value="/index/{indx}", method={RequestMethod.GET})
	public ModelAndView index_3( HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("indx") String indx, ModelAndView model) throws IOException{
		return new ModelAndView("index");
	}
	@RequestMapping(value="register")
	public ModelAndView register(){
		return new ModelAndView("register");
	}
	@RequestMapping(value="resetpassword")
	public ModelAndView resetpassword(HttpServletResponse response){
		return new ModelAndView("resetpassword");
	}
	@RequestMapping(value="secured")
	public RedirectView secured(){
	
		return new RedirectView("index", true);
	}
	@RequestMapping(value="logon")
	public ModelAndView logon(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		return new ModelAndView("logon");
	}
	@RequestMapping(value="logoff")
	public String logoff(){
		return "index";
	}
	@RequestMapping("data")
	public void  data(HttpServletResponse response) {
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		try {
			response.getWriter().write("{\"Name\":50}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}