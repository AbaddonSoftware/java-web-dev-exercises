#!/usr/bin/env bash

AvailableCode=( "Class1: Hello World"=exercises.HelloWorld
                "Class1: Alice"=exercises.Alice 
                "Class1: Miles Per Gallon"=exercises.MilesPerGallon
                "Studio1: AreaOfCircle"=org.launch.java.studios.areaofacircle.Area
                "Class2: Arrays"=exercises.Array
                "Class2: ArrayLists"=exercises.ArrayList
                "Class2: Hashmaps"=exercises.HashMap 
                "Studio2: Character Counter"=org.launch.java.studios.abaddon.CharacterCounterExample
                "Class3-4: Course Class"=org.launchcode.java.demos.lsn3classes1.SchoolPractice 
                "Class5: Car"=org.launchcode.java.demos.lsn5unittesting.main.Main 
                "Class5: Car Test"=org.launchcode.java.demos.lsn5unittesting.test.CarTest 
                "Class6: Computer, Laptop, Smartphone code"=exercises.technology.Program 
                "Class6: Computer Test"=exercises.technology.test.TestComputer 
                "Class6: Laptop Test"=exercises.technology.test.TestLaptop 
                "Class6: Smartphone Test"=exercises.technology.test.TestSmartPhone )
                
                # add additional code above as "Name to be used in launcher"=codespackage.ClassName
                # no spaces may be used outside of the "quoted" portions including between the
                # equals (=) sign

                # changed this to use arrays so that it won't sort by hash
                
                # Tests will be run if the Name includes the word test. Do not include test
                # in names that do not have Tests

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
if [[ "${Names[$INDEX-1],,}" == *"test"* ]]; 
then Test="org.junit.runner.JUnitCore" 
else Test="" 
fi
clear; cd out/repl.it/ ; java -cp .:lib/* $Test ${Classes[$INDEX-1]}
