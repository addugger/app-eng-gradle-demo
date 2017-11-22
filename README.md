## Progress Tracking
There's a Trello board where I'm keeping track of things I want to work on for this project. For anyone that may be reading this for whatever reason, at the moment this is all really just getting more experience with Google App Engine stuff.  I have some ideas knocking around in my head that I may eventually try out in App Engine.
https://trello.com/b/rj09Z99l/duggerapps

## Notes about getting skeleton project setup
Looks like there's known issue where the Java runtime consumes too much overhead, so the default machine resources are too small, and things get bogged down and the 502 issue can occur. This wasn't something I found in the docs, but instead on Stack Overflow. After specifying some extra resources in app.yaml, the app was definitely much peppier and I haven't gotten any 502's any more. Whoop whoop!
