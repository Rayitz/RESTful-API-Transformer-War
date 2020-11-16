# RESTful-API-Transformer-War
CRUD Transformer and the transformers team that wins the war

How to build the Project and start the Project


Download Spring Tools 4 in eclipse IDE


Create a new project and select Spring Starter Project and press next
Set Window Information and press next
Select dependencies and press next
Press Finish to create the project


How to start the Project

Right click on your project and choose Run As --> Spring Boot App
In less than a minute the API is ready to be used


How to build and run the unit tests

I builded manually the unit test using restTemplate, the path of unit test is src/test/java

JSONS and parameters required are in methods of TransformerswarApplicationTests Class, you can change it in order to test the API!

To run it, Right click on the test that you want to run and choose Run As --> Junit Test

I set a log in each method to see the answer of each RESTful service


API endpoints


List Transformers

http://localhost:8080/transformer/list


Create a Transformer

http://localhost:8080/transformer/create

Body 
JSON data

{
    "name": "Optimus Prime",
    "type": "A",
    "strength": 1,
    "intelligence": 1,
    "speed": 1,
    "endurance": 1,
    "rank": 8,
    "courage": 1,
    "firepower": 1,
    "skill": 2
 }

Update a Transformer

http://localhost:8080/transformer/update

Body 
JSON data

{
  "id" : 1,
    "name": "Optimus Prime",
    "type": "A",
    "strength": 1,
    "intelligence": 1,
    "speed": 1,
    "endurance": 1,
    "rank": 8,
    "courage": 1,
    "firepower": 1,
    "skill": 2
 }


Delete a Transformer
 
Set {idTransformer} as Integer value

http://localhost:8080/transformer/delete/{idTransformer}


Given a list of Transformer IDs, determine the winning team	

http://localhost:8080/war

Body 
Json data
{
    "transformersForWar": [1,2,3,4,5,6,7,8,9,10,11]
}


Assumptions or notes to the reviewer

Remember first of all that you have to install maven and fill the settings.xml with a basic configuration like:

<proxies>
    <proxy>
      <id>...</id>
      <active>true</active>
      <protocol>http</protocol>
      <username>....</username>
      <password>....</password>
      <host>....</host>
      <port>....</port>
      <nonProxyHosts>local.net|some.host.com</nonProxyHosts>
    </proxy>
   </proxies>
   
   
   Enjoy the Transformers War!
