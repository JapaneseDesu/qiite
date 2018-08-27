package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dto.TestDto;
import demo.entity.Test;
import demo.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
    TestRepository testRepository;

    public List<TestDto> select(){
        List<Test> list = testRepository.findAll();
        List<TestDto> dtoList = new ArrayList<>();
        for (Test t: list) {
            TestDto dto = new TestDto();
            dto.setTest(t.getTest());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public void regist(TestDto testDto){
        Test test = new Test();
        test.setTest(testDto.getTest());
        testRepository.save(test);
    }
}
