package caseStudy_furamaResort.models;

public class Employee extends Person {

    private String level;
    private String position;
    private long salary;

    public Employee() {
    }

    public Employee(int code, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String level, String position, long salary) {
        super(code, name, birthday, gender, idNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employeeCode=" + super.getCode() +
                ", name='" + super.getName() + '\'' +
                ", birthday='" + super.getBirthday() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", idNumber=" + super.getIdNumber() +
                ", phoneNumber=" + super.getPhoneNumber() +
                ", email='" + super.getEmail() + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'';
    }

    public String writeToFile() {
        return super.getCode() +
                "," + super.getName() +
                "," + super.getBirthday() +
                "," + super.getGender() +
                "," + super.getIdNumber() +
                "," + super.getPhoneNumber() +
                "," + super.getEmail() +
                "," + level +
                "," + position +
                "," + salary;
    }
}
