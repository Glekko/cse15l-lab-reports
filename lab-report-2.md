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

### Bug 1

The first bug I plan on discussing here is a relatively simple one. It was the reverseInPlace method in the ArrayExamples Class. When I first ran it, I used these inputs:
![reverseInPlace](Lab-Report-2-Pictures\ArrayTestScrnShot1.png)
and it returned this:
![reverseInPlace results](Lab-Report-2-Pictures\ArrayExamplesScrnShot1.png)

The reasons for this was very straightforward, but a very dangerous case. It failed because the code was written in a way that didn't track what variable it had replaced. So instead of reversing, you'd end up with an array with duplicate numbers because there wasn't a third variable to keep track of the changed variable. 

This was my solution:
![Fix1](Lab-Report-2-Pictures\ArrayFix1.png)
I created a third variable that keeps track of the current index value, and when the swap happens, if replaces the number that did the swapping with the number it swapped.


### Bug 2
The second bug was definitely a lot more tricky (at least to me). It's relatively easy to see something straightforward that needs to be changed. Missing a semicolon, wrong variable names, etc. While these may be extremely hard to find, once you do find them they're the easiest to fix. 

What about the bugs that are systematic? The ones where the program itself is written under flawed logic or lack of understanding? These are extremely hard to find, because if you're looking for an individual problem, you may end up ignoring that the rest of the body (program) is sick. 

For this bug, the goal was to compare a list with a certain string, check over the list to see if the string contained within the list, and if so, add the value at the index to a new list. Then when the program terminates, it will return a list with the given. 

Identifying failure-inducing inputs was hard in this case, becasue the errors mostly came I wasn't able to compile in the first place:

![ListError1](Lab-Report-2-Pictures\ListTests1.png)

As you can see, input2 wasn't allowing me to compile. Over the course of a day and a half I was stuck trying to figure this out. I'll tell you straight up front, there are many things wrong here and it took me a while to fix them one by one. Firstly, assertArrayEquals works on Arrays. This seems obvious but I couldn't understand that until a few hours ago. A simple fix for that changing assertArrayEquals to just assertEquals. This is because we're trying to pass in Lists, which aren't technically arrays.

The second issue was figuring out the correct way to pass in a StringChecker object, because ListExamples wanted a StringChecker as a parameter. This is why this was so hard for me. Interfaces weren't something I was super comfortable with, so understanding why I couldn't pass a StringChecker was weird for me. After a bit of research I learned that you can't actually create an object/class of StringChecker because Interfaces are Abstract. This led me to remembering in the summer session that interfaces, while they can't be used directly, can be passed indirectly through another class that has implemented the Interface. 

![StringChecker](Lab-Report-2-Pictures\stringCheckerPass.png)

I then created an empty list called myList and passed it through in order to access the checkString method! This was big, as it allowed me to finally figure out how to get the code actually running and produced:

![ListErrors1](Lab-Report-2-Pictures\ListTestsErrors.png) 

Well that's a problem... But at least we can deal with these one at a time. My first problem was that the ListExamples class I modified wanted a String object passed. I passed this, "s", thinking it worked for a string. Apparently it doesn't count, so I created a String object and set it equal to "s" and voila! 1 error down! 

Another error I solved after reading some documentation. Using the for-each version of a for loop doesn't keep track of indexes in arrays, so you can't manipulate an array through these. The add method kept trying to add to index 0, so it was a double error! First, For-each loops don't work on identifying indexes, and second, even if it did work, it'd just keep replacing the first element in the new arrayList with the newest element that matches the string!

![LinkError2](Lab-Report-2-Pictures\ListExamples2.png)

The final error was REALLY weird. It was basically saying that I had a duplicate StringChecker somewhere in my files. I checked ListExamples and ListTests and only found 1 version of StringChecker. What's going on here? 

Well it turns out that at the bottom, a completely new Java class called StringChecker was created. I don't even know how that happened because I don't recall creating any new files, but I just deleted the file and I had no more errors!

So after all this, I finally ran the program and it worked!

![ListExamplePass](Lab-Report-2-Pictures\ListExamplesTestPassed.png)

This is my code!

![ListTestCode](Lab-Report-2-Pictures\ListTestCode.png)

It took a long time for me to figure out just this little snipper, but I learned a lot while doing it! I think that's the best part of doing stuff like this, because we get a chance to mess around with things we haven't had much experience with in a hands-on manner. I haven't gotten anywhere close to finishing finding all the bugs, but I'll keep working on it and hopefully I'll find them all in the end. 







