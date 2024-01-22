### QUiZ APP Monolithic Application  using Spring-Boot 4 with sts3 plugin and JAVA-17

Required softwares:</br>
JAVA</br>
STS4</br>
PostgreSql</br>
PgAdmin4</br>
Postman-API</br>
tomcat server 9+ in sts</br>

### Step By Step Process of How to Run the QuizApp

Steps:</br>
	1. Run the app using springboot (sts4 with sts3 plugin, maven, JavaSE-17) also download and install postman.</br>
	2. Check if postgreSQL (PostgreSQL 16.1) and pgAdmin 4 is installed and active (username- postgres, password- 9840, port- 5432)</br>
	3. Add a database called questiondb and create a table question with columns </br>
		(id-integer-not null-primarykey-Constraints:by Default:increment 1:Start 1)</br>
		(category-character varying-not null)</br>
		(difficultylevel-character varying-not null)</br>
		(option1-character varying)</br>
		(option2-character varying)</br>
		(option3-character varying)</br>
		(option4-character varying)</br>
		(question_title-character varying-not null)</br>
		(right_answer-character varying-not null)</br>
		or just import the questiontable.csv from extras to  questiondb this will add question table with some example data</br>
	4. Start postman and import quizapp api testing.postman_collection.json form extras to my Workspace.</br>
	5. In postman do CRUD operations, view all questions or questions by category</br>
	6. Create a quiz using the qiven parameters in URL of postman (numQ -> Total no of questions needed in the quiz) (quizId will be returned)</br>
	7. Start the quiz using the quizid .</br>
	8. Submit your answers with quizid in the url and the questionsid and response as the answers in the body (RAW format-JSON) (already template available in postman post method)</br>
	9.final result score will be calculated and send to the user in postman (score data is not stored in the db).</br>

	Note:-
		lombok is not working so the required sources is already added.
		Postman API file to run operations in quiz is attached in json format.
		PostgreSQL questions table, csv is also available in extras. Just import it in questiondb to create question table.
		any extra needed files are available in extras.
  **
		If there is any issues of queries you can contact me through my linkdin or my website : http://tharuntech.netlify.app
		
