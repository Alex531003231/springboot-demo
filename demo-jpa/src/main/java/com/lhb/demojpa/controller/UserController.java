package com.lhb.demojpa.controller;

import com.lhb.demojpa.entity.User;
import com.lhb.demojpa.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Created By haibo.li01@hand-china.com
 * @Time: 2019/8/26  17:38;
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 查询指定用户
     * @param name
     * @return
     */
    @GetMapping
    public List<User> list(@RequestParam String name) {
        return userRepository.findUsersByNameLikeOrderByAge(name);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User query(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * 新增用户
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping
    public User create(@RequestBody @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException(bindingResult.toString());
        }
        return userRepository.save(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}

