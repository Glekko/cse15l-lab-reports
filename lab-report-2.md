# Part 1
This is the code I used for my Simple Search Engine from last week. 

```
import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a   number that will be manipulated by
    // various requests.
    ArrayList<String> allStrings = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello! Welcome to my Search Engine!");
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                    allStrings.add(parameters[1]);
                    return String.format(parameters[1] + " added to catalog");
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
```


Here's first screenshot! I added banana to the main list. 
![First Picture](Lab-Report-2-Pictures\First.png)

This runs this method
```
else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                    allStrings.add(parameters[1]);
                    return String.format(parameters[1] + " added to catalog");
                }
```
When the program detects "/add", the computer then splits the characters after the 
> ?s=

and adds it to my arrayList called allStrings.

![Picture 2](Lab-Report-2-Pictures\Second.png)

I meant to add bandana here, but it readded I accidentally spelled it wrong, so now there are 2 bananas in the list. I added bandana later, so we should se 2 instances of banana and 1 of bandana.

![Picture 3](Lab-Report-2-Pictures\Third.png)

This is my third picture and it shows the "search" keyword in action. This utilizes this portion of the code
```
else if (url.getPath().equals("/search")){
            String[] parameters = url.getQuery().split("=");
            String appendSearch = "";
            if (parameters[0].equals("s")) {
                    for(int i = 0; i < allStrings.size(); i++){
                        if(allStrings.get(i).contains(parameters[1])){
                            appendSearch = appendSearch.concat(allStrings.get(i) + " ");
                        }
```

You can see that if getPath detects "/search" then it creates a string called parameters that takes in the characters after the "?s=" ("ban" in the screenshot) and iterates over the arrayList allStrings and uses the .contains method to check if "ban" is in the words of array. If so, it concats/appends it to a string called appendSearch which then gets printed out on the screen!

# Part 2
TBC

