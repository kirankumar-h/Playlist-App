import java.util.*;
public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("udd gaye", "ritviz");
        album1.addSongToAlbum("song 1", 5.3);
        album1.addSongToAlbum("song 2", 4.3);
        album1.addSongToAlbum("song 3", 3.2);

        Album album2 = new Album("moosa", "siddu moosewala");
        album2.addSongToAlbum("295", 5.3);
        album2.addSongToAlbum("same beef", 4.3);
        album2.addSongToAlbum("so high", 3.4);

        List<Song> myplaylist = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistfromAlbum("295", myplaylist));
        System.out.println(album1.addSongToPlaylistfromAlbum(2,myplaylist));
        System.out.println(album2.addSongToPlaylistfromAlbum("same beef",myplaylist));

        play(myplaylist);
    }

    public static void play(List<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();

        if(playlist.size()==0){
            System.out.println("playlist is empty");
            return;
        }

        boolean isNext;
        System.out.println("current playing");
        System.out.println(itr.next());
        isNext = true;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    if(isNext==false){
                        itr.next();
                        isNext=true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(isNext){
                        itr.previous();
                        isNext=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are on the first song already");
                    }
                    break;
                case 3:
                    if(isNext==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isNext=false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext=true;
                        }
                    }
                     break;
                case 4:
                    itr.remove();
                    break;
                case 5:
                    printAllSongs(playlist);
                    break;
                case 6:
                    printmenu();
                    break;
                case 7: //exit
                    return;
            }
        }
    }

    static void printAllSongs(List<Song> playlist){
        for(Song song : playlist){
            System.out.println(song);
        }
        return;
    }
    public static void printmenu(){
        System.out.println("play next song");
        System.out.println("play previous song");
        System.out.println("play current song again");
        System.out.println("Delete current song");
        System.out.println("show all songs");
        System.out.println("show menu again");
        System.out.println("Exit");

    }
}