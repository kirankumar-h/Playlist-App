import java.util.*;
public class Album {
    private String name;
    private String artist;

    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;

        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    boolean findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    String addSongToAlbum(String title,double duration){

        if(findSong(title)==false){
            Song s = new Song(title,duration);
            songs.add(s);
            return "song added to the album";
        }
        else {
            return "Song already exists";
        }
    }

    String addSongToPlaylistfromAlbum(String title,List<Song> playlist){
        if(findSong(title)==true){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "song added to your playlist";
                }
            }
        }
            return "song not present in album";
    }
    String addSongToPlaylistfromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo-1;
        if(index>=0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return "song has been added to your album";
        }
        else return "Invalid position of song";

    }
}
