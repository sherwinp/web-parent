package org.techlyric;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.Principal;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;
import org.techlyric.service.MemberService;

@Controller
@ControllerAdvice
public class RouteController {
	@Autowired
	ApplicationContextProvider myApplicationContext;
	
	@RequestMapping(value="/{Indx}", method={RequestMethod.GET})
	public ModelAndView index_4( @ModelAttribute PlaceDTO dto, BindingResult bindingResult) throws IOException, ServletException{
	    ModelAndView model = new ModelAndView("index");
	    	model.addObject("command", dto);
		return model;
	}
	@RequestMapping(value={"/index"},  method={RequestMethod.GET})
	public ModelAndView index_0(@ModelAttribute PlaceDTO dto){
		return new ModelAndView("index", "command", dto);
	}

	@RequestMapping(value="register", method={RequestMethod.GET})
	public ModelAndView register( @ModelAttribute RegisterDTO dto, BindingResult bindingResult){
		return new ModelAndView("register", "command", dto);
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView register_1(@ModelAttribute RegisterDTO dto, Model model, BindingResult bindingResult){
		
		if( bindingResult.getErrorCount() == 0 ){
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			MemberService svc = myApplicationContext.getApplicationContext().getBean(MemberService.class);
			svc.Register( dto );
		}
		
		return new ModelAndView("register", "command", dto);
	}
	@RequestMapping(value="resetpassword")
	public ModelAndView resetpassword(){
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
	public RedirectView logoff(HttpSession session, SessionStatus sessionStatus){
		sessionStatus.setComplete();
		session.invalidate();
		return new RedirectView("index", true);
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