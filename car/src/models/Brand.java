package models;

public class Brand {
    private String idBrand;
    private String brandName;
    private String country;
    public Brand() {
    }

    public Brand(String idBrand, String brandName, String country) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.country = country;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "idBrand='" + idBrand + '\'' +
                ", brandName='" + brandName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String writeToFile(){
        return idBrand + ',' + brandName + ',' + country;
    }
}
