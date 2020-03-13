package com.xzq.repository;

import com.xzq.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 15:06
 **/
@Repository
public interface AdminRepository {
    Admin login(String username, String password);
}
