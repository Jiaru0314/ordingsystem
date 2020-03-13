package com.xzq.repository;

import com.xzq.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 12:01
 **/
@Repository
public interface UserRepository {
    List<User> findAll(int index, int limit);

    int count();

    void save(User user);

    User findById(long id);

    void deleteById(long id);

    void update(User user);

}
