package com.xzq.controller;

import com.xzq.entity.Order;
import com.xzq.entity.OrderVO;
import com.xzq.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 16:33
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        int count = orderRepository.countByUid(uid);
        List<Order> orders = orderRepository.findAllByUid(uid, (page - 1) * limit, limit);
        return new OrderVO(0, "", count, orders);
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid) {
        orderRepository.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid) {
        orderRepository.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        int count = orderRepository.countByState(state);
        List<Order> orders = orderRepository.findAllByState(0, (page - 1) * limit, limit);
        return new OrderVO(0, "", count, orders);
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid) {
        orderRepository.updateState(id, aid, state);
    }

}
