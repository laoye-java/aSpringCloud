#!/bin/bash  
main_jar_name=aRegServer.jar
PID=$(ps -ef | grep $main_jar_name | grep -v grep | awk '{ print $2 }')  
if [ -z "$PID" ]  
then  
    echo $main_jar_name is already stopped  
else  
    echo $main_jar_name stop successs!
    kill -9 $PID  
fi
