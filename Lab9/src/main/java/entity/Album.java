package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a where a.name = ?1"),
        @NamedQuery(name = "Album.findByArtist", query = "SELECT a FROM Album a where a.artist_id = ?1"),
})
public class Album {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "artist_id")
    private Integer artist_id;

    public Integer getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Integer artist_id) {
        this.artist_id = artist_id;
    }

    @Column(name = "release_year")
    private Integer release_year;

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist_id=" + artist_id +
                ", release_year=" + release_year +
                '}';
    }
}
