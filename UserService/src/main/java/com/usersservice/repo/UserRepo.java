package com.usersservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usersservice.models.User;
import com.usersservice.repo.projection.UserProjection;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	List<UserProjection> findBy();

	
}
