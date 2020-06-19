#!/usr/bin/env bash

declare -A AvailableCode

AvailableCode=( [Hello World]=exercises.HelloWorld
                [Alice]=exercises.Alice
                [Miles Per Gallon]=exercises.MilesPerGallon
                [Rectangle]=exercises.Rectangle
                [Area Of A Circle]=org.launch.java.studios.areaofacircle.Area )
                # add additional code above as [Key/Name to be used in launcher]=codespackage.ClassName

if [ ! -d out/repl.it ]; then
  echo "These sources have not been compiled yet."
  echo "YOU WILL NEED TO COMPILE THEM TO USE THIS SCRIPT."
  echo "This message only appears when they are not present."
  echo ""
  bash compile.sh
fi

INDEX=1;
for KEY in "${!AvailableCode[@]}"; do
 echo "$INDEX $KEY"
 ((INDEX=INDEX+1))
done  
                      
echo ""
echo "Enter a number to test the code"
read INDEX
VALUES=(${AvailableCode[@]})
clear ; cd out/repl.it/ ; java ${VALUES[$INDEX-1]}


