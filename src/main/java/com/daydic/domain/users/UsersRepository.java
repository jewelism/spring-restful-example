package com.daydic.domain.users;

import com.daydic.domain.ResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kusob on 2017. 5. 6..
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(@Param(value = "email") String email);

    ResponseDto deleteByEmail(@Param(value = "email") String email);

    List<Users> findByUidBetween(long uid1, long uid2);
}
