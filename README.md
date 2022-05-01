# TrademeWeb:-
This repository contains the test automation code to test the TradeMe web application. 

## About Project:-
Part1:TradeMeWeb UI Test
Using the TradeMe web site write automation code which does the following:
1) Search an Existing Used Car listing with any relevant details like Keyword, Make, Model, 	Body Style etc.
2) Confirm that the following details are shown for that car
	a) Number plate
	b) Kilometers
	c) Body
	d) Seats

3) Confirm that above values always match with input test data

Project built with Cucumber BDD framework using Selenium and Java.

## Tools used:-
IntelliJ Commnuity Edition
Cucumber
JDK 18
Apache Maven 3.8.5

## Installation
Clone the repo:
https://github.com/vipinmisra/TrademeWeb.git

## Instructions:-

Open a command-prompt:- 
Navigate to project directory where you would find src , pom.xml etc.

Run the below  execution command:-
mvn clean test

For execution in Edge please use which is also default browser:-
mvn clean test  -Dbrowser=edge
For execution in FireFox please use which is also default browser:-
mvn clean test  -Dbrowser=firefox

## Test Results:-
Execution reports are generated under ./target directory under project root directory.

