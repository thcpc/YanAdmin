package com.yan.controller;

import com.yan.dto.TraineeDto;
import com.yan.dto.TraineeSignDto;
import com.yan.dto.TraineeAttendanceReviewDto;
import com.yan.dto.UserDto;
import com.yan.entity.*;
import com.yan.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


@RestController
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/yan/trainee/all")
    @ResponseBody
    public Response<List<TraineeEntity>> getAllTrainees() {
        return Response.ok(traineeService.getAllTrainees(), "OK");

    }


    @PostMapping("/yan/trainee/create")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Response<TraineeEntity> createTrainee(@RequestBody TraineeDto traineeDto) {
        TraineeEntity traineeEntity = traineeService.createTrainee(traineeDto);
        return Response.ok(traineeEntity,"OK");
    }


    @PostMapping("/yan/user/create")
    @ResponseBody
    public Response createUser(@RequestBody UserDto userDto) {
        int userId = traineeService.createUser(userDto).getId();
        return Response.ok("OK");
    }




    @PostMapping("/yan/review")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Response reviewTraineeAttendance(@RequestBody TraineeAttendanceReviewDto traineeAttendanceReviewDto){
        traineeService.reviewTraineeAttendance(traineeAttendanceReviewDto);
        return Response.ok("OK");
    }


    @GetMapping("/yan/unReview")
    @ResponseBody
    public Response<List<TraineeAttendanceReviewEntity>> getUnReviewedTraineeAttendance(){
        List<TraineeAttendanceReviewEntity> traineeAttendanceReviewEntities = traineeService.getUnReviewedTraineeAttendance();
        return Response.ok(traineeAttendanceReviewEntities,"OK");
    }




    @PostMapping("/yan/trainee/sign")
    @ResponseBody
    public Response<TraineeSignEntity> traineeSign(@RequestBody TraineeSignDto traineeSignDto) {
        TraineeSignEntity traineeSignEntity = traineeService.traineeSign(traineeSignDto);
        return Response.ok(traineeSignEntity,"ok");
//        return Response.error(999, "error happen");
    }

    @GetMapping("/yan/trainee/years")
    @ResponseBody
    public Response<List<TraineeYearEntity>> traineeYears(@RequestParam(value = "traineeId") long traineeId) {
        return Response.ok(traineeService.getYears(traineeId), "OK");
    }


    @GetMapping("/yan/trainee/month")
    @ResponseBody
    public Response<TraineeMonthEntity> traineeMonthCount(@RequestParam(value = "traineeId") long traineeId, @RequestParam(value = "year") String year) {
        TraineeMonthEntity traineeMonth = new TraineeMonthEntity(traineeId);
//        List<Integer> monthCount = Collections.nCopies(12,0);
        Integer[] monthCount = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.traineeService.getMonthCount(traineeId, year).forEach(new Consumer<Map<String, Object>>() {
            @Override
            public void accept(Map<String, Object> monthCountMap) {
                Integer month = Integer.parseInt(monthCountMap.get("month").toString());
                Integer count = Integer.parseInt(monthCountMap.get("monthCount").toString());
                monthCount[month - 1] = count;
            }
        });
        traineeMonth.setMonthCount(List.of(monthCount));
        traineeMonth.setYear(year);

        return Response.ok(traineeMonth, "OK");
    }





    @Deprecated
    @GetMapping("/yan/trainee/traineeMonthDay")
    @ResponseBody
    public Response<TraineeMonthDayEntity> traineeMonthDay(@RequestParam(value = "traineeId") long traineeId, @RequestParam(value = "year") int year, @RequestParam(value = "month") int month) {
        TraineeMonthDayEntity traineeMonthDay = new TraineeMonthDayEntity();
        traineeMonthDay.setId(traineeId);
        traineeMonthDay.setYear(year);
        traineeMonthDay.setMonth(month);
        traineeMonthDay.setDays(this.traineeService.getMonthDay(traineeId,year,month));
        return Response.ok(traineeMonthDay, "OK");
    }

    @GetMapping("/yan/trainee/signDetails")
    @ResponseBody
    public Response<List<TraineeSignDetailEntity>> getSignDetails(@RequestParam(value = "traineeId") long traineeId, @RequestParam(value = "year") int year, @RequestParam(value = "month") int month) {
        List<TraineeSignDetailEntity> traineeSignDetailEntities =  this.traineeService.getTraineeSignDetails(traineeId, year, month);
        return Response.ok(traineeSignDetailEntities, "OK");
    }


}
