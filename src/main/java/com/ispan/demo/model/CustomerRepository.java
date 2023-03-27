package com.ispan.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value = "from Customer where name = ?1")
	List<Customer> findCustomerByName(String name);
	
	@Query(value = "from Customer where name = :name")
	List<Customer> findCustomerByName2(@Param("name") String name);
	
	@Query(value="select * from customer where name = :name", nativeQuery = true)
	List<Customer> findCustomerByName3(@Param("name") String name);
	
	// 請用 hql 或 原生SQL 找出某 level 的 customer 資料
	@Query(value="from Customer where level = :level and name = :name")
	List<Customer> findCustomerByLevel(@Param("level") Integer level,@Param("name") String name);

}
