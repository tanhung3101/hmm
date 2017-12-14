package com.nop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {

	@Query("Select a from User a where a.userName=:userName")
	public User findUserByUserName(@Param("userName")String userName);
}
