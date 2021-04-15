package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class LibraryManagementRestApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Book
	@Test
    public void TestCase1() throws Exception {
		
		String dataOne = "{\"bookId\":\"12881\",\"bookName\":\"Half Girlfriend\",\"quantity\":\"10\",\"genre\":\"GreatLove\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/saveBook")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	//Get All Books
	@Test
    public void TestCase2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/getBooks")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].bookName").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }
	
	//Get A Book By Type
	@Test
	public void TestCase3() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getByType")
				.param("id","GreatLove")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$[0].bookName").value("Half Girlfriend"))
		        .andExpect(jsonPath("$[0].quantity").value("10"))
		        .andReturn();
			
	}
	
	//Edit the Book Details
	@Test
    public void TestCase4() throws Exception {
		
		String dataOne = "{\"bookName\":\"Half Girlfriend\",\"quantity\":\"5\",\"genre\":\"GreatLove\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/editBook")
	 			.param("bookId","12881")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	//Delete the Book
	@Test
    public void TestCase5() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/deleteBook")
	 			.param("bookId","12881")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 			
    }
	
}
