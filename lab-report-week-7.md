# Part 1
I decided to do this part from the last lab submission: 
> "In DocSearchServer.java, change the main method so that rather than hardcoding the search on the ./technical directory, it uses the second command-line argument for the path to search"

For this task, this is the sequence our group came up with:
` /main` → `<ENTER>` → `/cal` → `<ENTER>` → `5<right_arrow>` → `i` → `+args[1]` → `<ESC>` → `:wq + <Enter>`

![image1](Lab-Report-2-Pictures\Lab-7-Report-Pictures\Part1.png)

This is the first step where we find main by typing in normal mode. We type `/main` to find the main method.

![image2](Lab-Report-2-Pictures\Lab-7-Report-Pictures\EnterPart2.png)

Afterwards, press `<Enter>` in order to stay within the main file, otherwise the next step wouldn't find the correct area we want to change.

![image3](Lab-Report-2-Pictures\Lab-7-Report-Pictures\calPart3.png)

In this step, we type `/cal` to get to "technical", the area we want to change.

![image4](Lab-Report-2-Pictures\Lab-7-Report-Pictures\EnterPart4.png)

In this image, we once again press `<Enter>` in order to access the specifc area/line to prep for editing!

![image5](Lab-Report-2-Pictures\Lab-7-Report-Pictures\5rightArrow.png)

Here we press the `right arrow key` 5 times until our cursor is highlighting the first parentheses. We could use `e` here, but it only saves 1 stroke.

![image6](Lab-Report-2-Pictures\Lab-7-Report-Pictures\insertModePart6.png)

Finally comes the part where we edit! We press `i` to enter insert mode and begin to change the file!

![image7](Lab-Report-2-Pictures\Lab-7-Report-Pictures\plusArgs1Part7.png)

We then type `"+args"`, without the quotes, into the area. This allows us to add search for specific subdirectories based on the argument we provide!

![image8](Lab-Report-2-Pictures\Lab-7-Report-Pictures\escapeInsertModePart8.png)

Everything is wrapping up! We know press `<Escape>` to leave insert mode. This will take us to the final step!

![image9](Lab-Report-2-Pictures\Lab-7-Report-Pictures\saveAndQuitPart9.png)

This is the last step, where we type `wq` and then `<Enter>`. This step saves our work and quits VIM, taking us back to the command line! We are done editing the main file!

# Part 2

My test for being logged onto local took 35 seconds. Editing on VSCode was very easy and it didn't take long at all, however the saving and copying took time, as well as typing in the bash command.

My test for being logged onto remote took 28 seconds. I expected it to be a bit shorter and I was correct. This is because starting on remote removed the copying time. The reason it wasn't faster was becaue the extra commands for VIM took a lot longer to navigate.

Running VIM would probably be better on a remote environement. Even though I find VIM weird to use, it has a lot of advantages in the workplace. In this test, the file size wasn't an issue, but in a professional environemnt code will be tens of thousands of lines long. Making small changes and copying them over to the remote from local would exponentially increase the time it takes to get work done. Doing this on remote using VIM will cut that time drastically. 

