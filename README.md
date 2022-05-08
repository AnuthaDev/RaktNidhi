# Rakt Nidhi

More than 12000 people die daily in India alone due to the lack of availability of blood, our project aims to reduce this number by taking multiple steps:

Stage 1:
- Build a platform that connects the people in need of blood to voluntary blood donors
- Preserve the privacy of donors, unlike most platforms in existence
- Facilitate the process of blood donation by notifying users of upcoming camps and allowing them to book appointments
- Incentivize and promote the cause of blood donation

Stage 2:
- Connect with NGOs and Charitable Blood Banks
- Ease the communication between the kin of patients and blood banks
- Improve inter-bank cooperation by integrating their inventory systems in our project, this will allow us to notify prospective donors if the bank near them is facing a shortage
- Implement a donor card facility that will allow a donor to receive blood in future if it is needed without the need for replacement donation

Stage 3:
- Integrate hospitals into our system
- Streamline the process from the request of blood to the transfusion by using the synergies of our network
- Improve the incentives of blood donation, and form a community of our own


## About the prototype:

Our team is fairly new to Android, so it took us a little longer to come up with the basic parts of our prototype.

It uses firebase authentication for user login and firebase realtime databse to store user data

It is built using kotlin and xml layout files

## Brief Description of code:

- `MainActivity`: The Activity where the app starts and checks for user login

- `HomeActivity`: The default activity for a logged in user/ dashboard

- `DonorIDActivity`: The Activity that shows the user their blood donor card info

- `NearbyReqActivity`: The Activity that shows the user nearby blood donation requests, though its data is harcoded for our prototype

This project is FOSS and licensed under the GPLv3