#!/bin/sh

echo "::set-output name=result::$(java -jar /home/application.jar)"

git config --global user.email "README-BOT@bot.com"
git config --global user.name "README-BOT"
git add README.md && git commit -m "Generate auto formatted README"
git push