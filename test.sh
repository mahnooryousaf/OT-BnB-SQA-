#!/usr/bin/bash

# Compile jar
cd Phase2
javac -cp "junit-platform-console-standalone-1.8.2.jar" *.java
jar cvfe ot-bnb.jar Home *.class
cd ..

passedTests=0
nTestsRun=0

# colour values for the tput command
GREEN=2
RED=1
WHITE=7


outputFolder="output"
inputFolder="input"
defaultRentalUnitsFileName="Available_Rental_Units_Basic.txt"
defaultUsersFileName="Current_Users_Basic.txt"

# Runs a single test.
# It takes in a single test name as input
runTest(){
    echo "$(tput bold)Running Test: $1"
        dailyTransactionsFile="$outputFolder/$1"
        dailyTransactionsFile+="_generated_output_transaction_file.txt"

        terminalInFile="$inputFolder/$1"
        terminalInFile+="_input.txt"

        generatedTerminalOutFile="$outputFolder/$1"
        generatedTerminalOutFile+="_generated_output_file.txt"

        correctTerminalOutFile="$outputFolder/$1"
        correctTerminalOutFile+="_output.txt"

        correctDailyTransactionsFile="$outputFolder/$1"
        correctDailyTransactionsFile+="_output_transaction_file.txt"

        rentalUnitsFile="$inputFolder/$1$'_'$defaultRentalUnitsFileName"
        usersFile="$inputFolder/$1$'_'$defaultUsersFileName"
        
        # use test specific input if it has any
        if [ ! -f "$rentalUnitsFile" ]; then
            rentalUnitsFile="../$defaultRentalUnitsFileName"
        fi

        if [ ! -f "$usersFile" ]; then
            usersFile="../$defaultUsersFileName"
        fi

        # run test
        java -jar ../../../Phase2/ot-bnb.jar "$usersFile" "$rentalUnitsFile" "$dailyTransactionsFile" < "$terminalInFile" > "$generatedTerminalOutFile"

        terminalOutDifference=$(diff "$correctTerminalOutFile" "$generatedTerminalOutFile")
        dailyTransactionsFileDifference=$(diff "$correctDailyTransactionsFile" "$dailyTransactionsFile")

        echo

        # display diff results
        diffTestsPassed=0
        [ -z "$terminalOutDifference" ] && echo "$(tput setaf $GREEN)Terminal Output Matches$(tput setaf $WHITE)" && diffTestsPassed+=1 || echo -e "$(tput setaf $RED)Terminal Output Is Not Correct$(tput setaf $WHITE)\n$terminalOutDifference"
        [ -z "$dailyTransactionsFileDifference" ] && echo "$(tput setaf $GREEN)Daily Transactions File Matches$(tput setaf $WHITE)" && diffTestsPassed+=1 || echo -e "$(tput setaf $RED)Daily Transactions File Is Not Correct$(tput setaf $WHITE)\n$dailyTransactionsFileDifference"
        echo
        echo

        # increment the number of tests passed if both terminal and daily transaction file outputs match with the expected outputs
        if [ "$diffTestsPassed" = "011" ]; then
            passedTests=$(($passedTests + 1))
        fi
}

# run tests
# Takes an array of tests as an argument
runTests(){
    tests=("$@")
    for test in ${tests[@]}; do
        runTest $test
        nTestsRun=$(($nTestsRun + 1))
    done
}

# run all the tests in the PHASE 1/Test Cases directory
cd PHASE\ 1/Test\ Cases

# if a particular test is specified run that test only
if [ ! -z "$1" ]; then
    foundTest="false"
    for test_group in */; do
        cd $test_group
        # Go into input folder to retrieve test names
        cd input
        for inputFile in *_input.txt; do
            IFS=_
            read testName rest <<< $inputFile
            if [ "$testName" = "$1" ]; then
                cd ..
                runTest $testName
                foundTest="true"
                break
            fi
        done
        # Go out of input folder
        cd ..
    
        # run each test
        cd ..

        if [ "$foundTest" = "true" ]; then
            break
        fi
    done
    if [ "$foundTest" = "false" ]; then
        echo "Could not find test"
    fi
    exit
fi

# no specific test is given so run all tests
for test_group in */; do
    cd $test_group
    echo "$(tput bold)GROUP: $test_group$(tput setaf $WHITE)"
    testsToRun=()

    # Go into input folder to retrieve test names
    cd input
    for inputFile in *_input.txt; do
        IFS=_
        read testName rest <<< $inputFile
        testsToRun+=( $testName )
    done
    # Go out of input folder
    cd ..
    
    # run each test
    runTests ${testsToRun[@]}
    cd ..
    echo
    echo
    echo
done
if [ "$nTestsRun" = "$passedTests" ]; then
    echo "$(tput setaf $GREEN)Passed: $(tput setaf $WHITE)$(($passedTests*100 / $nTestsRun))% | $passedTests of $nTestsRun tests passed"
else
    echo "$(tput setaf $GREEN)Failed: $(tput setaf $WHITE)$(($passedTests*100 / $nTestsRun))% | $passedTests of $nTestsRun tests passed"
fi
  