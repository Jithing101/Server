package com.falcon.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.falcon.entity.Server;

import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

	
	@Query(value = "SELECT * FROM sys.SERVER", nativeQuery = true)
    List<Server> findbyIpAddress();

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM sys.SERVER WHERE id = :id", nativeQuery = true)
	void deleteById(@Param("id") String id);
}
