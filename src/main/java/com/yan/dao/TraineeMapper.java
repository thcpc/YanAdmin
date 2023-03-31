package com.yan.dao;

import com.yan.dto.TraineeAttendanceReviewDto;
import com.yan.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TraineeMapper {
     List<TraineeEntity> getAllTrainees();

     int createUser(UserEntity user);

     int createTrainee(TraineeEntity trainee);

     int traineeSign(TraineeSignEntity traineeSignEntity);

     void updateTraineeLastAttendance(TraineeSignEntity traineeSignEntity);

     void createTraineeAttendanceRecord(TraineeSignEntity traineeSignEntity);

     TraineeSignEntity getTraineeSignEntityById(@Param("id") long id);

     List<TraineeYearEntity> getYears(@Param("id") long id);

     List<Map<String, Object>> getTraineeYearDetail(@Param("id") long id, @Param("year") String year);

     @Deprecated
     List<Integer> getMonthDay(@Param("id") long id, @Param("year") int year,@Param("month") int month);

     List<TraineeSignDetailEntity> getSignDetails(@Param("id") long id, @Param("year") int year,@Param("month") int month);

     List<TraineeAttendanceReviewEntity> getUnReviewedTraineeAttendance();

     void reviewTraineeAttendance(TraineeAttendanceReviewDto traineeAttendanceReviewDto);

}
