baseFolder=Phase5Integration
outputFolder="output"
inputFolder="input"
transactionFileName="transaction"
rentalUnitsFileName="$baseFolder/Available_Rental_Units_Basic.txt"
usersFileName="$baseFolder/Current_Users_Basic.txt"
GREEN=2
RED=1
WHITE=7

# check if backend stub exists, if not compile code into executable jar
if [ ! -f "Phase2/ot-backend-bnb.jar" ]; then
    cd Phase2
    javac -cp "junit-platform-console-standalone-1.8.2.jar" BackendStub.java
    jar cvfe ot-backend-bnb.jar BackendStub BackendStub.class
    cd ..
fi

# get max merged transaction file
maxTransactionFileNumber=0
for mergedTransactionFile in $baseFolder/mtransaction*; do
    IFS=_
    read mfile currentTransactionFileNumber <<< $mergedTransactionFile
    if (( "$currentTransactionFileNumber" > "$maxTransactionFileNumber" )); then
        maxTransactionFileNumber=$currentTransactionFileNumber
    fi
done

maxTransactionFileNumber=$(( $maxTransactionFileNumber + 1 ))
first=true

# run sessions and generate transaction files
for sessionFolder in $baseFolder/sessions/*; do
    terminalInFile="$sessionFolder/$inputFolder"
    dailyTransactionsFile="$sessionFolder/$transactionFileName"
    generatedTerminalOutFile="$sessionFolder/$outputFolder"
    java -jar Phase2/ot-bnb.jar "$usersFileName" "$rentalUnitsFileName" "$dailyTransactionsFile" < "$terminalInFile" > "$generatedTerminalOutFile"
    
    # merge daily transactions file to previously merged daily transactions file
    cat $dailyTransactionsFile >> "$baseFolder/mtransaction_$maxTransactionFileNumber"
done

# TODO run backend stub
java -jar Phase2/ot-backend-bnb.jar "$baseFolder/mtransaction_$maxTransactionFileNumber" "$baseFolder/generated_rental_units_$maxTransactionFileNumber" "$baseFolder/generated_users_$maxTransactionFileNumber"
echo "$(tput setaf $WHITE)Generated $(tput setaf $GREEN)$baseFolder/mtransaction_$maxTransactionFileNumber"
echo "$(tput setaf $WHITE)Generated $(tput setaf $GREEN)$baseFolder/generated_rental_units_$maxTransactionFileNumber"
echo "$(tput setaf $WHITE)Generated $(tput setaf $GREEN)$baseFolder/generated_users_$maxTransactionFileNumber$(tput setaf $WHITE)"