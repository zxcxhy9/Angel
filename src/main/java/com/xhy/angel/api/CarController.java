package com.xhy.angel.api;

import com.xhy.angel.api.dto.CarRequest;
import com.xhy.angel.application.CarService;
import com.xhy.angel.common.dto.ApiResponse;
import com.xhy.angel.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ApiResponse<List<Car>> cars(){
        System.out.println("是否被调用到:" + "Y");
        return ApiResponse.success(carService.getCars());
    }

    @DeleteMapping("/car/{id}")
    public ApiResponse deleteCar(@PathVariable("id") String id){
        carService.deleteCar(new Long(id));
        return ApiResponse.success(null);
    }

    @PostMapping("/cars")
    public ApiResponse insertCar(@RequestBody CarRequest carRequest){
        int i = carService.insertCar(carRequest);
        if( i != 1) {
            return ApiResponse.fail("数据插入失败");
        } else {
            return ApiResponse.success(null);
        }
    }
}
