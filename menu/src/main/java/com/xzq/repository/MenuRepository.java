package com.xzq.repository;

import com.xzq.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 19:12
 **/
@Repository
public interface MenuRepository {

    List<Menu> findAll(int index, int limit);

    int count();

    Menu findById(long id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(long id);

}
