# N26
N26 home test

Summary:
This application written in Spring exposes two APIs. The main purpose of the application is to get the Statistics in O(1) complexity.

Implementation details:
A singleton Statistic object is implemented and used as data store to achieve the purpose. 

POST /transactions
{
"amount" : 12.3,
"timestamp": 1506264803553
}

Returns:
Empty response,
Status: 
201, if transaction is inserted.
204, if transaction is older than 60 seconds

Assumptions:
0) Every transaction will have a timeout of 60 seconds from it's requestTimestamp in the in-memory Singleton Statistic Object.
1) If the transaction timestamp is older than 60 seconds of current timestamp, no insertion is made to the in-memory Singleton Statistic Object.
2) If the transaction timestamp is within 60 seconds from current timestamp, Insertion is made immediately to Singleton object and deletion is made post timeout of the transaction.
3) If the transaction timestamp is greater than 60 seconds from current timestamp, Insertion will be made at the UTC timestamp value equals to the requestTimestamp and Deletion timeout is set to 60 seconds. 

GET /statistics
Returns:
{
"sum": 1000,
"avg": 100,
"max": 200,
"min": 50,
"count": 10
}

Status:
200 OK

This is O(1) space and time complexity, which gets the data from the POJO of Singleton Statistic object

Assumptions:
1) Default values of sum, avg, max, count are 0.
2) Default value of min is set to Double.MAX_VALUE.

Prerequisites: 
Install Java, Maven and set appropriate environment variables.

Build:
mvn clean install

Run:
java -jar target/hometest-N26.jar


