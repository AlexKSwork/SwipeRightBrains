# SwipeRightBrains

University Project for Brain Scientists to create public app which to identify good and bad scans of a brain
By Jack Light, Calum Mcalinden, Alex Sibanda, Evgeniy Tonchev

To run the project
Master Branch is before the fixes to the project
Cybersecurityimpl is after the fixes have been implemented

 - Download or Clone http Gitlab link
 - Gitcheckout on Cybersecurityimpl for changes
 - Then create your MySQL database, you will need the host, database name, username, and password to access this.
 - In the application.properties you will need to add this information (URL contains the host and database name)
 - On this database you will need to run schema.sql, remove_user_ratings.sql and trigger_user_deleted.sql located in the resources/sql directory
 - Ensure there is a directory in the root of the project called brain_images that contains insert_images.py. (You will need to add database credentials to this script)*
 - Skip Step //Run the jar and navigate to localhost:8080 and you will land on the home page
 - Run the secure project on https://localhost:8443/
 - Register
 - Login
  
 Example
 ````
 * The script must be run inside the brain_images directory, within this directory you will need to have 3 folders (top, side, front). In each of these folders you need to have the same number of images and with the same name.
  
 brain_images/
            insert_images.py
            top/
                image1.jpg
                image2.jpg
            front/
                image1.jpg
                image2.jpg
            side/
                image1.jpg
                image2.jpg
            
               
               
 This will insert image1.jpg and image2.jpg into your scans
````