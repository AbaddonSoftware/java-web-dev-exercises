#!/usr/bin/env bash

AvailableCode=( "Exercise: Hello World"=exercises.HelloWorld
                "Exercise: Alice"=exercises.Alice
                "Exercise: Miles Per Gallon"=exercises.MilesPerGallon
                "Exercise: Rectangle"=exercises.Rectangle
                "Studio: Area Of A Circle"=org.launch.java.studios.areaofacircle.Area
                "Exercise: Array"=exercises.Array
                "Exercise: ArrayList"=exercises.ArrayList
                "Exercise: HashMap"=exercises.HashMap
                "Studio: Counting Characters"=org.launch.java.studios.abaddon.CharacterCounterExample )
                # add additional code above as "Name to be used in launcher"=codespackage.ClassName
                # no spaces may be used outside of the "quoted" portions including between the
                # equals (=) sign

                # changed this to use arrays so that it won't sort by hash

for Element in "${AvailableCode[@]}"
do
  Entry=( $(echo $Element | tr "=" "\n" | sed 's/ /_/g' ) )
  Name=(${Entry[0]})
  Class=(${Entry[1]})
  Names+=(${Name})
  Classes+=(${Class})
done

if [ ! -d out/repl.it ]; then
  echo "These sources have not been compiled yet."
  echo "YOU WILL NEED TO COMPILE THEM TO USE THIS SCRIPT."
  echo "This message only appears when they are not present."
  echo ""
  bash compile.sh
fi

INDEX=1;
for Name in "${Names[@]}"; do
 Name=$(echo $Name | sed 's/_/ /g')
 echo "$INDEX $Name"
 ((INDEX=INDEX+1))
done  
                      
echo ""
echo "Enter a number to test the code"
read INDEX
clear ; cd out/repl.it/ ; java ${Classes[$INDEX-1]}


