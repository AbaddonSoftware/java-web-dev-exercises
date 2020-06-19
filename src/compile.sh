#!/usr/bin/env bash
echo "This file compiles all source files even the launchcode" 
echo "ones which are not included in chooser"
echo "running this with clean like 'bash compile.sh clean'"
echo "will delete compiled classes if you need"
echo ""
echo "Would you like to proceed Y/N"
read RESPONSE
if [ "${RESPONSE,,}" = "y" ] || [ "${RESPONSE,,}" = "yes" ]; then
  echo "compiling sources to ../out/repl.it/"
  find -name "*.java" > sources
  javac -d ../out/repl.it @sources
  echo "this directory and subdirectories may be deleted
        as it's only useful when running code on repl.it" > ../out/repl.it/youcandelete.me
  rm sources
  read -n 1 -s -r -p "Press any key to continue"
  clear
fi 

if [ "${1,,}" = "clean" ]; then # comment: $1 is just the first commandline argument ,, = tolowercase
  echo "cleaning"
  rm -r ../out/repl.it
fi 
