import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> allStrings = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello! Welcome to my Search Engine!");
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                    allStrings.add(parameters[1]);
                    return String.format(parameters[1] + " added to catalog");//Check later, won't print
                }
        } else if (url.getPath().equals("/search")){
            String[] parameters = url.getQuery().split("=");
            String appendSearch = "";
            if (parameters[0].equals("s")) {
                    for(int i = 0; i < allStrings.size(); i++){
                        if(allStrings.get(i).contains(parameters[1])){
                            appendSearch = appendSearch.concat(allStrings.get(i) + " ");
                        }
                    }
                    
                    return String.format("This is your list of words that contain " + parameters[1] + ": " + appendSearch);
                }

        }else{
            System.out.println("Path: " + url.getPath());
            String allEntries = "";
            if (url.getPath().contains("/allEntries")) {
                for(int i = 0; i < allStrings.size(); i++){
                    allEntries.concat(allStrings.get(i));
                }
            }
            return String.format("Here are all your entries: " + allEntries);
        }
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
