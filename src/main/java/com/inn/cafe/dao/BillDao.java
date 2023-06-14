package com.inn.cafe.dao;

import com.inn.cafe.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillDao extends JpaRepository<Bill, Long> {
    List<Bill> getAllBills();

    List<Bill> getBillByUserName(@Param("username") String username);
}
