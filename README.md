# ILoveMarshmallow
An app built as part of the 2015 Zappos Internship Challenge

### What does it do?
1. Accepts a search query from the user
2. Makes a request to the Zappos API using the search query
3. Parses the results of the search and displays them in a Endless RecyclerView
4. Opens a products page when a search result is selected
5. Product Pages can be shared via SMS, Facebook Messenger, Email, etc.
6. If the reciever has the app installed, the shared link opens the very same product page that was shared

### Screenshots
<img src=https://cloud.githubusercontent.com/assets/8221118/10032335/79e0323a-6150-11e5-9c30-b5cd2dad607a.png width="250"/>
<img src=https://cloud.githubusercontent.com/assets/8221118/10032337/7b37c4c2-6150-11e5-9692-9ce521a220fa.png width="250"/>
<img src=https://cloud.githubusercontent.com/assets/8221118/10032331/71534d50-6150-11e5-83b7-f3826a39867c.png width ="250"/>

#### Libraries Used
- **Material Desgin Components:** Android Design Support Library
- **View Binding:** ButterKnife
- CardView
- RecyclerView
- **API Request and Response handling:** Retrofit
- **Image Downloading and Sizing:** Picasso
