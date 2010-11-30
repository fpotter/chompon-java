#!/bin/sh

OUR_CLASSPATH="bin"
for i in `ls ./*.jar`
do
  OUR_CLASSPATH=${OUR_CLASSPATH}:${i}
done

java -cp $OUR_CLASSPATH Main $*