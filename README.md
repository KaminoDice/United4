# La/u/ncher 4.2.3

### Try it in your browser!
Resize your browser to be phone-sized and visit https://niles.xyz/united

### Try it on your phone!
https://github.com/nilesr/United4/releases/tag/4.2.3

Direct link: https://niles.xyz/uapp-4.2.3.apk

<a href="https://f-droid.org/packages/com.angryburg.uapp/" target="_blank">
<img src="https://f-droid.org/badge/get-it-on.png" alt="Get it on F-Droid" height="80"/></a>
<a href="https://play.google.com/store/apps/details?id=com.angryburg.uapp" target="_blank">
<img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" alt="Get it on Google Play" height="80"/></a>

## Known bugs

 - ~~Changing the bar color won't take full effect until all UserscriptActivity instances are destroyed (i.e. rotating the screen or restarting the app)~~ Fixed in 4.1.5
 - Creating a new thread, then going to the thread watcher and unwatching it, then replying to the thread with "Watch thread on reply disabled" will watch the thread again because ?watch is still in the URL
 - ~~Creating a new thread sometimes leads to negative "new post" values in the thread watcher~~ Should be fixed in 4.2.2, never could quite reproduce this accurately
 - Reportedly cannot be uninstalled on a zenfone max first series

## todo list
- music
	- song select has a sound too
	- #buttons > img have click sounds too

# License

La/u/ncher is released under the GPLv3
