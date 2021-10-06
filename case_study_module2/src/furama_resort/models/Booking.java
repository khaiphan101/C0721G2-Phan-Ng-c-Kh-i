package furama_resort.models;

import furama_resort.services.CustomerService;

import java.util.List;
import java.util.Objects;

public class Booking {
    private int code;
    private String startDay;
    private String endDay;
    private int customerCode;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(int code, String startDay, String endDay, int customerCode, String serviceName, String serviceType) {
        this.code = code;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "code=" + code +
                ", startDay=" + startDay + '\'' +
                ", endDay=" + endDay + '\'' +
                ", customerCode=" + customerCode + '\'' +
                ", serviceName=" + serviceName + '\'' +
                ", serviceType=" + serviceType;
    }

    public String writeToFile() {
        return code + ',' + startDay + ',' + endDay + ',' + customerCode + ',' + serviceName + ',' + serviceType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Booking))
            return false;
        Booking booking = (Booking) obj;
        return booking.getCode() == this.getCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
