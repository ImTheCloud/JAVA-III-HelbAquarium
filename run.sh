#!/bin/bash 

javac *.java
java Aquarium
find . -type f -name "*.class" -delete
