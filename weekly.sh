# compile backend stub
cd Phase2
javac -cp "junit-platform-console-standalone-1.8.2.jar" BackendStub.java
jar cvfe ot-backend-bnb.jar BackendStub BackendStub.class
cd ..

for i in {1..5}; do
    echo "Day $i"
    source daily.sh
done