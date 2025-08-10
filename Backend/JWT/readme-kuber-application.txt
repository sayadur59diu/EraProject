1.	Login to GitHub : Use yahoo id.
2.	Refer https://github.com/amirvenkat/spring-boot-demo
3	Open this project in Terminal
4.	git add, commit, push commands
5.	Go to GitHub browser again
6.	Deploy using GitHub runner which is configured to local.

DOCKER_HUB_USERNAME=amirvenkat
DOCKER_HUB_ACCESS_TOKEN=dckr_pat_aw95yYbao1eDZOQftOOh8fq1yqA

helm install kuberdemo ./helm/kuberdemo-chart


docker build -t kuberdemo:latest .   
   
docker run -p 8080:8080 kuberdemo:latest  (optional) 


docker tag kuberdemo:latest amirvenkat/kuberdemo:latest
docker push amirvenkat/kuberdemo:latest 


git add . 
git commit -m "commit v1"
git push origin main


git remote add origin url
git branch -M main
git push -u origin main
