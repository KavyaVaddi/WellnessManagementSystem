package com.wellness;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wellnessmanagement.service.FarmersService;

@ExtendWith(SpringExtension.class)
public class FarmersControllerTest {

	private static MockMvc mockMvc;

	//@Autowired
	//FarmersController obj;
	
	@Autowired
	FarmersService ser;
	
	@BeforeAll
    static void init () {
        mockMvc = MockMvcBuilders.standaloneSetup(FarmersControllerTest.class).build();
    }
	
	@Test
    void testController() throws Exception {
        mockMvc.perform(get("/farmerproducts/10001")).andDo(print()).andExpect(status().isOk());
    }
	
	@Test
    void shouldGive405ForPost() throws Exception {
        mockMvc.perform(post("/farmerproducts/10001")).andDo(print()).andExpect(status().isMethodNotAllowed());
    }

	/*@Test
	public void getFarmerProdctDetails() {
		obj = new FarmersController();
		List<Products> list = ser.farmerproducts(10001);
		assertEquals(list , obj.getFarmerProdctDetails(10001));
	}*/
}
