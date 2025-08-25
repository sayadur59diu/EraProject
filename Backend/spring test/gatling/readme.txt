1.Start microdemo app
2.Open terminal in the gatling-test directory
run the following command: (one after the other) 

mvn gatling:test -Dgatling.simulationClass=simulations.TestCase1Simulation
mvn gatling:test -Dgatling.simulationClass=simulations.TestCase2Simulation
mvn gatling:test -Dgatling.simulationClass=simulations.TestCase3Simulation
mvn gatling:test -Dgatling.simulationClass=simulations.TestCase4Simulation
mvn gatling:test -Dgatling.simulationClass=simulations.TestCase5Simulation

To check the result:
- Please open the following report: link generated in the terminal.