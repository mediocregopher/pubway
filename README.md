pubway
======

An easy way to do pub/sub with simple HTTP requests.

Usage
-----
Subscribing: `curl -d 'sub <subname>' <server address>:<port>`

Publishing: `curl -d 'pub <subname> <value>' <server address>:<port>`

(I have a sample server set up at http://cold-warrior-3505.herokuapp.com:80 if you want to play around with it)


Installation
------------
  
* If you're just a client, install curl. You're now done.
* If you're a server
  * Install [leiningen](https://github.com/technomancy/leiningen/) and [foreman](https://github.com/ddollar/foreman)
  * `git clone https://github.com/mediocregopher/pubway.git`
  * Edit `.env` to reflect the port you want pubway to run on
  * `foreman start`

Author
------
Brian Picciano

License
--------
[GPL3](http://www.gnu.org/licenses/gpl.html)