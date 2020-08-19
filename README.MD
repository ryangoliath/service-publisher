
# service-publisher

Publisher service which sends messages to a queue, validates and prints the formatted message sent to the queue. Also provides user input to exit the program.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

* Java 1.8
* Git
* Maven
* RabbitMQ

### Installing

1. Clone the project:
```
git clone https://github.com/ryangoliath/service-publisher.git
```
##
2. Build (Maven)
Running the following maven build command will generate a jar file called *service-publisher.jar* in a generated *target* directory. 
```
mvn install
```
##
3. (Optional) You are welcome to create an *app.properties* file in the directory of the *service-publisher.jar* to configure custom RabbitMQ connection properties. The default properties are:
```
app.rabbit.host: localhost
app.rabbit.port: 5672
app.rabbit.username: guest
app.rabbit.password: guest
```
Example file structure:
```
-rw-rw-r-- 1 ryan ryan     0 Aug 18 00:00 app.properties
-rw-rw-r-- 1 ryan ryan 18379 Aug 18 00:00 service-publisher.jar
```
##
4. Run
The maven build would have generated a jar file called *service-publisher.jar* in the *target* directory. Execute the jar using the standard jar exection command:
```
java -jar service-publisher.jar
```

## Built With

* [Eclipse](https://www.eclipse.org/) - The IDE used
* [Maven](https://maven.apache.org/) - Dependency Management
* [RabbitMQ](https://www.rabbitmq.com/) - Message Broker

## Author

* **Ryan Goliath** - [GoliathDev](http://goliathdev.com)

