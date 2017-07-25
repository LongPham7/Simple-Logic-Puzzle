# Simple-Logic-Puzzle

### Introduction
This application presents a logic puzzle from *The Art of Prolog* by Ehud
Shapiro and Leon Sterling. The puzzle is displayed on a GUI, which also has a
button that users can click to check the answer.

The solution to the puzzle is actually solved by running a Prolog script on a
Prolog engine, rather than being hard-coded into the program.

### How to run this application
To run this program, you first need to install a Prolog engine. The one I
currently use is SWI Prolog, which is available [here](http://www.swi-prolog.org/).
It is also necessary to add the home directory of Prolog to the PATH variable.
Make sure that you can invoke 'swipl' on your command-line tool.

Next, assuming that you use Eclipse (Java IDE) for execution, create a new Java
project containing all Java files and the Prolog script in this GitHub
repository. Then add the JAR file jpl.jar to the build path of the Java
project. This can be done by:
1. Right click on the project name in the package manager
2. Go to Build Path > Configure Build Path > Libraries
3. Click 'Add External JARs'
4. Select jpl.jar in the directory of Prolog. The JAR file usually resides in
the lib folder.

If the program cannot be executed properly, reboot Eclipse and run the program
again.
