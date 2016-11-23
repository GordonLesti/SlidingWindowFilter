#!/bin/bash

printf "                 ___       __ \n"
printf "    ____  __  __/ (_)___  / /_\n"
printf "   / __ \\/ / / / / / __ \\/ __/\n"
printf "  / /_/ / /_/ / / / / / / /_  \n"
printf " / .___/\\__, /_/_/_/ /_/\\__/  \n"
printf "/_/    /____/                 \n\n"

pylint src/ test/
PYLINT_RESULT=$?

printf "               _ __  __            __ \n"
printf "  __  ______  (_) /_/ /____  _____/ /_\n"
printf " / / / / __ \\/ / __/ __/ _ \\/ ___/ __/\n"
printf "/ /_/ / / / / / /_/ /_/  __(__  ) /_  \n"
printf "\\__,_/_/ /_/_/\\__/\\__/\\___/____/\\__/  \n\n"

python3 -m unittest test.test_experiment
UNITTEST_RESULT=$?

RESULT=$(($PYLINT_RESULT+$UNITTEST_RESULT))

exit $RESULT
