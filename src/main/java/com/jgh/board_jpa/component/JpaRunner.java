package com.jgh.board_jpa.component;

import com.jgh.board_jpa.domain.dao.UserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

   private final Logger logger = LogManager.getLogger(JpaRunner.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserDao userDao = new UserDao();
        userDao.setUsername("geahyun");
        userDao.setPassword("1234");

        logger.debug("통과");
        System.out.println("?????");

        entityManager.persist(userDao);
    }
}
