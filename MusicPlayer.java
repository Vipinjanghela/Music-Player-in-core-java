import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class Playlist {
    private String name;
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void playSongs() {
        System.out.println("Playing songs in " + name + ":");
        for (Song song : songs) {
            System.out.println("Playing: " + song);
        }
    }

    public void listSongs() {
        System.out.println("Songs in playlist " + name + ":");
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}


public class MusicPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Song> musicLibrary = new ArrayList<>();
        ArrayList<Playlist> playlists = new ArrayList<>();

        musicLibrary.add(new Song("Song A", "Artist 1"));
        musicLibrary.add(new Song("Song B", "Artist 2"));
        musicLibrary.add(new Song("Song C", "Artist 3"));

        boolean running = true;
        while (running) {
            System.out.println("\n1. Play Song\n2. Create Playlist\n3. Add Song to Playlist\n4. Play Playlist\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.println("Available songs:");
                    for (int i = 0; i < musicLibrary.size(); i++) {
                        System.out.println((i + 1) + ". " + musicLibrary.get(i));
                    }
                    System.out.println("Enter song number to play:");
                    int songChoice = sc.nextInt();
                    sc.nextLine(); // Clear newline
                    System.out.println("Playing: " + musicLibrary.get(songChoice - 1));
                    break;
                case 2:
                    System.out.println("Enter playlist name:");
                    String playlistName = sc.nextLine();
                    playlists.add(new Playlist(playlistName));
                    System.out.println("Playlist " + playlistName + " created.");
                    break;
                case 3:
                    System.out.println("Available songs:");
                    for (int i = 0; i < musicLibrary.size(); i++) {
                        System.out.println((i + 1) + ". " + musicLibrary.get(i));
                    }
                    System.out.println("Enter song number to add to playlist:");
                    int songNum = sc.nextInt();
                    sc.nextLine(); // Clear newline
                    System.out.println("Enter playlist name:");
                    String targetPlaylist = sc.nextLine();
                    for (Playlist playlist : playlists) {
                        if (playlist.getName().equals(targetPlaylist)) {  // Use getter method
                            playlist.addSong(musicLibrary.get(songNum - 1));
                            System.out.println("Song added to playlist.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter playlist name:");
                    String playPlaylist = sc.nextLine();
                    for (Playlist playlist : playlists) {
                        if (playlist.getName().equals(playPlaylist)) {  // Use getter method
                            playlist.playSongs();
                        }
                    }
                    break;

                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}
