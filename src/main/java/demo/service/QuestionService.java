package demo.service;

import demo.dto.QuestionDto;
import demo.entity.Question;
import demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<QuestionDto> select(){
        List<Question> list = questionRepository.findAll();
        List<QuestionDto> dtoList = new ArrayList<>();
        for (Question q: list) {
            QuestionDto dto = new QuestionDto();
            dto.setQuestion(q.getQuestion());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public void regist(QuestionDto questionDto){
        Question question = new Question();
        question.setQuestion(questionDto.getQuestion());
        questionRepository.save(question);
    }
}
