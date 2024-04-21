package daos;
import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CarDao implements CarInterface{
    @Override
    public Car findById(int id) {
        Connection connection=ConnectionFactory.getConnection();
        try{
            Statement st=connection.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM car WHERE id="+id);
            if(rs.next()){
                return extractUserFromReultSet(rs);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }return null;
           }
    private Car extractUserFromReultSet(ResultSet rs)throws SQLException{
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("yearOfModel"));
        car.setModel(rs.getString("color"));
        return car;
    }
    @Override
    public List<Car> findAll() {
        Connection connection=ConnectionFactory.getConnection();
        List<Car> cars=new ArrayList<>();
        try{
            Statement st=connection.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM cars;");
            if(rs.next()){
                Car car=extractUserFromReultSet(rs);
                cars.add(car);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }
    @Override
    public boolean createCar(Car car) {
        Connection connection=ConnectionFactory.getConnection();
        try{
            PreparedStatement ps=connection.prepareStatement("INSERT INTO user VALUES (NULL,?,?,?,?");
            ps.setInt(1,car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4,car.getYear());
            ps.setString(5, car.getColor());
            int i= ps.executeUpdate();

            if(i==1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public Car updateCar(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, yearOfModel=?, color=? WHERE id=?");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setInt(5, car.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                return findById(car.getId());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public boolean deleteCar(int id) {
        Connection connection=ConnectionFactory.getConnection();

        try{
            Statement st=connection.createStatement();
            int i= st.executeUpdate("DELETE FROM cars WHERE id="+id);
            if(i==1){
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
