# Project Wild Life Tracker
### Description
An application that allows a user to store and retrieve information about wild animals such as animal name animal 
sightings and weather or not they are endangered and the state of their health
### BDD
|feature     |Description      |
|------------|------------------
|Show animals | Show list of animals that have been spotted|
|Add animals to database|use form to input animal data to database|
|Show sightings|Show information about animal sightings|
|Add Sightings to database|Display Sightings|
|Add endagered animals|Display endangered animals|
### AUTHOR
* Joel Mukono
### Technologies used 
* Java (Spark)
* Git for version control
* Heroku for hosting
* Postgresql Database
* html
*bootstrap
### setup
- Download Java Development kit 11.0.5 Previous or later versions may
- have some minimal compatibility issue. Gradle is the tool used to 
- build and run the code. Preferred IDE is IntelliJ IDEA.
- In PSQL:
- CREATE DATABASE wild_life_tracker;
- CREATE TABLE animals (id serial PRIMARY KEY, name varchar, createdAt timestamp);
- CREATE TABLE endangered (id serial PRIMARY KEY, name varchar, health varchar,created timestamp );
- CREATE TABLE sightings (id serial PRIMARY KEY, rangername varchar,created timestamp );

## fork repo
- Fork repository
- Create new branch
- Make the proposal
- commit the changes with appropriate message on changes and push
- Create a pull request
## License
MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
