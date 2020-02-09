package com.zhifeng.girl.reposiltory;

import com.zhifeng.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhifeng
 * 2020/2/6 23:16
 */
public interface GirlReposiltory extends JpaRepository<Girl, Integer> {
    /**
     * 通过年龄查询
     */
    public List<Girl> findByAge(Integer age);
}
