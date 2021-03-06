package com.example.springsecurityjpah2.repo;




import com.example.springsecurityjpah2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {


	@Query(value = "Select * from tbl_user u where u.id =?1", nativeQuery = true)
	User findUserById(Integer id);

	@Query(value = "Select * from tbl_user u where u.role =?1", nativeQuery = true)
	List<User> findByRole (String role);

	@Query(value = "select * from tbl_user u where u.name like %?1% ", nativeQuery =true)
	List<User> searchUser(String search);

	//for reports
	@Query(value= "select count(user_id) from tbl_bids where user_id=?1", nativeQuery = true)
	Integer totalBids(Integer id);


}