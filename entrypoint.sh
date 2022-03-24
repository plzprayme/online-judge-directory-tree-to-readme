#!/bin/sh

echo "::set-output name=result::$(java -jar /home/application.jar)"
echo "::set-output name=list::$(ls)"
echo "::set-output name=list2::$(ls /home)"
echo "::set-output name=cur::$(pwd)"