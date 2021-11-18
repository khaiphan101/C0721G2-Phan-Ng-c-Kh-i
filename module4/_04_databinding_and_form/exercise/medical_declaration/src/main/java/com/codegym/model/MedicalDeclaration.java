package com.codegym.model;

public class MedicalDeclaration {
    String name;
    String birthday;
    String gender;
    String country;
    String travelInfo;
    String departDay;
    String endDay;
    String province;
    String district;
    String ward;
    Boolean fever;
    Boolean cough;
    Boolean vomiting;
    Boolean diarrhea;
    Boolean closeContact;

    public MedicalDeclaration(String name, String birthday, String gender, String country, String travelInfo, String departDay, String endDay, String province, String district,
                              String ward, Boolean fever, Boolean cough, Boolean vomiting, Boolean diarrhea, Boolean closeContact) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.travelInfo = travelInfo;
        this.departDay = departDay;
        this.endDay = endDay;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.fever = fever;
        this.cough = cough;
        this.vomiting = vomiting;
        this.diarrhea = diarrhea;
        this.closeContact = closeContact;
    }

    public MedicalDeclaration() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getDepartDay() {
        return departDay;
    }

    public void setDepartDay(String departDay) {
        this.departDay = departDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getVomiting() {
        return vomiting;
    }

    public void setVomiting(Boolean vomiting) {
        this.vomiting = vomiting;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean getCloseContact() {
        return closeContact;
    }

    public void setCloseContact(Boolean closeContact) {
        this.closeContact = closeContact;
    }
}
