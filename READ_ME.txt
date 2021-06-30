# Blockchain in health records confidentiality

Group 36	2018AAPS0398H	Siddharth Raj
                2018AAPS0374H	Prateek Sinha
                2018AAPS0488H	Mehul Chandwani
                2018A4PS0647H	Ayan Patel

-->We have two kinds of Users - Doctors and Patients
-->A transaction involves a doctor and a patient
-->For simplicity we have implemented zero knowledge proof for only patients
-->All the keywords, usernames used are case sensitive
-->Initially blockchain is empty
-->Atleast one patient has to be registered before adding or viewing a transaction
-->Operations should be performed in the following order (initially):
		register-->add-->view

If using a java ide, go to src and run

If using terminal to run then change directory to its src:
To compile use: javac users.java StringUtil.java Record.java Block.java Main.java DES.java
To run use    : java Main

options displayed: add/view/register
	// atleast 1 patient's details need to be registered for further process

        enter-register
	/* Enter patient's name
   	Enter patient's password 
	-->Password should be an INTEGER only and preferably a small integer as it is used in calculations of ZKP
   	Verify patient's password
   	sample i/p-
   	sahil
   	2
   	2
	*/

	// details added successfully

enter-yes //to continue

options displayed: add/view/register

	enter-add
	// to add medical details/reports

	"Enter doc name"

/*
for simplicity we have predefined 4 doctors in the database-

doc1:
name:Shaan
password:111

doc2:
name:Shivam
password:112

doc3:
name:Suraj
password:113

doc4:
name:Sam
password:114
*/

	enter details of doctor
	/*
	example-
	Shaan
	111 */

	enter the deatils of the patient he checked
	/*
	sahil
	*/
	
	Zero Knowledge Proof to verify user:
	-->Here x is the password of the user
	-->Pick up a random number between 0 and 9
	-->Calculate h (h=(2^r)(mod 11)) and enter h
	-->A random-bit b(0/1) is generated
	-->Compute s=(r+b*x)mod(10) and enter s

	/*
	Kindly verify yourself as a user
	Zero Knowledge Proof
	Choose a random number between 0 and 9
	Please compute h=(2^r)(mod 11) and Enter h
	2
	h is 2
	Random bit is 0
	Please compute s=(r+b*x)mod(10).Here x is the number you are proving you know
	1
	Zero Knowledge Proof Successful.You are verified as registered user
	*/

	enter-y // to input the reports, medical records,prescription etc.
	/*
	example-
	'y'
	BP 150/95
	'y'
	Blood Sugar Level(fasting) 121
	'y'
	Next checkup scheduled on 07/05/2020
	*/

	enter-n //once the entire data is entered

// Block Mined Successfully and block hash is displyed

	/*
	Trying To mineBlock...
        Mining Block....
        Block Mined!!! : 3A65272C87AF31E5DC3BD9D4026700AB409A8815CD6D71EF34A8386876C0C4AE
	*/


enter-yes // to continue

options displayed: add/view/register

	enter-view //to view several records 

	enter-d or p

	/*
	'd' if you wish to know the details/records of several patients checked by a doctor
	'p' if you wish to fetch the details/records of patient's check-up history
	*/
	if d is selected
		enter required details of doctor
	if p is selected
		//ZKP verification is done similar to the one explained in 'add' option
	
	record blocks are displayed along with TimeStap at which the data was recorded


SAMPLE RUN-

/*
(view/add/register)register

sahil
2
2

(continue?)yes

(view/add/register)add

Suraj
113 

sahil

Kindly verify yourself as a user
Zero Knowledge Proof
Choose a random number between 0 and 9
Please compute h=(2^r)(mod 11) and Enter h
2
h is 2
Random bit is 0
Please compute s=(r+b*x)mod(10).Here x is the number you are proving you know
1
Zero Knowledge Proof Successful.You are verified as registered user

y
BP 150/95

y
Blood Sugar Level(fasting) 121

y
Next checkup scheduled on 07/05/2020

n

output-
Trying To mineBlock...
Mining Block....
Block Mined!!! : 3A65272C87AF31E5DC3BD9D4026700AB409A8815CD6D71EF34A8386876C0C4AE

(continue?)yes

(view/add/register)view

'd'
Suraj
113

output-
Showing details
TimeStamp at which data  was recorded:1618499050443
Doctor details
Doctor name:Suraj
Patient details
Patient name:sahil
Medical Data of this patient:
BP 150/95
Blood Sugar Level(fasting) 121
Next checkup scheduled on 07/05/2020

(continue?)yes

similarly for patient-

'p'
sahil

Kindly verify yourself as a user
Zero Knowledge Proof
Choose a random number between 0 and 9
Please compute h=(2^r)(mod 11) and Enter h
4
h is 4
Random bit is 1
Please compute s=(r+b*x)mod(10).Here x is the number you are proving you know
4
Zero Knowledge Proof Successful.You are verified as registered user

output-
Time:1618499050443
Doctor:Suraj
Patient:sahil
Patient's Medical Data:
BP 150/95
Blood Sugar Level(fasting) 121
Next checkup scheduled on 07/05/2020

other blocks are added similarly!!

*/

Note: Some variables like temp1,temp2,...etc. and some function like fun_testing() are used for testing and debugging purposes.
