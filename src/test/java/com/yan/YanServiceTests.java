package com.yan;

import com.yan.dto.TraineeDto;
import com.yan.dto.TraineeSignDto;
import com.yan.dto.UserDto;
import com.yan.entity.*;
import com.yan.service.TraineeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
class YanServiceTests {

	@Autowired
	public TraineeService traineeService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUserTest(){
		UserEntity user = traineeService.createUser(new UserDto("jia2","jia2","trainee"));
		System.out.println("UserID:"+ user.getId());
	}

	@Test
	void createTrainee(){
		TraineeEntity trainee = traineeService.createTrainee(new TraineeDto("yi1","yi1",7));
		System.out.println(trainee.getCreateDt());
	}

	@Test
	void traineeSign(){
		TraineeSignDto signDto = new TraineeSignDto(15);
		TraineeSignEntity traineeSignEntity = traineeService.traineeSign(signDto);
		System.out.println(traineeSignEntity.getTraineeId());
		System.out.println(traineeSignEntity.getCreateDt());
	}

	@Test
	void getTraineeSignById(){
		TraineeSignEntity traineeSignEntity = traineeService.getTraineeSignById(3);
		System.out.println(traineeSignEntity.getCreateDt());
	}

	@Test
	void getYears(){
		List<TraineeYearEntity> years = traineeService.getYears(1);
		years.forEach(traineeYearEntity -> {
			System.out.println(traineeYearEntity.getYear());
		});
	}

	@Test
	void getSignDetails(){
		List<TraineeSignDetailEntity> days = traineeService.getTraineeSignDetails(15,2023, 3);
		days.forEach(traineeSignDetailEntity -> System.out.println(traineeSignDetailEntity.getCreateDt()));

	}

	@Test
	void getUnReviewedAttendance(){
		List<TraineeAttendanceReviewEntity> traineeAttendanceReviewEntities = traineeService.getUnReviewedTraineeAttendance();
		traineeAttendanceReviewEntities.forEach(traineeSignDetailEntity -> System.out.println(traineeSignDetailEntity.getCreateDt()));

	}



}
