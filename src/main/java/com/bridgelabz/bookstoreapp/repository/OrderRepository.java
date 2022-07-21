package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
