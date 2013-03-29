MoskitoAndCDI-Example
=====================

This is an short example of how to integrate [Moskito](moskito.anotheria.net) within CDI.

Building
--------

On *nix execute `gradlew clean war`

On Windows execute `gradlew.bat clean war`

Deploying
---------

Start your application server and deploy the war.

Usage
-----

### Upload a document
For calculating the statistics for a document simply call
`curl -PUT "http://<HOST>/<context-root>/rest/document" -T <FILE> -v"

This will return an id for your document.

For example on your local machine you can use this

`curl -PUT "http://localhost:8080/MoskitoAndCDIExample/rest/document" -T build.gradle -v`


### Getting the complete statistics
For retrieving the whole statistics use this URL
`http://<HOST>/<context-root>/rest/document/<ID>`


### Getting the stastistics for one word
For getting the statistic for a single word use this URL
`http://<HOST>/<context-root>/rest/document/<ID>/<WORD>`
