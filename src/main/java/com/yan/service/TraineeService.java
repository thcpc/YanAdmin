package com.yan.service;

import com.yan.dto.TraineeAttendanceReviewDto;
import com.yan.dto.TraineeDto;
import com.yan.dto.TraineeSignDto;
import com.yan.dto.UserDto;
import com.yan.entity.*;

import java.util.List;
import java.util.Map;

public interface TraineeService {
    List<TraineeEntity> getAllTrainees();

    UserEntity createUser(UserDto userDto);

    TraineeEntity createTrainee(TraineeDto traineeDto);

    TraineeSignEntity traineeSign(TraineeSignDto traineeSignDto);

    TraineeSignEntity getTraineeSignById(long id);

    List<TraineeYearEntity> getYears(long id);

    List<Map<String, Object>> getMonthCount(long id, String year);

    List<Integer> getMonthDay(long id, int year,int month);

    List<TraineeSignDetailEntity> getTraineeSignDetails(long id, int year, int month);

    List<TraineeAttendanceReviewEntity> getUnReviewedTraineeAttendance();

    void reviewTraineeAttendance(TraineeAttendanceReviewDto traineeAttendanceReviewDto);

}
