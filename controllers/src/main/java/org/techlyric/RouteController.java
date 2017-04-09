package org.techlyric;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.techlyric.dto.PlaceDTO;
import org.techlyric.dto.RegisterDTO;
import org.techlyric.service.MemberService;

@Controller
@ControllerAdvice
public class RouteController {
	@Autowired
	ApplicationContextProvider applicationContextProvider;
	@RequestMapping(value="/")
	public RedirectView context_empty_url(){
		return new RedirectView("index", true);
	}		
	@RequestMapping(value="/{Indx}/{Tselector}",  method={RequestMethod.GET})
	public ModelAndView index_0(@ModelAttribute PlaceDTO dto){
		return new ModelAndView("index", "command", dto);
	}
	@RequestMapping(value={"/index"},  method={RequestMethod.GET})
	public ModelAndView index_1(@ModelAttribute PlaceDTO dto){
		return new ModelAndView("index", "command", dto);
	}
	@RequestMapping(value="/j_security_check", method=RequestMethod.POST)
	public RedirectView security_check(){
		return new RedirectView("index", true);
	}
	
	@RequestMapping(value="/register", method={RequestMethod.GET})
	public ModelAndView register( @ModelAttribute RegisterDTO dto, BindingResult bindingResult){
		return new ModelAndView("register", "command", dto);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register_1(@ModelAttribute RegisterDTO dto, Model model, BindingResult bindingResult){
		
		if( bindingResult.getErrorCount() == 0 ){
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			MemberService svc = ApplicationContextProvider.getApplicationContext().getBean(MemberService.class);
			svc.Register( dto );
		}
		
		return new ModelAndView("register", "command", dto);
	}
	@RequestMapping(value="/resetpassword")
	public ModelAndView resetpassword(){
		return new ModelAndView("resetpassword");
	}

	@RequestMapping(value="/logon")
	public ModelAndView logon(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		return new ModelAndView("logon");
	}
	@RequestMapping(value="/logoff")
	public RedirectView logoff(HttpSession session, SessionStatus sessionStatus){
		sessionStatus.setComplete();
		session.invalidate();
		return new RedirectView("index", true);
	}
	@RequestMapping("/data")
	public void  data(HttpServletResponse response) {
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		try {
			response.getWriter().write("{\"Name\":50}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}