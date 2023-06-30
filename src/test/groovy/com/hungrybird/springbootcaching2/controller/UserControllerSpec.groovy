package com.hungrybird.springbootcaching2.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


//@Title("WebController Specification")
//@Narrative("The Specification of the behaviour of the WebController. It can greet a person, change the name and reset it to 'world'")
//@AutoConfigureMockMvc
//@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class UserControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    def "update"() {
        given: "Status is 200 and the response is 'Hello world!'"
        String url = "/api/v0/users"

        when:
        ResultActions response = this.mockMvc.perform(get(url))

        then:
        response
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$[0].username').value('Honda'))
                .andExpect(jsonPath('$[1].username').value('Buick'))
                .andExpect(jsonPath('$[2].username').value('Honda'))
//                .andExpect(jsonPath('$.products[0].name').value('iphone1'))
    }
}
