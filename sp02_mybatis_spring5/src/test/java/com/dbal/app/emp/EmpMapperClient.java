package com.dbal.app.emp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbal.app.emp.mapper.EmpMapper;
import com.dbal.app.model.EmpVO;

//@ExtendWith(SpringExtension.class)      //junit5
@RunWith(SpringJUnit4ClassRunner.class)   //junit4
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
    
    @Autowired 
    EmpMapper empMapper;
    
    @Test
    public void getEmp() {
        EmpVO vo = new EmpVO();
        vo.setEmployeeId("100");
        EmpVO findVO = empMapper.getEmp(vo);
        System.out.println(findVO.getFirstName());
    }
}

