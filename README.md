Spring Boot implementation of polling application I already made with NodeJS here:

https://github.com/kle-pra/polls-node

App enables registration/login. As a logged-in user you can create, list and delete your own polls. Anonymous users can vote and see results of polls. You can see results in a simple chart (can be improved).


Installation:
---

To run, build backend & angular frontend; frontend files are copied to over to static folder with npm scripts, which is served by Spring.


- cd frontend
- npm install
- npm run build
- cd ..
- mvn package
- java -jar target/polls-0.0.1-SNAPSHOT.jar

