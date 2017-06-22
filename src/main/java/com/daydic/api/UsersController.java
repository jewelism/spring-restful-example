package com.daydic.api;

import com.daydic.domain.ResponseDto;
import com.daydic.domain.users.Users;

import com.daydic.domain.users.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by kusob on 2017. 5. 6..
 */
@Slf4j //log
@Api(value = "USERS API", description = "DayDic.USERS Table API", basePath = "/api/users")
@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @ApiOperation(value = "id로 회원목록조회 혹은 회원전체조회", notes = "회원목록조회 - id로 조회, 파라미터가없으면 전체조회")
    @RequestMapping(value = "allList", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> getUserList(@RequestParam(value = "id", defaultValue = "", required = false) Long id) {
        if (id == null) {
            return usersService.findAllUserList();
        } else {
            return usersService.findUser(id);
        }
    }

    @ApiOperation(value = "이메일로 회원조회", notes = "회원목록조회 - 이메일로 조회")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    Users getUser(@RequestParam(value = "email") String email) {
        return usersService.findUser(email);
    }

    @ApiOperation(value = "id로 특정범위 회원조회", notes = "회원목록조회 -  id1 ~ id2 범위조회")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody
    List<Users> getUserBetween(@RequestParam(value = "uid1") long uid1, @RequestParam(value = "uid2") long uid2) {
        return usersService.findBetween(uid1, uid2);
    }

    @ApiOperation(value = "회원가입", notes = "데이터베이스에 회원추가 - 회원가입")
    @RequestMapping(value = "join", method = RequestMethod.POST)
    public ResponseDto joinUser(@RequestBody Users user) {
        return usersService.saveUser(user);
    }

    @ApiOperation(value = "id로 회원삭제", notes = "데이터베이스에서 id로 조회하여 회원삭제")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseDto deleteUser(@RequestParam("id") Long id) {
        return usersService.deleteUserById(id);
    }

    @ApiOperation(value = "email로 회원삭제", notes = "데이터베이스에서 email로 조회하여 회원삭제하되, 혹시라도 중복 이메일이 있으면 DB순서로 첫번째만 삭제")
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public ResponseDto removeUser(@RequestParam("email") String email) {
        return usersService.removeUserByEmail(email);
    }

}
