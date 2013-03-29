MoskitoAndCDI-Example
=====================

This is an short example of how to integrate [Moskito](moskito.anotheria.net) within CDI.

Building
--------
On *nix execute gradlew clean war
On Windows execute gradlew.bat clean war

Deploying
---------
Start your application server and deploy the war.

Usage
-----
For calculating the statistics for a document simply call
curl -PUT "<HOST>/<context-root>/rest/document" -d PATH_TO_FILE

For retrieving the whole statistics use
<HOST>/<context-root>/rest/document/<ID>

For getting the statistic for a single word use
<HOST>/<context-root>/rest/document/<ID>/<WORD>
