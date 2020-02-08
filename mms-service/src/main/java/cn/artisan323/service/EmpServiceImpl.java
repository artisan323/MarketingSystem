package cn.artisan323.service;

import cn.artisan323.dao.EmpDao;
import cn.artisan323.domain.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    private Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

    @Autowired
    private EmpDao empDao;

    @Override
    public Boolean isEmp() {
        return true;
    }

    @Override
    public Emp selectEmp() {
        int i = 0;
        Emp emp = empDao.selectById("1");
        logger.info(emp.toString());
        return emp;
    }
}
