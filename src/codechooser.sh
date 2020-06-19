#!/usr/bin/env bash
declare -A AvailableCode
AvailableCode=( [Hello World]=exercises.HelloWorld
                [Alice]=exercises.Alice
                [Miles Per Gallon]=exercises.MilesPerGallon
                [Rectangle]=exercises.Rectangle
                [Area Of A Circle]=org.launch.java.studios.areaofacircle.Area ) 

INDEX=1;
for KEY in "${!AvailableCode[@]}"; do
 echo "$INDEX $KEY"
 ((INDEX=INDEX+1))
done  
                      
echo ""
echo "Enter a number to test the code"
read INDEX
VALUES=(${AvailableCode[@]})
clear ; cd ../out/repl.it/ ; java ${VALUES[$INDEX-1]}

