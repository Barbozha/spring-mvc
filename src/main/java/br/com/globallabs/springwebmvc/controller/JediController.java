package br.com.globallabs.springwebmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;

@Controller
public class JediController {
	
	@Autowired
	private JediRepository jediRepository;
	
	@GetMapping("/jedi")
	public ModelAndView jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jedi");
		
		modelAndView.addObject("allJedi", jediRepository.getAllJedi());
		return modelAndView;
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi", new Jedi());
		return modelAndView;
	}
	
	@PostMapping("/jedi")
	public String createJedi(@Valid Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {
		
		 if (result.hasErrors()) {
	            return "new jedi";
	        }
		jediRepository.add(jedi);
		redirectAttributes.addFlashAttribute("message", "Jedi cadastro com sucesso.");
		return "redirect:jedi";
	}
	
}
