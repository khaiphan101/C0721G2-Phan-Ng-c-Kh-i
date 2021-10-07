package models;

public class Show {
    private String codeShow;
    private String movieName;
    private String showDate;
    private int totalTicket;

    public Show(String codeShow, String movieName, String showDate, int totalTicket) {
        this.codeShow = codeShow;
        this.movieName = movieName;
        this.showDate = showDate;
        this.totalTicket = totalTicket;
    }

    public Show() {
    }

    public String getCodeShow() {
        return codeShow;
    }

    public void setCodeShow(String codeShow) {
        this.codeShow = codeShow;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    @Override
    public String toString() {
        return "Show{" +
                "codeShow='" + codeShow + '\'' +
                ", movieName='" + movieName + '\'' +
                ", showDate='" + showDate + '\'' +
                ", totalTicket=" + totalTicket +
                '}';
    }

    public String writeToFile() {
        return   codeShow + ',' + movieName + ',' + showDate + ',' + totalTicket;
    }

}
