package edu.receitps.api.controller;

import edu.receitps.api.dto.Receipt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Test
//    public void testMethod() {
////arrange
//        //act
//        ResponseEntity<Receipt> responseEntity = testRestTemplate.getForEntity("/receipts/walmart/01/01/2005/", Receipt.class);
//        //assert
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody().getReceiptsProviderName()).isEqualTo("Walmart");
//    }
}
