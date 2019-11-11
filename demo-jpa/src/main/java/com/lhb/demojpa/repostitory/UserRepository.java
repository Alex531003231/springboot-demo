package com.lhb.demojpa.repostitory;

import com.lhb.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Created By haibo.li01@hand-china.com
 * @Time: 2019/8/26  17:27;
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    List<User> findUsersByNameLikeOrderByAge(String name);
}
