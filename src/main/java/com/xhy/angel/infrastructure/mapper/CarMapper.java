package com.xhy.angel.infrastructure.mapper;

import com.xhy.angel.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Mapper
@Component
public interface CarMapper {
    List<Car> selectAll();

    void deleteById(Long id);

    int insertCar(Car car);
}
