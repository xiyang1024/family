package com.ycj.family.repository;

import com.ycj.family.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author chuanjieyang
 * @since Feb 14, 2019 11:43:38 AM
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {
}
