public class Booking {
    private User user;
    private Movie movie;
    private String date;
    private String time;
    private int numberOfTickets;

    public Booking(User user, Movie movie, String date, String time, int numberOfTickets) {
        this.user = user;
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.numberOfTickets = numberOfTickets;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
