public class Chart {
    String artist_name;
    String album_name;
    Integer votes;

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "artist_name='" + artist_name + '\'' +
                ", album_name='" + album_name + '\'' +
                ", votes=" + votes +
                '}';
    }
}
