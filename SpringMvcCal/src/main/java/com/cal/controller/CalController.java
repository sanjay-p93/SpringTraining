package com.cal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cal.model.CalResult;
import com.cal.model.InputNum;
import com.cal.service.CalService;

@Controller
public class CalController {

	@Autowired
	CalService calService;

	@RequestMapping(value = "/Index", method = RequestMethod.GET)
	public String Index() {
		return "Index";
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("InputNum") InputNum inputNum, HttpServletRequest request,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("error");
		}

		CalResult r = new CalResult();
		if (request.getParameter("add") != null) {
			r.setMessage("The sum is : ");
			r.setValue(calService.add(inputNum));
			return new ModelAndView("result", "result", r);
		}

		if (request.getParameter("sub") != null) {
			r.setMessage("The diffrence is : ");
			r.setValue(calService.subtract(inputNum));
			return new ModelAndView("result", "result", r);
		}

		if (request.getParameter("mul") != null) {
			r.setMessage("The product is : ");
			r.setValue(calService.multiply(inputNum));
			return new ModelAndView("result", "result", r);
		}

		if (request.getParameter("div") != null && inputNum.getNum2() != 0) {
			r.setMessage("The quotient is : ");
			r.setValue(calService.divide(inputNum));
			return new ModelAndView("result", "result", r);
		}

		return new ModelAndView("error");
	}

}
