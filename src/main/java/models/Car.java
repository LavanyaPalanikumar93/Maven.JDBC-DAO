package models;
public class Car {
    //id
    //make
    //model
    //year
    //color
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;
    public Car() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getColor() {
        return color;}
        public void setColor (String color){
            this.color = color;}

        public Car(Integer id, String make, String model, Integer year, String color) {
                this.id = id;
                this.make = make;
                this.model = model;
                this.year = year;
                this.color = color;
            }
    public Car(String make, String model, Integer year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

        }

