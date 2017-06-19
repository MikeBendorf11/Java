## JAVA ORIGINS ##

------------
	Monday, June 19, 2017

------------

- Finished reviewing this useful [resource](https://www.protechtraining.com/bookshelf/java_fundamentals_tutorial/object_oriented?ncr=1) and created some projects to refresh my mind of some of the most important OOP concepts. 
- Created a Codenvy workspace, practiced basic linux cmds, reviewed concepts such as classpath, sourcepath and used java and javax cmds to launch apps from CLI
- Learned how to transform applets into runable jars

**About Codenvy:**

Since I reorganized my learning programs in packages, launching an application from Codenvy CLI requires a different use of the commands java and javac without having to set up a classpath and sourcepath. 

The command to launch looks like this:

	cd /projects/JavaLearning/bOOP/AfollowsTheObj
	javac *.java
	java AEmployeeDemo AfollowsTheObj.AEmployee

Next step will be to find out how to view JAR files or applets only by using cloud resources. 


[Check out more entries...](https://github.com/MikeBendorf11/JavaLearning/wiki "JavaLearning/wiki")

------------------------------------


#### Relevant assignments from 2015 ####

**JumpingSquare.java:** A game where you have to chase a tiny square around the screen. Everytime you click it you earn points but it becomes harder to catch. 

**wordExtractor.java:** *400 width x 200 height*. For a given text, the program displays the number of lines, words and characters used.
>Some of the troubleshooting done here involved reviewing the associative rules of Boolean algebra so I could add several conditionals for the word counter.

**BlackjackGUI.java:** *600 width x 350 height*. The applet implements the 8 winning scenarios and a messaging system that displays the winner for each case. There are a total of 8 winning scenarios: *5 for the dealer and 3 for the player*. 
>I divided the playing field into 2 JPanels, one that contains the game data and another for dealing the cards. These panels refresh independently based on the game progress data. The game continues as long as you have money left.