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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.techlyric.dto.PlaceDTO;
import org.techlyric.dto.RegisterDTO;
import org.techlyric.service.Download;
import org.techlyric.service.RegisterUserService;
import org.techlyric.service.SchemaInfo;

@Controller
@ControllerAdvice
public class RouteController {
	@Autowired
	ApplicationContextProvider applicationContextProvider;

	@RequestMapping(value = { "/", "/home", "/home/{Indx}/{Tselector}" }, method = { RequestMethod.GET })
	public ModelAndView index_1(@ModelAttribute PlaceDTO dto) {
		return new ModelAndView("home", "command", dto);
	}

	@RequestMapping(value = "/j_security_check", method = RequestMethod.POST)
	public RedirectView security_check() {
		return new RedirectView("home", true);
	}

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public ModelAndView register(@ModelAttribute RegisterDTO dto, BindingResult bindingResult) {
		return new ModelAndView("register", "command", dto);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register_1(@ModelAttribute RegisterDTO dto, Model model, BindingResult bindingResult) {

		if (bindingResult.getErrorCount() == 0) {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			RegisterUserService svc = ApplicationContextProvider.getApplicationContext().getBean(RegisterUserService.class);
			svc.Register(dto);
		}

		return new ModelAndView("register", "command", dto);
	}

	@RequestMapping(value = "/resetpassword")
	public ModelAndView resetpassword() {
		return new ModelAndView("resetpassword");
	}

	@RequestMapping(value = "/logoff")
	public RedirectView logoff(HttpSession session, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		session.invalidate();
		return new RedirectView("home", true);
	}

	@RequestMapping(value = "download/{type}", method = RequestMethod.GET)
	public void download(HttpServletResponse response, HttpServletRequest request, @PathVariable("type") String type)
			throws Exception {
		Download download = new Download();
		request.getSession().setAttribute("download_progress", download);
		download.FileContent(response);

		download.SetDone();
	}

	@RequestMapping(value = "download/{type}", method = RequestMethod.HEAD)
	public void download_progress(HttpServletResponse response, HttpServletRequest request,
			@PathVariable("type") String type) throws Exception {
		Download download = (Download) request.getSession().getAttribute("download_progress");

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setIntHeader("download_progress", download != null ? download.GetDone() : -1);

	}

	@RequestMapping(value="/api", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void data(HttpServletResponse response) {
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			response.getWriter().write(String.format("{\"_links\": { \"self\": { \"href\": \"%s/api/\"  }  }, \"id\":\"api\", \"name\": \"api\" }", "http://zed:7001"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}