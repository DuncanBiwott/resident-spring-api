package com.residentcomplaintmanagement.resident;

import com.residentcomplaintmanagement.resident.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource()
class ResidentApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserRepository repository;

	@Test
	void contextLoads() {
	}

}
