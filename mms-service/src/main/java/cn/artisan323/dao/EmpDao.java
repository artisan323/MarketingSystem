package cn.artisan323.dao;

import cn.artisan323.domain.Emp;

public interface EmpDao {
    Emp selectById(String id);
}
