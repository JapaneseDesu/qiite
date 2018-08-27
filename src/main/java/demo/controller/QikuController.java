package demo.controller;

import demo.dto.QuestionDto;
import demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class QikuController {

    @Autowired
    private QuestionService questionService;

    @ModelAttribute
    public QikuForm setQikuForm(){
        return new QikuForm();
    }

    @RequestMapping(value = "/qiku/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("questionList", questionService.select());
        return "qiku";
    }

    @RequestMapping(value = "/qiku/regist", method = RequestMethod.POST)
    public String regist(@Valid @ModelAttribute QikuForm form, BindingResult result){

        if (result.hasErrors()){
            return "qiku";
        }

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion(form.getQuestion());
        questionService.regist(questionDto);
        return "redirect:index";
    }
}
