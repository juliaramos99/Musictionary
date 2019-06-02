# Musictionary

**Musictionary** is a musical artist information application I developed as a final project for a course called Programming Concepts and Methodology II.
 This application will take a musical artist name as input and display the artist’s information retrieved from [TheAudioDB](https://www.theaudiodb.com/).

The final project uses the [Model-View-Controller (MVC)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) architectural pattern.
I use JUnit to test my application and JSON to retrieve data from the database.

## Files

The files inside this repository are:
* **MusicView.fxml** - View for project
* **MusicController.java** - Controller for project
* **MusicModel.java** - Contains public static void main to start the application
* **MusicModelTest.java** - JUnit tests for MusicMode.java
* **MusicMain.java** - Main program to run the application
* **badartistname.png** - Image displayed if an invalid musical artist name is found
* **gson-2.2.4.jar** - Required to parse JSON code returned
* **hamcrest-core-1.3.jar** - Required to run JUnit tests
* **junit-4.12.jar** - Required to run JUnit tests
* **README.md** - README file with details of this repository

## Getting Started

Make sure all files are in the same directory. Configure the gson-2.2.4.jar, hamcrest-core-1.3.jar, junit-4.12.jar files.
Compile the .java files and run the MusicModelTest.java application to ensure the application is working properly.

## Operation

Run the MusicMain.java file and the interface for the application should appear. Enter a valid musical artist name in the name field and click on the Search! button.
The musical artist's information will be displayed. An invalid or empty name field will display an error message.

## Authors

* **Timothy McGowen (Professor)** - *Provided framework for JSON data retrieval*
* **Julia Beatriz Ramos (Me!)** - *Implemented the code*
