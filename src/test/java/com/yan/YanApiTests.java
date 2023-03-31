package com.yan;


import com.yan.dto.TraineeAttendanceReviewDto;
import com.yan.dto.TraineeSignDto;
import com.yan.entity.Response;
import com.yan.entity.TraineeSignEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YanApiTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void traineeSign() throws Exception{
        String url = "http://localhost:" + port + "/yan/trainee/sign";
        Response response = this.testRestTemplate.postForObject(url, new TraineeSignDto(15), Response.class);
        System.out.println(response.getPayLoad().toString());
    }

    @Test
    public void traineeMonthCount() throws Exception{
//        http://localhost:8080/yan/trainee/month?traineeId=1&year=2022
        String url = "http://localhost:" + port + "/yan/trainee/month?traineeId=1&year=2022";
        Response response = this.testRestTemplate.getForObject(url, Response.class);
        System.out.println(response.getPayLoad().toString());

    }

    @Test
    public void traineeMonthDay() throws Exception{
        String url = "http://localhost:" + port + "/yan/trainee/traineeMonthDay?traineeId=1&year=2022&month=12";
        Response response = this.testRestTemplate.getForObject(url, Response.class);
        System.out.println(response.getPayLoad().toString());
    }

    @Test
    public void getTraineeSignDetail(){
        String url = "http://localhost:" + port + "/yan/trainee/signDetails?traineeId=15&year=2023&month=3";
        Response response = this.testRestTemplate.getForObject(url, Response.class);
        System.out.println(response.getPayLoad().toString());
    }

    @Test
    public void getUnReviewedTraineeAttendance(){
        String url = "http://localhost:" + port + "/yan/unReview";
        Response response = this.testRestTemplate.getForObject(url, Response.class);
        System.out.println(response.getPayLoad().toString());
    }

    @Test
    public void reviewTraineeAttendance(){
        String url = "http://localhost:" + port + "/yan/review";
        Response response = this.testRestTemplate.postForObject(url,new TraineeAttendanceReviewDto(190,1,"xxxxxxx"), Response.class);
        System.out.println(response.toString());
    }




}
