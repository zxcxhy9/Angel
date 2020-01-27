package com.xhy.angel.application;

import com.xhy.angel.api.dto.CarRequest;
import com.xhy.angel.domain.Car;
import com.xhy.angel.infrastructure.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarMapper carMapper;

    @Transactional(readOnly = true)
    public List<Car> getCars() {
        return carMapper.selectAll();
    }

    @Transactional
    public void deleteCar(Long id) {
        carMapper.deleteById(id);
    }

    @Transactional
    public int insertCar(CarRequest carRequest) {
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setName(carRequest.getName());
        return carMapper.insertCar(car);
    }
}
