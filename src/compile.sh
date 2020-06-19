#!/usr/bin/env bash
#!/usr/bin/env bash
echo "This file compiles all source files even the launchcode" 
echo "ones which are not included in chooser"
echo "running this with clean like compile clean" 
echo "will delete compiled classes if you need"
echo ""
echo "Would you like to proceed Y/N"
read RESPONSE
if [ "${RESPONSE,,}" = "y" ] || [ "${RESPONSE,,}" = "yes" ]; then
  echo "compiling"
  find -name "*.java" > sources
  javac @sources
  rm sources
fi 

if [ "${1,,}" = "clean" ]; then
  echo "cleaning"
  find -name "*.class" > classes
  for file in $(cat classes) ; do
    rm "$file"
  done
  rm classes
fi 
