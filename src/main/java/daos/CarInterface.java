package daos;
import models.Car;

import java.util.List;
public interface CarInterface {
//findById()
//findAll()
//update()
//create()
//delete()
    Car findById(int id);
    List<Car> findAll();
    boolean createCar(Car car);
    Car updateCar(Car car);
    boolean deleteCar(int id);


}



