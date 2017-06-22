package com.daydic.domain.users;

import com.daydic.domain.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kusob on 2017. 5. 10..
 * 백수 모쏠 종원
 */
@Slf4j
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAllUserList() {
        return usersRepository.findAll();
    }

    public List<Users> findUser(Long id) {
        List<Users> list = new LinkedList<Users>();
        list.add(usersRepository.findOne(id));
        return list;
    }

    public Users findUser(String email) {
        return usersRepository.findByEmail(email);
    }

    public List<Users> findBetween(long uid1, long uid2) {
        return usersRepository.findByUidBetween(uid1, uid2);
    }

    @Transactional(readOnly = false)
    public ResponseDto saveUser(Users user) {
        if (usersRepository.findByEmail(user.getEmail()) == null) { //email 중복 방지
            try {
                user.setCreatedDate(LocalDate.now());
                usersRepository.save(user);
                return ResponseDto.ofSuccess("success");
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        } else {
            return ResponseDto.ofFail("email duplicate");
        }
        return ResponseDto.ofEmpty();
    }

    @Transactional(readOnly = false)
    public ResponseDto deleteUserById(Long id) {
        if (usersRepository.findOne(id) != null) { //존재하는 경우에만 삭제
            try {
                usersRepository.delete(id);
                return ResponseDto.ofSuccess("success");
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        } else {
            return ResponseDto.ofFail("not exist");
        }
        return ResponseDto.ofEmpty();
    }

    @Transactional(readOnly = false)
    public ResponseDto removeUserByEmail(String email) {
        if (usersRepository.findByEmail(email) != null) {
            try {
                Users user = usersRepository.findByEmail(email);
                long id = user.getUid();
                usersRepository.delete(id);
                return ResponseDto.ofSuccess("success");
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        } else {
            return ResponseDto.ofFail("not exist");
        }
        return ResponseDto.ofEmpty();
    }
}
