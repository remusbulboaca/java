public class ChartData {
    Integer id;
    Integer id_album;
    Integer votes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "id=" + id +
                ", id_album=" + id_album +
                ", votes=" + votes +
                '}';
    }
}
