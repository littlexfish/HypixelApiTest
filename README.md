# HypixelApiTest
Just a test for Hypixel skyblock api to get bazaar product and auction.

# Usage
You can just download it and add into your project or repository by "your hand".  
I know it's very troublesome, but the fact is so.

# Dependencies
I add some libraries and compile together, the libraries below:
 * Google Gson library
 * Apache HttpClient

# Document
    BazaarDecode bazaarDecode = new BazaarDecode(new BazaarReply(String apikey, ItemID itemid).execute());
ItemID is a enum in the library that you can get the item in Bazaar.  
You can get product through <code>bazaarDecode</code> and do any you want to do, like post to anywhere or save to other files etc.
