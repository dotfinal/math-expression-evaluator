#!/bin/bash
if [ ! -d "target" ]; then
./build.sh
fi
java -jar target/atconsulting-testapp-1.0-SNAPSHOT-jar-with-dependencies.jar $1
