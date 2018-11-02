#!/bin/bash  

main_jar_name=aConfigServerRabbitMQ.jar

PID=`jps -l | grep $main_jar_name | awk '{print $1}'`

if [ $PID ]; then
	kill -9 $PID
fi

nohup java -jar $main_jar_name -server -Xmx150m -Xms150m -Xmn100m -XX:-PrintGC -XX:-PrintGCDetails -XX:-PrintGCTimeStamps -Xloggc:logs/gc.log &

PID=0
PID=`jps -l | grep $main_jar_name | awk '{print $1}'`

if [ $PID -ne 0 ]; then
  echo "(pid=$PID) [Start OK  $PID ]"
else
  echo "[Start Failed]"
fi

tailf nohup.out
