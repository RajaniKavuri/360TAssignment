#### Overview

This project implements a Player Communication System where two players exchange messages following 
specific rules. The main goal is to have two players running in the same Java process and 
communicating with each other, ensuring proper message exchange and termination conditions.

## Prerequisites
- Java (JDK 17 or higher)
- Maven

### Windows (Command Prompt & IntelliJ)
1) Using Command Prompt
Generate the target folder and build the JAR file
Open the command prompt and run:
- mvn clean package -DskipTests


2) Run the application
   Execute the batch script: run.bat

This README explains:

# Project structure & responsibilities of each class

## How the implementation meets the assignment requirements

#### Classes & Their Responsibilities
1. SingleProcessMain.java (Main Class)
Purpose: This is the entry point of the application.

## Responsibilities:

Initializes two Player instances.
Starts the communication by making one player the initiator.
Manages the execution flow.
Ensures that the program terminates gracefully after 10 exchanges.

2. Player.java (Player Class)
Purpose: Represents an individual player who can send and receive messages.

## Responsibilities:

Stores the player’s name.
Sends a message with a counter (e.g., "Hello from Client [1]").
When receiving a message, it appends a counter and sends it back.
Keeps track of message history.

3. Server.java (Message Coordinator)
Purpose: Acts as a simple message broker between players.

## Responsibilities:

Receives messages from players.
Ensures the received message is forwarded to the correct recipient.
Maintains the message sequence to meet the assignment rules.

4. Client.java (Player Simulation)
Purpose: Simulates how a player behaves when sending and receiving messages.

## Responsibilities:

Starts communication with another player.
Logs received messages.
Sends back replies with concatenated message history.
Ensures the stop condition (10 messages exchanged) is met.

5. start.bat (Windows Run Script)
Purpose: Provides an easy way to start the application on Windows.

## Responsibilities:

Compiles and runs the Java application in a single command.
Ensures the classpath is correctly set.
Usage:
Run start.bat on Windows to execute the program.


#### How Did I Meet the Assignment Requirements?
Requirement	Implementation
1. Create 2 players	SingleProcessMain initializes two Player instances
2. Initiator sends first message	Client starts communication with "Hello from Client [1]"
3. Players respond by concatenating messages	Player appends "Reply to: " & adds message count
4. Stop after 10 messages exchanged	Counter in Client ensures termination after 10 exchanges
5. Both players in same Java process	Runs in a single process using threads (NO separate PIDs)
6. Document all classes	Each class has Javadoc comments explaining responsibilities
7. Opposite requirement (Separate PIDs)	Not implemented in this version, but can be done using Sockets
    All core requirements for Option 2 are met.
    Code is designed to be clear, maintainable, and minimal.

