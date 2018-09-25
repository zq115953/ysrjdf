package com.nectar.myblog.repository.mybatis;


import com.nectar.myblog.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Describe:
 */
@Repository
public interface UserRepository {

    /**
     *  通过手机号查找用户
     * @param phone 手机号
     * @return 用户
     */
    User findByPhone(String phone);

}
