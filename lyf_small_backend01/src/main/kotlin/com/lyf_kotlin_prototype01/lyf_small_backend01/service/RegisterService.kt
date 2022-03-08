package com.lyf_kotlin_prototype01.lyf_small_backend01.service

import com.lyf_kotlin_prototype01.lyf_small_backend01.entity.database.UserEntity
import com.lyf_kotlin_prototype01.lyf_small_backend01.register.RegisterDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class RegisterService(@Autowired registerDao: RegisterDao) {
    var registerDao = registerDao

    fun register(user: UserEntity): Boolean {
        return registerDao.register(user)
    }

}