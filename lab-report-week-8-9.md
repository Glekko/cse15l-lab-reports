# Lab Report 5
Here is my code for the grading script!

```
# Create your grading script here
CPATH=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
rm -rf student-submission
git clone $1 student-submission
cp TestListExamples.java student-submission
cd student-submission
SCORE=0
if [ -e "ListExamples.java" ]
then
    echo "Correct file! Well done!"
    echo "1 out of 3 points achieved!"
    ((SCORE++))
else
    echo "Wrong file submission!"
    echo "Will remain a" $SCORE"/3 unless you resubmit with correct file name."
    exit
fi
javac -cp $CPATH *.java
if [ $? -ne 0 ]
then
    echo "File did not compile!"
    echo "Will remain a" $SCORE"/3 unless you resubmit fixing compilation error."
    exit
else
    echo "File successfully compiled!"
    echo "2 out of 3 points achieved!"
    ((SCORE++))
fi
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples &> testOutput.txt
if [ $? -eq 0 ]
then
    echo "Tests passed!"
    ((SCORE=SCORE+1))
    echo "Full " $SCORE"/3 points achieved!"
    cat testOutput.txt
    exit
else
    echo "File failed to pass test"
    echo "Will remain " $SCORE"/3 points until all tests are passed"
    cat testOutput.txt
fi
```

First screenshot: List Methods Corrected!
![ListCorrected](Lab-Report-2-Pictures\ListMethodsCorrectedBrowserOutput.png)

Second Screenshot: List Methods Compile Error!
![CompileError](Lab-Report-2-Pictures\ListMethodsCompileErrorOutput.png)

Third screenshot: List Methods Wrong File Name!
![WrongFileName](Lab-Report-2-Pictures\WrongFileNameBrowserOutput.png)

So for my trace, I chose List Methods Wrong File Name!. Starting with `rm -rf student-submission`, it had a return code of 0 with no standard output or input. This happens with commands like `cp`, `cd`, `rm`, `cp`, and `echo` because. I used `-v` command line option to see what's going on and got this for standard output:
```
removed 'student-submission/.git/info/exclude'
removed directory: 'student-submission/.git/info'
removed 'student-submission/.git/hooks/commit-msg.sample'
removed 'student-submission/.git/hooks/prepare-commit-msg.sample'
removed 'student-submission/.git/hooks/update.sample'
removed 'student-submission/.git/hooks/pre-rebase.sample'
removed 'student-submission/.git/hooks/pre-merge-commit.sample'
removed 'student-submission/.git/hooks/push-to-checkout.sample'
removed 'student-submission/.git/hooks/pre-push.sample'
removed 'student-submission/.git/hooks/pre-commit.sample'
removed 'student-submission/.git/hooks/post-update.sample'
removed 'student-submission/.git/hooks/pre-receive.sample'
removed 'student-submission/.git/hooks/applypatch-msg.sample'
removed 'student-submission/.git/hooks/fsmonitor-watchman.sample'
removed 'student-submission/.git/hooks/pre-applypatch.sample'
removed directory: 'student-submission/.git/hooks'
removed directory: 'student-submission/.git/branches'
removed 'student-submission/.git/description'
removed 'student-submission/.git/refs/heads/main'
removed directory: 'student-submission/.git/refs/heads'
removed directory: 'student-submission/.git/refs/tags'
removed 'student-submission/.git/refs/remotes/origin/HEAD'
removed directory: 'student-submission/.git/refs/remotes/origin'
removed directory: 'student-submission/.git/refs/remotes'
removed directory: 'student-submission/.git/refs'
removed 'student-submission/.git/objects/pack/pack-2b7d04cc815c5d3dc73ede6ddc4ecddd8af69bea.pack'
removed 'student-submission/.git/objects/pack/pack-2b7d04cc815c5d3dc73ede6ddc4ecddd8af69bea.idx'
removed directory: 'student-submission/.git/objects/pack'
removed directory: 'student-submission/.git/objects/info'
removed directory: 'student-submission/.git/objects'
removed 'student-submission/.git/HEAD'
removed 'student-submission/.git/config'
removed 'student-submission/.git/logs/refs/remotes/origin/HEAD'
removed directory: 'student-submission/.git/logs/refs/remotes/origin'
removed directory: 'student-submission/.git/logs/refs/remotes'
removed 'student-submission/.git/logs/refs/heads/main'
removed directory: 'student-submission/.git/logs/refs/heads'
removed directory: 'student-submission/.git/logs/refs'
removed 'student-submission/.git/logs/HEAD'
removed directory: 'student-submission/.git/logs'
removed 'student-submission/.git/packed-refs'
removed 'student-submission/.git/index'
removed directory: 'student-submission/.git'
removed 'student-submission/ListMethods.java'
removed 'student-submission/TestListExamples.java'
removed directory: 'student-submission'
```

This is a lot of things being removed. This happened because I had previous files saved in student-submission, so it removed them to make way for the next submission.

The next command that happened was 

`git clone $1 student-submission >gitCloneOut 2> gitCloneErr.txt` 

which returned this in STANDARD ERROR, not OUTPUT:
```
Cloning into 'student-submission'... 
```
Apparently git clone ALWAYS prints to standard error, so it's not an accurate measure to use the existance of a standard error or output file as a measure of success. We must look at the exit code, which in this case was 0 as well.

The next command after that was 

`cp -v TestListExamples.java student-submission > cpOut.txt 2> cpErr.txt`

Here also had an exit code of 0, with a standard output of 

```
'TestListExamples.java' -> 'student-submission/TestListExamples.java'
```

After that was the cd command, which also had an exit code of 0. The problem here was that `-v` didn't work on this and I couldn't figure out a way to print out it's standard output/error. One of the answers on this forum: [StackExchange cd](https://unix.stackexchange.com/questions/259972/why-does-the-cd-command-handle-stdin-different-than-other-commands#:~:text=The%20cd%20command%20is%20similar,cases%20like%20when%20using%20CDPATH%20.)
says that commands like cd don't generally print to standard output. 

After this was the if statement:

`if [ -e "ListExamples.java" ]`

which checks for the existance of ListExamples.java. This if statement fails because the file submitted had an incorrect name, which causes this check to fail since it's not detecting exactly "ListExamples.java". This check returns with an error code of 1 because it does NOT exist. The `then` branch doesn't run because the `if` statement didn't pass.

Every command after this `if` statement doesn't run because of the early exit. 