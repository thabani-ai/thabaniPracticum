GitHub Link: https://github.com/thabani-ai/thabaniPracticum.git

BRIEF DESCRIPTION: 
                The application is a music playlist manager. The app stores song details and enable a user to manage the playlist with precision.


HOW THE APP WORKS:
                The application basically works by allowing a user to input certain song information, the application then creates a playlist with details of the song   
                including the name of the song, the name of the artist, the ratings and although optional, the users comments in regards to the song.
                Once all the songs have been entered the app displays all the songs (including all of its data (artist name, rating, comments). The app also calculate the
                average rating for all the songs entered and outputs it once the display average button is pressed. The first screen is mainly for the user to input the                      data, then the second screen is one that displays the data for the user. The average is calculated and it displays all the songs for the user

          ![source code](https://github.com/user-attachments/assets/06d9e00d-6e32-4597-92e1-91942a8e2e4a)


![Main Screen](https://github.com/user-attachments/assets/d9137f22-2670-4a9b-8dd5-9b09dd3fc356)

This is the apps main screen where the user is prompted to input the requird data

![Second Screen](https://github.com/user-attachments/assets/7f0c274c-c498-4479-be76-afa345016e54)

This is the second screen which the user can play around with, user can click the display songs button, which would ultimately result in all the songs that were
entered to be displayed, it also, as I mentioned above, calculates the average, in the screenshot below is how this app displays the information:

![Display screen](https://github.com/user-attachments/assets/6f42cd17-ed67-44dc-8603-81ef150b00dc)




![Error Hndling](https://github.com/user-attachments/assets/7bae36c6-8b29-4ba6-8837-45e4d2adc3b3)

 The screenshot above shows how I handled errors
 Checks to see if any of the input fields are empty. If empty it shows a toast message asking the user to fill all fields and exits the click listener early.

 The following line's purpose is to convert the rating (entered as a string) into an integer safely.

 If it’s not a number or ≤ 0: it shows a toast message asking for a valid rating greater than 0 and exits the listener



          
