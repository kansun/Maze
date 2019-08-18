# Maze
This application demonstrates how to solve a Maze using the Breadth First Search algorithm. 

## To run
- Cd into the project root directory containing `pom.xml`; 
- Run `mvn clean compile`;
- Choose any of the following options: 
    - `java -cp target/classes maze.Main target/classes/demo.txt`: This will show the demo using an input file included. 
    - `java -cp target/classes maze.Main {any_path}`: This will show the demo using a file as specified in the argument. 
    - `java -cp target/classes maze.Main`: The application will ask for the path to the input file and use that for the demo.