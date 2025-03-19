# NASA-APOD-BOT
## What does it do?
It connected with *Nasa APOD server* (astronomic picture of the day).

For if I used telegram API, jackson to work with .json files and httpclient to sent requests to server.

## How to use it on my computer?
1. Open telegram and find the BotFather bot (@BotFather), where you'll be able to create your bot

Create new bot, and remember username of it

Put this username into Main.java in the brackets of initialisation NasaBot class (botUserName)

2. After visit NASA API web cite (https://api.nasa.gov/), register, and then you'll get the token on your email address

Put this token into Main.java in the brackets of initialisation NasaBot class (botToken)

3. Run Main.java and use commands

   1. /start
   2. /help - to get more info
   3. /image - to get the astronomic picture of today's day
   4. /date YYYY-MM_DD - to get astronomic picture of any day you want (hint to date format YYYY-MM-DD means suppose 2006-04-16 - April sixteenth 2004 )
