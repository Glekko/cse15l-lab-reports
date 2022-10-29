# Command Line Research
For my command line choice, I chose to do 
> grep 

For the first command line option, I chose to do 
> grep -w

This grep command line option searches for the entry as a word instead of a colection of characters. For example, just using grep alone and "gov" as a string to find would result in this:
![regular grep](Lab-Report-2-Pictures\grep-regular.png)

As it's looking for the sequence of characters "g" followed by "o" followed by "v" in the files. The word "government" has all these so it works. 

The "-w" option takes the string and looks for it as a contained word. So instead of looking for anything containg "gov" it looks for an isolated word called "gov". 
![gov-can't-find](Lab-Report-2-Pictures\grep-w3.png)

See? It doesn't return anything because nothing in the text file contains the isolated word "gov". If we use the word "government", however...
![found-government](Lab-Report-2-Pictures\grep-w2.png)

Wow! It lists all the files that are in the text file witht he word "government" in them, because we specifically looked for it!

My second option is 
> grep -l 

Now this is a really cool command that prints out only the file names of files that CONTAIN the given string. For example:
![grepL1](Lab-Report-2-Pictures\grepLBio1.png)
This shows me using the string "bio" and the wildcard operator to find all the files in docsearch that contain "bio". This is really cool because it reminds me of the code we were supposed to modify in the skill demonstration.

This is what happens if nothing contains "tree" in the current directory. It doesn't find anything so it doesn't reutrn a result.
![grepNoResult](Lab-Report-2-Pictures\grepL2NoResult.png)

What's really interesting is what happens when I try something similar when I cd into /technical.  
![grepL3](Lab-Report-2-Pictures\grepL3WildCard.png)

This is REALLY cool! When I cd into the technical repository and double expand with the wildcard operator */*, it shows me all the files within all 4 repositories in technical that contain "tree". This could have a lot of applications when searching for specific keywords!

My final choice is
> grep -h

This is another pretty useful one that doesn't list the file name, but instead the lines that contain the string.

Here I triple expanded and found lines in files that contain the word "tree".
![grepH1](Lab-Report-2-Pictures\grepH1.png)


Another example below here is weird because grep -h isn't supposed to be showing file names, but here it is showing the file name with a ":" and showing the line that contains it. Perhaps it's because there's only a small amount of found words so it shows it?
![grepH2](Lab-Report-2-Pictures\grepH2.png)

Here's one for checking the string "URL":
![grepH3](Lab-Report-2-Pictures\grepH3URL.png)

This one's interesting as well because it actually looked into the java file for the matching string. This could have some practical implications for debugging, as well as could be how the Professor checks students' code.


