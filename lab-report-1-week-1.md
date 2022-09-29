Hello! I'm here to teach you how to log on to a course specific **ieng6** account!


# Step 1: Installing VScode

The first thing you need to do to make this easy is to install [VScode](https://code.visualstudio.com/download) onto your computer. Once you install it, run VScode and it should look something like this! 

![Screenshot (154)](https://user-images.githubusercontent.com/114199299/193157461-38de3d70-78b9-4cd6-966b-f4c26707d163.png)

Don't be alarmed if you don't have these shown files, as I already have VScode installed and these are files I made afterwards. 


# Step 2: Remotely Connecting
Great job! Now that you're on to step 2, we can get to remotely connecting to your **ieng6** account. 

If on Windows, you must have [OpenSSH](https://docs.microsoft.com/en-us/windows-server/administration/openssh/openssh_install_firstuse) installed. Once done, we go back to VScode and use the command:

Control + ` to open a new terminal.
Then we run this command:
>$ `ssh cs15lfa22xx@ieng6.ucsd.edu`

The 'xx' is your own unique characters in your ieng6 account. 

Once you do that, press ENTER and follow the commands and you should see something like this on your screen:
![Screenshot (156)](https://user-images.githubusercontent.com/114199299/193158588-41c9b09a-0b43-4202-afa8-e56230ddb5ba.png)


Congrats! You are now logged into your ieng6 server!

# Step 3: Trying some commands

Next, you should try messing around with some of the directory commands you've learned such as
>`cd` 

>`mkdir`

>`ls`

>`cat`

>`..`

>`~/`

> `pwd`

> `cp`

It CAN not SHOULD look something like this:

![Screenshot (159)](https://user-images.githubusercontent.com/114199299/193158975-369995da-0b17-4b20-9137-d9f40eaf1cf1.png)

# Step 4: Moving Files with `scp`
With this, we can connext to different computers and do things like copy files over.

Use:

>`scp [fileName].[ext] cs15lfa22xx@ieng6.ucsd.edu:~/` 

This sends whatever file you send into your home directory.

Here's an example of copying and running a java file on the new server.

![Screenshot (160)](https://user-images.githubusercontent.com/114199299/193159472-b6f544d3-3f72-4f9a-b3d2-e4ff6d729aa3.png)

# Step 5: SSH Keys
Entering a password everytime we log in to our **ieng6** account is annoying, so lets use SSH keys to speed up the process!

Run(on your own computer)
>`ssh keygen`

After this loads, just press ENTER twice. You've now loaded your custom SSH public and private keys! 

Now we must copy the SSH public key to the server .ssh directory.

> On laptop/PC: `$ ssh cs15fa22xx@ieng6@ucsd.edu`

and enter your password.

Now: 
>`$ mkdir .ssh`

and then CONTROL + D to logout.

Now again on laptop/PC: 
>`scp /Users/[name]/.ssh/id_rsa.pub cs15lfa22@ieng6.ucsd.edu:~/.ssh/authorized_keys`

You have now copied your public key over and can login without a password!

![Screenshot (161)](https://user-images.githubusercontent.com/114199299/193160092-9f0a8338-34d0-41fe-a4f9-8f66b8c6a796.png)

# Step 6: Optimize Remote Running



