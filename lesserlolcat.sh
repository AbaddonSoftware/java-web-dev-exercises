#!/usr/bin/env bash
# this was just a dumb idea that I had while playing with terminal colors for an error message
# based on the original lolcat. Someone will probably need to organize the colors to make this
# prettier/easier to read.
colorNumber=19
while IFS= read -r line; do
    for (( index=0; index<${#line}; index++ )); do
      echo -n -e "\e[38;5;${colorNumber}m${line:$index:1}"
      ((colorNumber=colorNumber+1))
     done
     echo ""
      if [ "$colorNumber" -ge "231" ]; then
        colorNumber=19
      fi
done

