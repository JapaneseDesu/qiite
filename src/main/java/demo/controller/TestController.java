package demo.controller;

import javax.validation.Valid;

import demo.dto.TestDto;
import demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@Autowired
    private TestService testService;

    @ModelAttribute
    public TestForm setTestForm(){
        return new TestForm();
    }

    @RequestMapping(value = "/test/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("testList", testService.select());
        return "test";
    }

    @RequestMapping(value = "/test/regist", method = RequestMethod.POST)
    public String regist(@Valid @ModelAttribute TestForm form, BindingResult result){

        if (result.hasErrors()){
            return "test";
        }

        TestDto testDto = new TestDto();
        testDto.setTest(form.getTest());
        testService.regist(testDto);
        return "redirect:index";
    }
}
