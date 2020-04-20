Video Link: https://www.youtube.com/watch?v=oUFTBnDg3jI


This program is a machine learning program used to determine whether or not a person has the Coronaviurs.
This program uses a Naive Bayes classifier to determine if a patient has the virus. There are 7 classes in the program:
FileProcessing, PatientInfo, Probability, TestAccuracy, GUI and CoronaCheck.


FileProcessing - This class is used to obtain the information from the entered file. This is done by an ArrayList which creates a PatientInfo object
The class has 2 methods, openFile() and readFile(). The openFile method sets the file that the readFile reads from. The readFile method goes through the file 
line by line and adds each line to an array symptom. Then an array list of patient objects is created from symptom.


PatientInfo - This class contains the same variables and attributes that the file has in order to create a patient with the same information as the file.
The class requires strings temperature, aches, sore throat, travel from danger zone and has covid19 to be passed through it
 

Probability - This class counts the amount of times each symptom appears and adds it to a variable. Then, the probability of having each symptom with COVID19
and without COVID19 is calculated. This is then used to predict whether or not a person has the Coronavirus. The class has 2 methods count and findProb.
Count is used to count how many times different variations of the symptoms appear in the file. findProb is used to find the probability of the patient having
each symptom if they have COVID19 and if they don't. The probability of the patient having COVID19 is then calculated


TestAccuracy - This class is used to test the accuracy of the program. This is done by splitting the file into a 70/30 split. This program is trained by the 70% and
then it is tested on the 30%. The amount of right answers are recorded and the accuracy is calculated. This class has one method findAccuracy. This method splits
the data into two array lists one with 30% of the data and the other with 70% then the count method from Probability is used to train the program on 70% of the data
the findProb method is used to test the data on the 30%. The accuracy is then calculated and displayed


GUI - This is the home screen of the program. The user uses this window to navegate around the program and utilize its various features. The features include
Testing a patient for COVID19, testing the accuracy of the file and choosing a file


CoronaCheck - This is the window where the user enters the patients symptoms into the program. The probability of the patient having the coronavirus
is the displayed on the screen. This screen uses radio buttons to pass the information into the methods that calculate the probability of the patient having
the virus



 I had more time to do the project I would focus on the Probability class, the UI classes and error checking.
I would try make the Probability class more efficient as there is a lot of lines of code that could hopefully be done more efficiently.
I would make the UI's look better and add in logos and icons to help with the mapping of the program. I would also look at adding functionality
where the user can directly add a patient which already knows if they have the virus into the system so that the program's data set is increased.
The error checking in the program could be better and more error checking could be added, with more time I would add more error checking 

