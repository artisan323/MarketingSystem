package cn.artisan323.controller;

import cn.artisan323.domain.Emp;
import cn.artisan323.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emp")
public class EmpController {

    private Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empServiceImpl;

    @RequestMapping("/isemp")
    @ResponseBody
    public Boolean isEmp(){
        Boolean flag = empServiceImpl.isEmp();
        Emp emp = empServiceImpl.selectEmp();//这是emp
        logger.info("flag={}", flag);
        return true;
    }

}
