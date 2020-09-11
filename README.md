This is a simple selenium grid docker test.

Here are the steps to setup the docker containers...

	docker pull selenium/hub  
	docker run -d -p 4545:4444 --name selenium-hub selenium/hub  
	docker pull selenium/node-firefox-debug    
	docker run -d --link selenium-hub:hub selenium/node-firefox     

Verify by going here...  
http://localhost:4545/grid/console  
You should see a firefox node.  

Then you can just run the test :)