package com.lyf_kotlin_prototype01.lyf_small_backend01.register

import com.lyf_kotlin_prototype01.lyf_small_backend01.entity.database.UserEntity
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.server.Session
import org.springframework.stereotype.Repository
import java.lang.Exception

/*
DAO stands for data access object,
it needs sessionFactory to connect with the database

we used sessionFactory from Hibernate as JDBC - Java Database Connectivity
what is the equivalent in the sprint data???



* */
@Repository
open class RegisterDao(@Autowired sessionFactory: SessionFactory) {
    var sessionFactory = sessionFactory

    fun register(user: UserEntity): Boolean {
        var session: Session
        try {
            session = sessionFactory.openSession()    // type mismatch: spring session != hibernate's session Factory.
            session.beginTransaction();
            session.save(user)
            session.getTransaction().commit();
        }
        // there is no multiple catch in Kotlin yet:
        catch (ex: Exception) {
            ex.printStackTrace();
            return false;
        }

        finally {
            session.close()
        }
        return true
    }
}