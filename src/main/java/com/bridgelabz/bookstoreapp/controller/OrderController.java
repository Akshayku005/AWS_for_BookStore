package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.Order;
import com.bridgelabz.bookstoreapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     *
     * @param orderdto
     * @return Ability to insert Order Details
     */

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertOrder(@Valid @RequestBody OrderDTO orderdto) {
        String newOrder = orderService.insertOrder(orderdto);
        ResponseDTO dto = new ResponseDTO("Order placed successfully !", newOrder);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    /**
     *
     * @param token
     * @return Ability getAll orders by using token
     */

    @GetMapping("/getAllOrders/{token}")
    public ResponseEntity<ResponseDTO> getAllOrderRecords(@PathVariable String token) {
        List<Order> newOrder = orderService.getAllOrderRecords(token);
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !", newOrder);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param token
     * @return Ability to get order by token
     */
    @GetMapping("/getById/{token}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable String token) {
        List<Order> newOrder = orderService.getOrderRecord(token);
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !", newOrder);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    /**
     *
     * @param token
     * @return Ability to cancel order by token and userId
     */
    @PutMapping("/cancelOrder/{token}/{userId}")
    public ResponseEntity<ResponseDTO> getCancelOrder(@PathVariable String token, @PathVariable int userId) {
        Order deletedOrder = orderService.cancelOrder(token, userId);
        ResponseDTO dto = new ResponseDTO("Cancel order successfully !", deletedOrder);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}