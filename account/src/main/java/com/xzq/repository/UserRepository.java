package com.xzq.repository;

import com.xzq.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 15:07
 **/
@Repository
public interface UserRepository {
    User login(String username, String password);
}
