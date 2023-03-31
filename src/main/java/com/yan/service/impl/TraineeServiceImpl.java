package com.yan.service.impl;

import com.yan.dao.TraineeMapper;
import com.yan.dto.TraineeAttendanceReviewDto;
import com.yan.dto.TraineeDto;
import com.yan.dto.TraineeSignDto;
import com.yan.dto.UserDto;
import com.yan.entity.*;
import com.yan.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TraineeServiceImpl implements TraineeService {
    @Autowired
    private TraineeMapper traineeDao;

    @Override
    public List<TraineeEntity> getAllTrainees() {

        return traineeDao.getAllTrainees();
    }

    public UserEntity createUser(UserDto userDto){
        UserEntity newUser = UserEntity.create(userDto);
        traineeDao.createUser(newUser);
        return newUser;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TraineeEntity createTrainee(TraineeDto traineeDto) {
        UserDto userDto = UserDto.createTraineeUser(traineeDto);
        TraineeEntity traineeEntity = TraineeEntity.create(traineeDto,createUser(userDto).getId());
        traineeDao.createTrainee(traineeEntity);
        return  traineeEntity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TraineeSignEntity traineeSign(TraineeSignDto traineeSignDto) {
        TraineeSignEntity traineeSignEntity = TraineeSignEntity.create(traineeSignDto);
        traineeDao.traineeSign(traineeSignEntity);
        traineeDao.updateTraineeLastAttendance(traineeSignEntity);
        traineeDao.createTraineeAttendanceRecord(traineeSignEntity);
        return traineeDao.getTraineeSignEntityById(traineeSignEntity.getId());
    }

    @Override
    public TraineeSignEntity getTraineeSignById(long id) {
        return traineeDao.getTraineeSignEntityById(id);
    }

    @Override
    public List<TraineeYearEntity> getYears(long id) {
        return traineeDao.getYears(id);
    }

    @Override
    public List<Map<String, Object>> getMonthCount(long id, String year) {
        return traineeDao.getTraineeYearDetail(id, year);
    }

    @Override
    public List<Integer> getMonthDay(long id, int year, int month) {
        return traineeDao.getMonthDay(id,year,month);
    }

    @Override
    public List<TraineeSignDetailEntity> getTraineeSignDetails(long id, int year, int month) {
        return traineeDao.getSignDetails(id,year,month);
    }

    @Override
    public List<TraineeAttendanceReviewEntity> getUnReviewedTraineeAttendance() {
        return traineeDao.getUnReviewedTraineeAttendance();
    }

    @Override
    public void reviewTraineeAttendance(TraineeAttendanceReviewDto traineeAttendanceReviewDto) {
        this.traineeDao.reviewTraineeAttendance(traineeAttendanceReviewDto);
    }
}
