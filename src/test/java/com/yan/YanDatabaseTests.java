package com.yan;


import com.yan.dao.TraineeMapper;
import com.yan.entity.TraineeEntity;
import com.yan.entity.TraineeSignDetailEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


@ExtendWith(SpringExtension.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class YanDatabaseTests {

    @Autowired
    private TraineeMapper traineeMapper;



    @Test
    public void getAllTrainee(){
        List<TraineeEntity> traineeEntities = traineeMapper.getAllTrainees();
        traineeEntities.forEach(traineeEntity -> {
            System.out.println(traineeEntity.getName());
        });
    }

    @Test
    public void getTraineeYearDetail(){
        List<Map<String, Object>> traineeEntities = traineeMapper.getTraineeYearDetail(1,"2000");
        traineeEntities.forEach(System.out::println);
    }

    @Test
    public void getTraineeMonthDay(){
        List<Integer> days = traineeMapper.getMonthDay(2,2022, 12);
        days.forEach(System.out::println);
    }

    @Test
    public void getTrainSignDetail(){
        List<TraineeSignDetailEntity> days = traineeMapper.getSignDetails(15,2023, 3);
        days.forEach(traineeSignDetailEntity -> System.out.println(traineeSignDetailEntity.getCreateDt()));
    }

}
