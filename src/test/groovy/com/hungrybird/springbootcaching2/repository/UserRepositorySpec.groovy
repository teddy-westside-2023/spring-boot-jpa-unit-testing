package com.hungrybird.springbootcaching2.repository

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

//@SpringBootTest
//@ActiveProfiles("test")
//@Slf4j
@DataJpaTest
class UserRepositorySpec extends Specification {
    @Autowired
    UserRepository userRepository

    @Autowired
    private TestEntityManager entityManager;

    void setup() {
    }

    void "query annotation test" () {
        expect:
        log.info "@ ${this.userRepository}"
        1 == 1
    }

}
