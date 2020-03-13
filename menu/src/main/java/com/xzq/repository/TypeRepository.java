package com.xzq.repository;

import com.xzq.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 22:02
 **/
@Repository
public interface TypeRepository {
    List<Type> findAll();
}
